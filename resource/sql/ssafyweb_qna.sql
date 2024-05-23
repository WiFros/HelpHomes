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
-- Table structure for table `qna`
--

DROP TABLE IF EXISTS `qna`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `qna` (
  `num` int NOT NULL AUTO_INCREMENT,
  `writer` varchar(16) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL,
  `wdate` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL,
  `title` varchar(2000) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL,
  `content` varchar(2000) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL,
  `answer` varchar(2000) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL,
  `adate` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL,
  `count` int DEFAULT NULL,
  `status` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL,
  `writerId` int DEFAULT NULL,
  CONSTRAINT `users_ibfk_1` FOREIGN KEY (`writerId`) REFERENCES `users` (`id`),
  PRIMARY KEY (`num`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qna`
--

INSERT INTO `qna` (`writer`, `wdate`, `title`, `content`, `answer`, `adate`, `count`, `status`, `writerId`) VALUES
('김*현', '2023-05-01', '비밀번호 재설정 방법?', '비밀번호를 잊어버렸습니다. 어떻게 재설정할 수 있나요?', '로그인 페이지에서 "비밀번호 찾기" 링크를 클릭하여 비밀번호를 재설정할 수 있습니다.', '2023-05-02', 10, '답변완료', 15),
('김*현', '2023-05-02', '이메일 변경 방법?', '계정에 연결된 이메일을 변경하고 싶습니다.', '계정 설정에서 이메일 주소를 업데이트하여 변경할 수 있습니다.', '2023-05-03', 8, '답변완료', 15),
('김*현', '2023-05-03', '결제 문제', '구독료가 두 번 청구되었습니다. 어떻게 해야 하나요?', '주문 상세 정보를 가지고 지원팀에 연락하시면 환불 처리해드리겠습니다.', '2023-05-04', 15, '답변완료', 15),
('김*현', '2023-05-04', '계정 삭제 방법?', '계정을 영구적으로 삭제하고 싶습니다.', '탈퇴하게 되어 유감입니다. 계정 삭제를 진행하려면 지원팀에 연락해 주세요.', '2023-05-05', 12, '답변완료', 15),
('김*현', '2023-05-05', '구독 업그레이드 방법?', '현재 구독 플랜을 업그레이드할 수 있나요?', '계정 설정 페이지에서 구독 플랜을 업그레이드할 수 있습니다.', '2023-05-06', 5, '답변완료', 15),
('김*현', '2023-05-06', '기능 요청', '앱에 다크 모드를 추가해 주실 수 있나요?', '제안해 주셔서 감사합니다. 향후 업데이트에서 고려하겠습니다.', '2023-05-07', 7, '답변완료', 15),

('곽*철', '2023-05-07', '지원팀에 연락하는 방법?', '계정에 문제가 있습니다. 지원팀에 어떻게 연락할 수 있나요?', '웹사이트의 도움말 섹션을 통해 지원팀에 연락할 수 있습니다.', '2023-05-08', 9, '답변완료', 1),
('곽*철', '2023-05-08', '로그인 문제', '계정에 로그인이 안 됩니다.', '정확한 자격 증명을 사용하고 있는지 확인해 주세요. 문제가 계속되면 비밀번호를 재설정하세요.', '2023-05-09', 11, '답변완료', 1),
('곽*철', '2023-05-09', '프로필 사진 추가 방법?', '계정에 프로필 사진을 추가하고 싶습니다.', '계정 설정에서 프로필 사진을 업로드하세요.', '2023-05-10', 6, '답변완료', 1),

('성*수', '2023-05-10', '기능에 대한 질문', '앱이 여러 언어를 지원하나요?', '네, 저희 앱은 여러 언어를 지원합니다. 설정에서 언어를 변경할 수 있습니다.', '2023-05-11', 4, '답변완료', 2),
('성*수', '2023-05-11', '환불 요청 방법?', '구매한 상품에 대해 환불을 받고 싶습니다.', NULL, NULL, 3, '처리중', 2),
('성*수', '2023-05-12', '계정 비활성화 방법?', '일시적으로 계정을 비활성화하고 싶습니다.', NULL, NULL, 5, '처리중', 2),

('갈*현', '2023-05-13', '이메일 알림 설정 변경?', '이메일 알림 설정을 변경하고 싶습니다.', NULL, NULL, 2, '처리중',3),
('갈*현', '2023-05-14', '2단계 인증 설정 방법?', '계정에 2단계 인증을 설정하고 싶습니다.', NULL, NULL, 4, '처리중',3),
('갈*현', '2023-05-15', '프로필 정보 업데이트?', '내 프로필 정보를 업데이트하려면 어떻게 해야 하나요?', NULL, NULL, 1, '처리중',3);


/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-23 18:06:24
