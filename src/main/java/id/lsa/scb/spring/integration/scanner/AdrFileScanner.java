package id.lsa.scb.spring.integration.scanner;

import id.lsa.scb.utils.Adr;
import id.lsa.scb.utils.AdrUtil;
import id.lsa.scb.utils.PropertiesUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.SmartLifecycle;
import org.springframework.integration.file.DefaultDirectoryScanner;
import org.springframework.util.Assert;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

/**
 * Created by harji on 5/18/16.
 */
public class AdrFileScanner extends DefaultDirectoryScanner implements SmartLifecycle {
    private final static Logger logger = Logger.getLogger(AdrFileScanner.class);

    private final Path directory;

    private volatile WatchService watcher;

    private volatile int phase;

    private volatile boolean running;

    private volatile boolean autoStartup = true;

    private volatile Collection<File> initialFiles;

    private AdrUtil adrUtil;

    @Autowired
    private PropertiesUtil propertiesUtil;

    /**
     * Construct an instance for the given directory.
     *
     * @param directory the directory.
     */
    public AdrFileScanner(String directory) {

        this.directory = Paths.get(directory);
    }

    @Override
    public int getPhase() {
        return this.phase;
    }

    /**
     * see {@link #getPhase()}
     *
     * @param phase the phase.
     */
    public void setPhase(int phase) {
        this.phase = phase;
    }

    @Override
    public boolean isRunning() {
        return this.running;
    }

    /**
     * @param running true if running.
     * @see #isRunning()
     */
    public void setRunning(boolean running) {
        this.running = running;
    }

    @Override
    public boolean isAutoStartup() {
        return this.autoStartup;
    }

    /**
     * @param autoStartup true to auto start.
     * @see #isAutoStartup()
     */
    public void setAutoStartup(boolean autoStartup) {
        this.autoStartup = autoStartup;
    }

    @Override
    public synchronized void start() {


        if (!this.running) {
            try {
                this.watcher = FileSystems.getDefault().newWatchService();
            } catch (IOException e) {
                logger.error("Failed to create watcher for " + this.directory.toString(), e);
            }
            final Set<File> initialFiles = new HashSet<>();//walkDirectory(this.directory);
            for(Adr adr:adrUtil.getAdrs()){
                Path dir = Paths.get(adr.getDirectoryPath());
                initialFiles.addAll(walkDirectory(dir));
            }
            initialFiles.addAll(filesFromEvents());
            this.initialFiles = initialFiles;
            this.running = true;
        }
    }

    @Override
    public synchronized void stop() {
        if (this.running) {
            try {
                this.watcher.close();
            } catch (IOException e) {
                logger.error("Failed to close watcher for " + this.directory.toString(), e);
            }
            this.running = false;
        }
    }

    @Override
    public void stop(Runnable callback) {
        stop();
        callback.run();
    }

    @Override
    protected File[] listEligibleFiles(File directory) {
        Assert.state(this.watcher != null, "Scanner needs to be started");
        if (this.initialFiles != null) {
            File[] initial = this.initialFiles.toArray(new File[this.initialFiles.size()]);
            this.initialFiles = null;
            return initial;
        }
        Collection<File> files = filesFromEvents();
        return files.toArray(new File[files.size()]);
    }

    private Set<File> filesFromEvents() {
        WatchKey key = watcher.poll();
        Set<File> files = new LinkedHashSet<File>();
        while (key != null) {
            for (WatchEvent<?> event : key.pollEvents()) {
                if (event.kind() == StandardWatchEventKinds.ENTRY_CREATE) {
                    Path item = (Path) event.context();
                    File file = new File(((Path) key.watchable()).toAbsolutePath() + File.separator + item.getFileName());
                    if (logger.isDebugEnabled()) {
                        logger.debug("Watch Event: " + event.kind() + ": " + file);
                    }
                    if (file.isDirectory()) {
                        files.addAll(walkDirectory(file.toPath()));
                    } else {
                        files.add(file);
                    }
                } else if (event.kind() == StandardWatchEventKinds.ENTRY_MODIFY) {

                    Path item = (Path) event.context();
                    File file = new File(((Path) key.watchable()).toAbsolutePath() + File.separator + item.getFileName());
                    if (logger.isDebugEnabled()) {
                        logger.debug("Watch Event: " + event.kind() + ": " + file);
                    }
                    if (file.isDirectory()) {
                        files.addAll(walkDirectory(file.toPath()));
                    } else {
                        files.add(file);
                    }
                } else if (event.kind() == StandardWatchEventKinds.OVERFLOW) {
                    if (logger.isDebugEnabled()) {
                        logger.debug("Watch Event: " + event.kind() + ": context: " + event.context());
                    }
                    if (event.context() != null && event.context() instanceof Path) {
                        files.addAll(walkDirectory((Path) event.context()));
                    } else {
                        files.addAll(walkDirectory(this.directory));
                    }
                } else {
                    if (logger.isDebugEnabled()) {
                        logger.debug("Watch Event: " + event.kind() + ": context: " + event.context());
                    }
                }
            }
            key.reset();
            key = watcher.poll();
        }
        return files;
    }

    private Set<File> walkDirectory(Path directory) {
        final Set<File> walkedFiles = new LinkedHashSet<File>();
        try {
            registerWatch(directory);

            Files.walkFileTree(directory, new SimpleFileVisitor<Path>() {

                @Override
                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {

/*                        String dirStr = String.valueOf(dir);
                        int lastSlashIdx = dirStr.lastIndexOf("/")+1;
                        int lenghtDirStr =dirStr.length();
                        String dirName =dirStr.substring(lastSlashIdx,lenghtDirStr);

                        logger.info("dirname:"+dirName);*/
//                    String dirStr = String.valueOf(dir);


                    FileVisitResult fileVisitResult = super.preVisitDirectory(dir, attrs);
                    registerWatch(dir);
                    return fileVisitResult;

                }

                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    FileVisitResult fileVisitResult = super.visitFile(file, attrs);
                    walkedFiles.add(file.toFile());

                    return fileVisitResult;
                }

            });


            System.out.println("adrUtil " + adrUtil);
        } catch (IOException e) {
            logger.error("Failed to walk directory: " + directory.toString(), e);
        }
        return walkedFiles;
    }

    private void registerWatch(Path dir) throws IOException {
        logger.info("registerWatch");
        if (logger.isDebugEnabled()) {
            logger.debug("registering: " + dir + " for file creation events");
        }
        dir.register(this.watcher, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_MODIFY);
    }

    public AdrUtil getAdrUtil() {
        return adrUtil;
    }

    public void setAdrUtil(AdrUtil adrUtil) {
        this.adrUtil = adrUtil;
    }
}
