package id.lsa.scb.utils;

import java.io.*;
import java.util.Properties;

/**
 * Created by harji on 4/8/16.
 */
public class CredentialUtil {

    private static CredentialUtil instance = null;

    private Properties props = null;

    private CredentialUtil() {
        // Here you could read the file into props object
        try {
            this.props = readProperties();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static synchronized CredentialUtil getInstance() {
        if (instance == null)
            instance = new CredentialUtil();
        return instance;
    }

    public String getValue(String propKey) {
        return this.props.getProperty(propKey);
    }

    private Properties readProperties() throws IOException {
        File configFile = new File("./conf/config.properties");
        Properties props = new Properties();
        FileReader reader = null;
        String resourceName = "config.properties";
        ClassLoader loader = Thread.currentThread().getContextClassLoader();

        try {
            reader = new FileReader(configFile);
//            InputStream resourceStream = loader.getResourceAsStream(resourceName);
//            props.load(resourceStream);
              props.load(reader);


            reader.close();
        } catch (FileNotFoundException ex) {

            // file does not exist
        } catch (IOException ex) {
            // I/O error
        } finally {
            if (reader != null) {
                reader.close();
                reader = null;
            }
        }
        return props;
    }
}

