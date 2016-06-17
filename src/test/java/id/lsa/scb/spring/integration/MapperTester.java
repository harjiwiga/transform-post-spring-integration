//package id.lsa.scb.spring.integration;
//
//
//import id.lsa.scb.constructors.ImportConstructor;
//import id.lsa.scb.spring.integration.transformation.FieldToJson;
//import id.lsa.scb.utils.PropertiesUtil;
//import org.apache.log4j.Logger;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
///**
// * Created by harji on 4/18/16.
// */
//@RunWith(SpringJUnit4ClassRunner.class)
////@ContextConfiguration(locations = {"/http-outbound-config.xml"})
//@ContextConfiguration(locations = {"classpath*:http-outbound-config.xml"})
//public class MapperTester {
//
//    @Autowired
//    public ImportConstructor importConstructor;
//    private static Logger logger = Logger.getLogger(MapperTester.class);
//
//    @Autowired
//    private PropertiesUtil propertyUtil;
//
//    @Autowired
//    private FieldToJson fieldToJson;
//
//    @Test
//    public void testMapper() {
////        importConstructor.setTestName("harji");
//        logger.info("propertyddir" + propertyUtil.getProperty("sas.dir"));
//
//    }
//}
