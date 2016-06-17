package id.lsa.scb.spring.integration.filter;

import id.lsa.scb.utils.Adr;
import id.lsa.scb.utils.AdrUtil;
import id.lsa.scb.utils.FileUtil;
import id.lsa.scb.utils.PropertiesUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.file.filters.AbstractFileListFilter;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by harji on 5/18/16.
 */
public class EntireFileFilter extends AbstractFileListFilter {

    /**
     * logger
     **/
    private Logger logger = Logger.getLogger(EntireFileFilter.class);
    /**
     * file entry
     **/
    Map<String, Long> fileEntry = new HashMap<String, Long>();

    @Autowired
    private PropertiesUtil propertiesUtil;

    @Autowired
    private AdrUtil adrUtil;


//
//    String[] extensionsStr = PropertiesUtil.getProperty("source.fileName").split(";");//adrUtil.getExcludingSubFolder().split(";");
//    //    String sasDir = propertiesUtil.getProperty("sas.dir");
//    List<String> extensionss = Arrays.asList(extensionsStr);

    @Override
    protected boolean accept(Object object) {
        File file = (File) object;
        boolean result =true;
        try {

            Adr adr = new Adr();
            String fileName = file.getName(); // can get absolute file path from here
            String absolutePath = file.getAbsolutePath();
            String path = absolutePath.replace("/"+fileName, "");
            String rootPath = adrUtil.getSourceRootDir();

            //get mapping source rule
            Map<String, String> params = new HashMap<>();
            for(Adr ad:adrUtil.getAdrs()){
                params.putAll(ad.getParams());
                if(FileUtil.priorityConfigChecker(path,ad.getDirectoryPath())){
                    adr = ad;
                }
//                if(FileUtil.priorityChecker(path, rootPath, params)){
//                    adr = ad;
//                }
            }

//            for(Adr ad:adrUtil.getAdrs()){
//                if(FileUtil.priorityConfigChecker(path,ad.getDirectoryPath())){
//                    adr = ad;
//                }
//            }

//            for(Adr ad:adrUtil.getAdrs()){
//                // checker priority
//                if(FileUtil.priorityChecker(path, rootPath, params)){
//                    adr = ad;
//                }
//            }

            result= FileUtil.filePatternChecker(fileName, adr.getFilePattern());

            return result;
        } catch (Exception e) {
            return false;
        }
    }

    public void setAdrUtil(AdrUtil adrUtil) {
        this.adrUtil = adrUtil;
    }

}
