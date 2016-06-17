-- MySQL dump 10.16  Distrib 10.1.14-MariaDB, for Linux (x86_64)
--
-- Host: n0003    Database: adr
-- ------------------------------------------------------
-- Server version	10.1.14-MariaDB-1~jessie

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
-- Table structure for table `adr_configs`
--

DROP TABLE IF EXISTS `adr_configs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `adr_configs` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `COUNTRY_CODE` varchar(6) NOT NULL,
  `DIRECTORY_PATH` varchar(100) NOT NULL,
  `DIRECTORY_CODE` varchar(100) NOT NULL,
  `FILE_PATTERN` varchar(500) DEFAULT NULL,
  `TARGET_DATABASE` varchar(100) NOT NULL,
  `LOAD_TYPE` varchar(1) DEFAULT NULL,
  `RULE` varchar(50) DEFAULT NULL,
  `SEQUENCE` varchar(5) DEFAULT NULL,
  `EXCLUDING_SUBFOLDER` varchar(300) DEFAULT NULL,
  `ACTIVE` tinyint(1) DEFAULT '1',
  `OVERWRITE` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `adr_configs`
--

LOCK TABLES `adr_configs` WRITE;
/*!40000 ALTER TABLE `adr_configs` DISABLE KEYS */;
INSERT INTO `adr_configs` VALUES (1,'id','/apps/adr/sas/id/id_01','001','*.sas7bdat','id','H','replaceMxxWithYYYYMM','01','id_03',1,NULL),(2,'id','/apps/adr/sas/id/id_02','002','*.sas7bdat','id','H','replaceMxxWithYYYYMM','02','id_03',1,NULL),(3,'id','/apps/adr/sas/id/id_01','001','*_m01.sas7bdat','id','S',NULL,'03','id_03',1,NULL);
/*!40000 ALTER TABLE `adr_configs` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-06-01  9:21:36
