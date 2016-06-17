-- MySQL dump 10.13  Distrib 5.5.49, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: adr
-- ------------------------------------------------------
-- Server version	5.5.49-0+deb8u1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `adr_process_logs`
--

DROP TABLE IF EXISTS `adr_process_logs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `adr_process_logs` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `COUNTRY_CODE` varchar(6) NOT NULL,
  `DIRECTORY_PATH` text,
  `FILENAME` text,
  `TARGET_DATABASE` varchar(100) DEFAULT NULL,
  `TARGET_TABLENAME` varchar(200) DEFAULT NULL,
  `LOG_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `RULE_APPLIED` varchar(200) DEFAULT NULL,
  `STATUS` varchar(100) DEFAULT NULL,
  `STAGE` varchar(100) DEFAULT NULL,
  `MESSAGE` text,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `adr_process_logs`
--

LOCK TABLES `adr_process_logs` WRITE;
/*!40000 ALTER TABLE `adr_process_logs` DISABLE KEYS */;
INSERT INTO `adr_process_logs` VALUES (1,'id','/home/harji/Workspace/Project/BigData/Project_Src/scb_project/sasdir/id/id_04','a_bcrs_capital_calc_200904.sas7bdat','id','ae_ftp_fiildgrf_151106_bdc_smry_004','2016-06-17 06:48:01',NULL,'Failure','Import JSON failed','org.springframework.messaging.MessageHandlingException: HTTP request execution failed for URI [http://52.76.250.122:9090/rest/import-job]; nested exception is org.springframework.web.client.ResourceAccessException: I/O error on POST request for \"http://52.76.250.122:9090/rest/import-job\": Connection refused; nested exception is java.net.ConnectException: Connection refused'),(2,'id','/home/harji/Workspace/Project/BigData/Project_Src/scb_project/sasdir/id/id_04','a_bcrs_capital_calc_200904.sas7bdat','id','ae_ftp_fiildgrf_151106_bdc_smry_004','2016-06-17 06:48:01',NULL,'Failure','Import JSON failed','org.springframework.messaging.MessageHandlingException: HTTP request execution failed for URI [http://52.76.250.122:9090/rest/import-job]; nested exception is org.springframework.web.client.ResourceAccessException: I/O error on POST request for \"http://52.76.250.122:9090/rest/import-job\": Connection refused; nested exception is java.net.ConnectException: Connection refused'),(3,'id','/home/harji/Workspace/Project/BigData/Project_Src/scb_project/sasdir/id/id_04','ae_ftp_fiildgrf_151106_bdc_smry.sas7bdat','id','ae_ftp_fiildgrf_151106_bdc_smry_004','2016-06-17 06:48:54',NULL,'Failure','Import JSON failed','org.springframework.messaging.MessageHandlingException: HTTP request execution failed for URI [http://52.76.250.122:9090/rest/import-job]; nested exception is org.springframework.web.client.ResourceAccessException: I/O error on POST request for \"http://52.76.250.122:9090/rest/import-job\": Connection refused; nested exception is java.net.ConnectException: Connection refused'),(4,'id','/home/harji/Workspace/Project/BigData/Project_Src/scb_project/sasdir/id/id_04','ae_ftp_fiildgrf_151106_bdc_smry.sas7bdat','id','ae_ftp_fiildgrf_151106_bdc_smry_004','2016-06-17 06:48:54',NULL,'Failure','Import JSON failed','org.springframework.messaging.MessageHandlingException: HTTP request execution failed for URI [http://52.76.250.122:9090/rest/import-job]; nested exception is org.springframework.web.client.ResourceAccessException: I/O error on POST request for \"http://52.76.250.122:9090/rest/import-job\": Connection refused; nested exception is java.net.ConnectException: Connection refused'),(5,'id','/home/harji/Workspace/Project/BigData/Project_Src/scb_project/sasdir/id/id_04','a_bcrs_capital_calc_200904.sas7bdat','id','ae_ftp_fiildgrf_151106_bdc_smry_004','2016-06-17 06:49:40',NULL,'Start job failed','Start import job','{jobStatus=ERROR, id=456}'),(6,'id','/home/harji/Workspace/Project/BigData/Project_Src/scb_project/sasdir/id/id_04','ae_ftp_fiildgrf_151106_bdc_smry.sas7bdat','id','ae_ftp_fiildgrf_151106_bdc_smry_004','2016-06-17 06:49:40',NULL,'Start job failed','Start import job','{jobStatus=ERROR, id=457}');
/*!40000 ALTER TABLE `adr_process_logs` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-06-17 14:17:00
