DROP TABLE IF EXISTS `post`;
DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(64) NOT NULL,
  `password` VARCHAR(255) NOT NULL,
  `name` VARCHAR(64) NOT NULL,
  `created_date` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=UTF8MB4;

CREATE TABLE `post` (
  `id` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_id` BIGINT(20) UNSIGNED NOT NULL,
  `title` VARCHAR(255) NOT NULL,
  `contents` VARCHAR(255) NOT NULL,
  `created_date` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=UTF8MB4;