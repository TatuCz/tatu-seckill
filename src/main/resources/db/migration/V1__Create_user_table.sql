CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nickname` varchar(100) NOT NULL,
  `password` varchar(32) NOT NULL,
  `avatar_url` varchar(256) DEFAULT NULL,
  `salt` varchar(10) NOT NULL,
  `register_date` datetime NOT NULL,
  `last_login_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
