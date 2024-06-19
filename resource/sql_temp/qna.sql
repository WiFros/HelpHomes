CREATE TABLE `qna` (
  `num` int NOT NULL AUTO_INCREMENT,
  `writer` varchar(16) COLLATE utf8mb3_bin DEFAULT NULL,
  `wdate` varchar(100) COLLATE utf8mb3_bin DEFAULT NULL,
  `title` varchar(2000) COLLATE utf8mb3_bin DEFAULT NULL,
  `content` varchar(2000) COLLATE utf8mb3_bin DEFAULT NULL,
  `count` int DEFAULT NULL,
  `status` varchar(20) COLLATE utf8mb3_bin DEFAULT NULL,
  PRIMARY KEY (`num`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

select * from qna;


INSERT INTO qna (writer, wdate, title, content, count, status)
VALUES ('happyssafy', now(), 'the thing is', 'blahblahblah', 0, "unresolved");
