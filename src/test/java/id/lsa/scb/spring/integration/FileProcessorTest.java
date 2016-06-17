package id.lsa.scb.spring.integration;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by harji on 4/15/16.
 */
public class FileProcessorTest {
    private Logger logger = Logger.getLogger(FileProcessorTest.class);

    @Before
    public void createDirectory(){
//        File directory = new File("sasdir");
//        if (directory.exists()){
//            directory.delete();
//        }
//        directory.mkdir();
    }

    @Test
    public void testConcurrentFileProcessing() throws Exception {
        logger.info("\n\n#### Starting Concurrent processing test #### ");
        String extensions = "sas7bdat";

        String[] extensionsStr = extensions.split(";");
        //    String sasDir = propertiesUtil.getProperty("sas.dir");
        List<String> extensionss = Arrays.asList(extensionsStr);

        logger.info("extensionss"+extensionss.isEmpty());

        boolean a =false;
        boolean b =false;

        if(a||b){
            logger.info("true");
        }

    }

}
