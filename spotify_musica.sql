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
-- Table structure for table `musica`
--

DROP TABLE IF EXISTS `musica`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `musica` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `cantor` varchar(45) NOT NULL,
  `nome_arquivo` varchar(100) NOT NULL,
  `album_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_musica_album_idx` (`album_id`),
  CONSTRAINT `fk_musica_album` FOREIGN KEY (`album_id`) REFERENCES `album` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `musica`
--

LOCK TABLES `musica` WRITE;
/*!40000 ALTER TABLE `musica` DISABLE KEYS */;
INSERT INTO `musica` VALUES (1,'Take a Bow','MUSE','Audio/Black Holes And Revelations/Take A Bow.mp3',2),(2,'Starlight','MUSE','Audio/Black Holes And Revelations/Starlight.mp3',2),(3,'Supermassive Black Hole','MUSE','Audio/Black Holes And Revelations/Supermassive Black Hole.mp3',2),(4,'Map Of The Problematique','MUSE','Audio/Black Holes And Revelations/Map Of The Problematique.mp3',2),(5,"Soldier's Poem",'MUSE',"Audio/Black Holes And Revelations/Soldier's Poem.mp3",2),(6,'Invincible','MUSE','Audio/Black Holes And Revelations/Invincible.mp3',2),(7,'Assassin','MUSE','Audio/Black Holes And Revelations/Assassin.mp3',2),(8,'Exo-politics','MUSE','Audio/Black Holes And Revelations/Exo-politics.mp3',2),(9,'City Of Delusion','MUSE','Audio/Black Holes And Revelations/City Of Delusion.mp3',2),(10,'Hoodoo','MUSE','Audio/Black Holes And Revelations/Hoodoo.mp3',2),(11,'Knights Of Cydonia','MUSE','Audio/Black Holes And Revelations/Knights Of Cydonia.mp3',2),(12,'Stand Up And Shout','Dio','Audio/Holy Diver/Stand Up And Shout.mp3',1),(13,'Holy Diver','Dio','Audio/Holy Diver/Holy Diver.mp3',1),(14,'Gypsy','Dio','Audio/Holy Diver/Gypsy.mp3',1),(15,"Don't Talk To Strangers",'Dio',"Audio/Holy Diver/Don't Talk To Strangers.mp3",1),(16,'Straight Through The Heart','Dio','Audio/Holy Diver/Straight Through The Heart.mp3',1),(17,'Invisible','Dio','Audio/Holy Diver/Invisible.mp3',1),(18,'Rainbow In The Dark','Dio','Audio/Holy Diver/Rainbow In The Dark.mp3',1),(19,'Shame On The Night','Dio','Audio/Holy Diver/Shame On The Night.mp3',1);
/*!40000 ALTER TABLE `musica` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-05-30 22:31:11
