use ssafyweb;

CREATE TABLE `users` (
  `id` INT AUTO_INCREMENT PRIMARY KEY,
  `name` VARCHAR(50) COLLATE utf8mb3_bin NOT NULL UNIQUE,
  `password` VARCHAR(255) COLLATE utf8mb3_bin NOT NULL, 
  `email` VARCHAR(100) COLLATE utf8mb3_bin NOT NULL,
  `joinDate` DATETIME COLLATE utf8mb3_bin ,
  `address` VARCHAR(500)COLLATE utf8mb3_bin ,
  `phone` VARCHAR(100)COLLATE utf8mb3_bin ,
  `role` VARCHAR(50) NOT NULL COLLATE utf8mb3_bin
);

INSERT INTO `users` (`name`, `password`, `email`, `joinDate`, `address`, `phone`, `role`)
VALUES 
('test1', '1234', 'alice@example.com', '2024-05-10 09:15:00', '456 Elm Street, City, Country', '+1987654321', 'user'),
('test2', '1234', 'bob@example.com', '2024-05-10 10:30:00', '789 Oak Street, City, Country', '+1122334455', 'user'),
('test3', '1234', 'emily@example.com', '2024-05-10 11:45:00', '321 Pine Street, City, Country', '+9988776655', 'user'),
('test4', '1234', 'sarah@example.com', '2024-05-10 13:00:00', '111 Maple Street, City, Country', '+1122334455', 'user'),
('test5', '1234', 'michael@example.com', '2024-05-10 14:15:00', '222 Cedar Street, City, Country', '+9988776655', 'user'),
('test6', '1234', 'emma@example.com', '2024-05-10 15:30:00', '333 Birch Street, City, Country', '+1122334455', 'user'),
('test7', '1234', 'james@example.com', '2024-05-10 16:45:00', '444 Pine Street, City, Country', '+9988776655', 'user'),
('test8', '1234', 'olivia@example.com', '2024-05-10 18:00:00', '555 Oak Street, City, Country', '+1122334455', 'user'),
('test9', '1234', 'william@example.com', '2024-05-10 19:15:00', '666 Elm Street, City, Country', '+9988776655', 'user'),
('test10', '1234', 'sophia@example.com', '2024-05-10 20:30:00', '777 Maple Street, City, Country', '+1122334455', 'user'),
('test11', '1234', 'benjamin@example.com', '2024-05-10 21:45:00', '888 Cedar Street, City, Country', '+9988776655', 'user'),
('test12', '1234', 'isabella@example.com', '2024-05-10 23:00:00', '999 Birch Street, City, Country', '+1122334455', 'user'),
('test13', '1234', 'ethan@example.com', '2024-05-11 00:15:00', '101010 Pine Street, City, Country', '+9988776655', 'user'),
('admin', '1234', 'ethsan@example.com', '2024-05-11 00:15:00', '101010 Pine Street, City, Country', '+9988776655', 'admin');




