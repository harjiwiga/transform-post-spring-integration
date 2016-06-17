//package id.lsa.scb.spring.integration;
//
//import id.lsa.scb.utils.PropertiesUtil;
//import org.apache.log4j.Logger;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.messaging.Message;
//import org.springframework.messaging.PollableChannel;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import java.util.HashMap;
//
///**
// * Created by harji on 4/18/16.
// */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"classpath*:http-outbound-config.xml"})
//public class TestTransformer {
//
//    private static Logger logger = Logger.getLogger(TestTransformer.class);
//
//    @Autowired
//    @Qualifier("outJsonMap")
//    private PollableChannel pollableChannel;
//
//    @Autowired
//    private PropertiesUtil propertyUtil;
//
//
//    @Test
//    public void testTransformer() {
////        importConstructor.setTestName("harji");
//        logger.info("propertyddir" + propertyUtil.getProperty("sas.dir"));
//    }
//
//    @Test
//    public void testFileTransformer() {
//
//
//        Message<?> message2 = pollableChannel.receive();
////        logger.info("Finished processing2 payload: " + message2.getPayload());
//        for(int i=0;i<3;i++) {
//            HashMap<String, Object> mapJob = (HashMap<String, Object>) message2.getPayload();
//            logger.info("size: "+mapJob.size());
//        }
//
////        ImportJob importJob = (ImportJob) mapJob.get("ImportJob");
//
//    }
//}