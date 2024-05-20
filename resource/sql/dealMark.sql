use ssafyweb;
CREATE TABLE `dealMark` (
  `user_id` INT NOT NULL,
  `aptCode` BIGINT NOT NULL,
  PRIMARY KEY (`user_id`, `aptCode`),
  FOREIGN KEY (`user_id`) REFERENCES `users`(`id`),
  FOREIGN KEY (`aptCode`) REFERENCES `houseinfo`(`aptCode`)
);
