-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: ssafyweb
-- ------------------------------------------------------
-- Server version	8.0.35

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL,
  `password` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL,
  `email` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL,
  `joinDate` datetime DEFAULT NULL,
  `address` varchar(500) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL,
  `phone` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL,
  `role` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL,
  `dongCode` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'test1','1234','alice@example.com','2024-05-10 09:15:00','456 Elm Street, City, Country','+1987654321','user',NULL),(2,'test2','1234','bob@example.com','2024-05-10 10:30:00','789 Oak Street, City, Country','+1122334455','user',NULL),(3,'test3','1234','emily@example.com','2024-05-10 11:45:00','321 Pine Street, City, Country','+9988776655','user',NULL),(4,'test4','1234','sarah@example.com','2024-05-10 13:00:00','111 Maple Street, City, Country','+1122334455','user',NULL),(5,'test5','1234','michael@example.com','2024-05-10 14:15:00','222 Cedar Street, City, Country','+9988776655','user',NULL),(6,'test6','1234','emma@example.com','2024-05-10 15:30:00','333 Birch Street, City, Country','+1122334455','user',NULL),(7,'test7','1234','james@example.com','2024-05-10 16:45:00','444 Pine Street, City, Country','+9988776655','user',NULL),(8,'test8','1234','olivia@example.com','2024-05-10 18:00:00','555 Oak Street, City, Country','+1122334455','user',NULL),(9,'test9','1234','william@example.com','2024-05-10 19:15:00','666 Elm Street, City, Country','+9988776655','user',NULL),(10,'test10','1234','sophia@example.com','2024-05-10 20:30:00','777 Maple Street, City, Country','+1122334455','user',NULL),(11,'test11','1234','benjamin@example.com','2024-05-10 21:45:00','888 Cedar Street, City, Country','+9988776655','user',NULL),(12,'test12','1234','isabella@example.com','2024-05-10 23:00:00','999 Birch Street, City, Country','+1122334455','user',NULL),(13,'test13','1234','ethan@example.com','2024-05-11 00:15:00','101010 Pine Street, City, Country','+9988776655','user',NULL),(14,'admin','1234','ethsan@example.com','2024-05-11 00:15:00','101010 Pine Street, City, Country','+9988776655','admin',NULL),(15,'박정영','$2a$10$cGtkyWg6K249iBBkg495G.P9OW2LoKIEKUJ2HM8kefSoMJyr2NTmq','asd@asd.com','2024-05-20 02:53:03','서울 동대문구 전농동 644-87','010-1234-1234','user','1123010400'),(24,'aaa','$2a$10$acpZvcw956jiKj1jUecjSOekV7Aw.P91IWd.9VclLCDSRUphnAFfq','aaa@aaa.aaa','2024-05-22 02:19:27','aaa','aaa','user',NULL),(25,'111','$2a$10$SilvRkKNDfbhk63mjfzNjO3YC8/hhZC1VvCO14xII/K.Adw8uGtxW','111@111','2024-05-23 03:25:12','111','111','user',NULL),(26,'222','$2a$10$fe4EFKQ9FP2R./u7Iq9Yp.hKdbo3kNyVvhRxdkpGCCMUd3zFP/o0q','222@222','2024-05-23 03:25:58','222','222','user',NULL),(27,'김김김','$2a$10$BGkmJOASs3zxMSpMIPpzJ.nvo9zxKMmNrm/3vjJIBPeMv/oYEG6i.','ccc@ccc.ccc','2024-05-23 05:17:19','서울 동대문구 전농동 571-8','111','user','1123010500');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-23 18:06:29
