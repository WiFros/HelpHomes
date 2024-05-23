use ssafyweb;

DROP TABLE IF EXISTS `board`;
CREATE TABLE `board` (
  `num` int NOT NULL AUTO_INCREMENT,
  `writer` varchar(20) COLLATE utf8mb3_bin NOT NULL,
  `wdate` datetime NOT NULL,
  `title` varchar(40) COLLATE utf8mb3_bin NOT NULL,
  `content` varchar(100) COLLATE utf8mb3_bin NOT NULL,
  `count` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`NUM`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin;

--
-- Dumping data for table `board`
--

INSERT INTO `board` VALUES (1,'Mel Gibson','2024-03-20 11:50:28','게시판 연습1','게시판연습입니다.',0),(2,'Mel Gibson','2024-03-20 11:50:28','게시판 연습2','게시판연습입니다.',0),(3,'Mel Gibson','2024-03-20 11:50:28','게시판 연습3','게시판연습입니다.',0),(4,'Mel Gibson','2024-03-20 11:50:28','게시판 연습4','게시판연습입니다.',0),(5,'Mel Gibson','2024-03-20 11:50:28','게시판 연습5','게시판연습입니다.',0),(6,'Mel Gibson','2024-03-20 11:50:28','게시판 연습6','게시판연습입니다.',0),(7,'Mel Gibson','2024-03-20 11:50:28','게시판 연습7','게시판연습입니다.',2),(8,'Mel Gibson','2024-03-20 11:50:28','게시판 연습8','게시판연습입니다.',0),(9,'Mel Gibson','2024-03-20 11:50:28','게시판 연습9','게시판연습입니다.',0),(10,'Mel Gibson','2024-03-20 11:50:28','게시판 연습10','게시판연습입니다.',0),(11,'Mel Gibson','2024-03-20 11:50:28','게시판 연습11','게시판연습입니다.',0),(12,'Mel Gibson','2024-03-20 11:50:28','게시판 연습12','게시판연습입니다.',0),(13,'Mel Gibson','2024-03-20 11:50:28','게시판 연습13','게시판연습입니다.',1),(14,'Mel Gibson','2024-03-20 11:50:28','게시판 연습14','게시판연습입니다.',0),(15,'Mel Gibson','2024-03-20 11:50:28','게시판 연습15','게시판연습입니다.',1);
commit;