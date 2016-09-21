-- MySQL dump 10.13  Distrib 5.6.16, for Win64 (x86_64)
--
-- Host: localhost    Database: poo22016
-- ------------------------------------------------------
-- Server version	5.6.16

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
-- Table structure for table `alumnos`
--

DROP TABLE IF EXISTS `alumnos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `alumnos` (
  `codi_alum` int(11) NOT NULL AUTO_INCREMENT,
  `nomb_alum` varchar(100) NOT NULL,
  `apel_alum` varchar(100) NOT NULL,
  `fech_naci_alum` date NOT NULL,
  `mail_alum` varchar(100) NOT NULL,
  `tele_alum` varchar(20) NOT NULL,
  `dire_alum` varchar(200) NOT NULL,
  `gene_alum` char(1) NOT NULL,
  PRIMARY KEY (`codi_alum`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alumnos`
--

LOCK TABLES `alumnos` WRITE;
/*!40000 ALTER TABLE `alumnos` DISABLE KEYS */;
INSERT INTO `alumnos` VALUES (1,'Juan','Perez','1987-08-22','rr','22','SS','M'),(2,'Mauricio','González','1987-08-22','rajm.16@hotmail.com','78552595','San Salvador','M'),(3,'Richard','Pérez','1990-02-01','richard@gmail.com','22252895','SM','M'),(4,'Carlos','Díaz','2005-03-03','carlos@aaa.com','5555-1312','SM','M');
/*!40000 ALTER TABLE `alumnos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cursos`
--

DROP TABLE IF EXISTS `cursos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cursos` (
  `codi_curs` int(11) NOT NULL AUTO_INCREMENT,
  `nomb_curs` varchar(100) NOT NULL,
  `dura_curs` int(11) NOT NULL,
  `cost_curs` double NOT NULL,
  PRIMARY KEY (`codi_curs`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cursos`
--

LOCK TABLES `cursos` WRITE;
/*!40000 ALTER TABLE `cursos` DISABLE KEYS */;
/*!40000 ALTER TABLE `cursos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `grupos`
--

DROP TABLE IF EXISTS `grupos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `grupos` (
  `codi_grup` int(11) NOT NULL AUTO_INCREMENT,
  `nomb_grup` varchar(100) NOT NULL,
  `fech_inic_grup` date NOT NULL,
  `fech_fina_grup` date NOT NULL,
  `hora_inic_grup` varchar(5) NOT NULL,
  `hora_fina_grup` varchar(5) NOT NULL,
  `codi_curs` int(11) NOT NULL,
  `codi_prof` int(11) NOT NULL,
  PRIMARY KEY (`codi_grup`),
  KEY `profesores_grupos_fk` (`codi_prof`),
  KEY `cursos_grupos_fk` (`codi_curs`),
  CONSTRAINT `cursos_grupos_fk` FOREIGN KEY (`codi_curs`) REFERENCES `cursos` (`codi_curs`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `profesores_grupos_fk` FOREIGN KEY (`codi_prof`) REFERENCES `profesores` (`codi_prof`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grupos`
--

LOCK TABLES `grupos` WRITE;
/*!40000 ALTER TABLE `grupos` DISABLE KEYS */;
/*!40000 ALTER TABLE `grupos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `grupos_alumnos`
--

DROP TABLE IF EXISTS `grupos_alumnos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `grupos_alumnos` (
  `codi_grup_alum` int(11) NOT NULL AUTO_INCREMENT,
  `codi_grup` int(11) NOT NULL,
  `codi_alum` int(11) NOT NULL,
  `esta_grup_alum` char(1) NOT NULL,
  PRIMARY KEY (`codi_grup_alum`),
  KEY `grupos_grupos_alumnos_fk` (`codi_grup`),
  KEY `alumnos_grupos_alumnos_fk` (`codi_alum`),
  CONSTRAINT `alumnos_grupos_alumnos_fk` FOREIGN KEY (`codi_alum`) REFERENCES `alumnos` (`codi_alum`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `grupos_grupos_alumnos_fk` FOREIGN KEY (`codi_grup`) REFERENCES `grupos` (`codi_grup`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grupos_alumnos`
--

LOCK TABLES `grupos_alumnos` WRITE;
/*!40000 ALTER TABLE `grupos_alumnos` DISABLE KEYS */;
/*!40000 ALTER TABLE `grupos_alumnos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `profesores`
--

DROP TABLE IF EXISTS `profesores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `profesores` (
  `codi_prof` int(11) NOT NULL AUTO_INCREMENT,
  `nomb_prof` varchar(100) NOT NULL,
  `apel_prof` varchar(100) NOT NULL,
  `mail_prof` varchar(100) NOT NULL,
  `tele_prof` varchar(20) NOT NULL,
  `dire_pro` varchar(200) NOT NULL,
  PRIMARY KEY (`codi_prof`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `profesores`
--

LOCK TABLES `profesores` WRITE;
/*!40000 ALTER TABLE `profesores` DISABLE KEYS */;
/*!40000 ALTER TABLE `profesores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuarios` (
  `codi_usua` int(11) NOT NULL AUTO_INCREMENT,
  `codi_alum` int(11) DEFAULT NULL,
  `acce_usua` varchar(100) NOT NULL,
  `cont_usua` varchar(100) DEFAULT NULL,
  `esta_usua` int(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`codi_usua`),
  KEY `fk_usua_alum` (`codi_alum`),
  CONSTRAINT `fk_usua_alum` FOREIGN KEY (`codi_alum`) REFERENCES `alumnos` (`codi_alum`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,2,'demo','123456',1);
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-09-21 14:06:03
