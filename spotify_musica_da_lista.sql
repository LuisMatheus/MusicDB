CREATE DATABASE  IF NOT EXISTS `spotify` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `spotify`;
-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: spotify
-- ------------------------------------------------------
-- Server version	5.7.11-log

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
-- Table structure for table `musica_da_lista`
--

DROP TABLE IF EXISTS `musica_da_lista`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `musica_da_lista` (
  `lista_id` int(11) NOT NULL,
  `musica_id` int(11) NOT NULL,
  `qtde_vezes_tocada` int(11) NOT NULL,
  PRIMARY KEY (`lista_id`,`musica_id`),
  KEY `fk_lista_has_musica_musica1_idx` (`musica_id`),
  KEY `fk_lista_has_musica_lista1_idx` (`lista_id`),
  CONSTRAINT `fk_lista_has_musica_lista1` FOREIGN KEY (`lista_id`) REFERENCES `lista` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_lista_has_musica_musica1` FOREIGN KEY (`musica_id`) REFERENCES `musica` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `musica_da_lista`
--

LOCK TABLES `musica_da_lista` WRITE;
/*!40000 ALTER TABLE `musica_da_lista` DISABLE KEYS */;
INSERT INTO `musica_da_lista` VALUES (1,2,8),(1,11,7),(1,13,7),(1,15,7),(1,16,7),(1,18,7),(8,1,6),(8,2,7),(8,3,8),(8,4,9),(8,5,10),(8,6,11),(8,7,12),(8,8,13),(8,9,14),(8,10,15),(8,11,16),(8,12,17),(8,13,18),(8,14,19),(8,15,20),(8,16,21),(8,17,22),(8,18,23),(8,19,24);
/*!40000 ALTER TABLE `musica_da_lista` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-05-30 22:31:10
