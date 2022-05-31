CREATE DATABASE instd;
USE instd;

CREATE TABLE `users`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`username` VARCHAR(30) NOT NULL UNIQUE,
`password` VARCHAR(30) NOT NULL,
`email` VARCHAR(50) NOT NULL,
`gender` CHAR(1) NOT NULL,
`age` INT NOT NULL,
`job_title` VARCHAR(40) NOT NULL,
`ip` VARCHAR(30) NOT NULL
);

CREATE TABLE `addresses`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`address` VARCHAR(30) NOT NULL,
`town` VARCHAR(30) NOT NULL,
`country` VARCHAR(30) NOT NULL,
`user_id` INT NOT NULL,
CONSTRAINT fk_addresses_users
FOREIGN KEY (`user_id`)
REFERENCES `users`(`id`)
);

CREATE TABLE `photos`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`description` TEXT NOT NULL,
`date` DATETIME NOT NULL,
`views` INT DEFAULT 0 NOT NULL
);

CREATE TABLE `users_photos`(
`user_id` INT NOT NULL,
`photo_id` INT NOT NULL,
CONSTRAINT fk_users_photos_users
FOREIGN KEY (`user_id`)
REFERENCES `users`(`id`),
CONSTRAINT fk_users_photos_photos
FOREIGN KEY (`photo_id`)
REFERENCES `photos`(`id`)
);

CREATE TABLE `likes`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`photo_id` INT,
`user_id` INT,
CONSTRAINT fk_likes_photos
FOREIGN KEY (`photo_id`)
REFERENCES `photos`(`id`),
CONSTRAINT fk_likes_users
FOREIGN KEY (`user_id`)
REFERENCES `users`(`id`)
);

CREATE TABLE `comments`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`comment` VARCHAR(255) NOT NULL,
`date` DATETIME NOT NULL,
`photo_id` INT NOT NULL,
 CONSTRAINT fk_comments_photos
FOREIGN KEY (`photo_id`)
REFERENCES `photos`(`id`)
);

INSERT INTO `addresses`(`address`, `town`, `country`, `user_id`)
SELECT u.`username`, u.`password`, u.`ip`, u.`age`
FROM `users` AS u
WHERE u.`gender` = 'M';

UPDATE `addresses` 
SET `country` = (
CASE 
WHEN `country` LIKE 'B%' THEN 'Blocked'
WHEN `country` LIKE 'T%' THEN 'Test'
WHEN `country` LIKE 'P%' THEN 'In Progress'
ELSE `country`
END
);

DELETE FROM `addresses`
WHERE `id` % 3 = 0;

SELECT `username`, `gender`, `age`
FROM `users`
ORDER BY `age` DESC, `username` ASC;

SELECT p.`id`, p.`date` AS 'date_and_time', p.`description`, COUNT(c.`id`) AS 'commentsCount'
FROM `photos` AS p
JOIN `comments` AS c
ON c.`photo_id` = p.`id`
GROUP BY p.`id`
ORDER BY `commentsCount` DESC, p.`id` ASC LIMIT 5;

SELECT concat(u.`id`, " ",  u.`username`) AS 'id_username', u.`email` 
FROM `users` AS u
JOIN `users_photos` AS p
ON p.`user_id` = u.`id` AND p.`photo_id` = u.`id`
ORDER BY u.`id` ASC;

SELECT p.`id`, 
COUNT(DISTINCT l.`id`) AS 'likes_count',
COUNT(DISTINCT c.`id`) AS 'comments_count'
FROM `photos` AS p
LEFT JOIN `likes` AS l
ON l.`photo_id` = p.`id`
LEFT JOIN `comments` AS c
ON c.`photo_id` = p.`id`
GROUP BY p.`id`
ORDER BY `likes_count` DESC, `comments_count` DESC, p.`id` ASC;

SELECT concat(LEFT(`description`, 30),"...") AS 'summary', `date` 
FROM `photos`
WHERE DAY(`date`) = 10
ORDER BY `date` DESC;

DELIMITER ###
CREATE FUNCTION `udf_users_photos_count`(username VARCHAR(30))
RETURNS INTEGER
BEGIN
RETURN (SELECT COUNT(up.`photo_id`) AS 'photosCount'
FROM `users_photos` AS up
JOIN `photos` AS p
ON p.`id` = up.`photo_id`
JOIN `users` AS u
ON u.`id` = up.`user_id`
WHERE u.`username` = username);
END;
###

SELECT 
    u.`username`, u.`email`, u.`gender`, u.`age`, u.`job_title`
FROM
    `users` AS u
    LEFT JOIN `addresses`AS a
    ON u.`id` = a.`user_id`
WHERE
    u.`username` = 'eblagden21';


CREATE PROCEDURE `udp_modify_user`(address VARCHAR(30), town VARCHAR(30))
BEGIN
IF(
(SELECT a.`address` FROM `addresses` AS a
WHERE a.`address` = address)
IS NOT NULL
)
THEN UPDATE `users` AS u 
JOIN `addresses` AS a
ON u.`id` = a.`user_id`
SET u.`age` = u.`age` + 10
WHERE a.`address` = address AND a.`town` = town;
END IF;
END






































































