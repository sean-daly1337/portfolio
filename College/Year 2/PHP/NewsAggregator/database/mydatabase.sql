CREATE DATABASE  IF NOT EXISTS `mydatabase` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `mydatabase`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: mydatabase
-- ------------------------------------------------------
-- Server version	5.5.5-10.1.34-MariaDB

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
-- Table structure for table `wm_articles`
--

DROP TABLE IF EXISTS `wm_articles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `wm_articles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `category_id` int(11) NOT NULL,
  `title` varchar(250) NOT NULL,
  `description` text NOT NULL,
  `link` varchar(250) NOT NULL,
  `pubDate` varchar(250) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wm_articles`
--

LOCK TABLES `wm_articles` WRITE;
/*!40000 ALTER TABLE `wm_articles` DISABLE KEYS */;
/*!40000 ALTER TABLE `wm_articles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wm_categories`
--

DROP TABLE IF EXISTS `wm_categories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `wm_categories` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(250) NOT NULL,
  `description` text NOT NULL,
  `feed` varchar(250) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wm_categories`
--

LOCK TABLES `wm_categories` WRITE;
/*!40000 ALTER TABLE `wm_categories` DISABLE KEYS */;
INSERT INTO `wm_categories` VALUES (1,'New Scientist - Humans','New Scientist - Humans','http://feeds.newscientist.com/humans/','2019-04-06 13:55:58'),(2,'New Scientist - Physics','New Scientist - Physics','http://feeds.newscientist.com/physics-math/','2019-04-06 14:28:56'),(3,'New Scientist - Earth','New Scientist - Earth','http://feeds.newscientist.com/environment/','2019-04-06 14:29:58'),(4,'New Scientist - Health','New Scientist - Health','http://feeds.newscientist.com/health/','2019-04-06 14:29:58'),(5,'New Scientist - Space','New Scientist - Space','http://feeds.newscientist.com/space/','2019-04-06 14:30:28');
/*!40000 ALTER TABLE `wm_categories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wm_users`
--

DROP TABLE IF EXISTS `wm_users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `wm_users` (
  `userid` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `emailadd` varchar(50) NOT NULL,
  `gender` varchar(50) NOT NULL,
  `city` varchar(50) NOT NULL,
  `country` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `type_of_user` enum('user','admin') NOT NULL,
  PRIMARY KEY (`userid`),
  UNIQUE KEY `emailadd` (`emailadd`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wm_users`
--

LOCK TABLES `wm_users` WRITE;
/*!40000 ALTER TABLE `wm_users` DISABLE KEYS */;
INSERT INTO `wm_users` VALUES (11,'Sean','Daly','sean@yahoo.com','Male','Nenagh','Ireland','202cb962ac59075b964b07152d234b70','user'),(12,'John','Madden','John@yahoo.com','Male','Limerick','Ireland','202cb962ac59075b964b07152d234b70','user'),(13,'admin','a','admin@yahoo.com','Male','s','s','202cb962ac59075b964b07152d234b70','admin'),(14,'Pauric','Keeshan','Pauric@yahoo.com','Male','Nenagh','Ireland','202cb962ac59075b964b07152d234b70','user'),(15,'Peter','Parker','Peter@gmail.com','Male','Dublin','Ireland','81dc9bdb52d04dc20036dbd8313ed055','user');
/*!40000 ALTER TABLE `wm_users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-04-24 17:31:59
