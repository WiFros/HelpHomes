use ssafyweb;
DROP TABLE IF EXISTS `dealMark`;
CREATE TABLE `dealMark` (
  `userId` INT NOT NULL,
  `aptCode` BIGINT NOT NULL,
  PRIMARY KEY (`userId`, `aptCode`),
  FOREIGN KEY (`userId`) REFERENCES `users`(`id`),
  FOREIGN KEY (`aptCode`) REFERENCES `houseinfo`(`aptCode`)
);
