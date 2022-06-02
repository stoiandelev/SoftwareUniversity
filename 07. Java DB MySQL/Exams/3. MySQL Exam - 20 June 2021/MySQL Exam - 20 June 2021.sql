CREATE DATABASE stc;
USE stc;

CREATE TABLE `addresses`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(100) NOT NULL
);


CREATE TABLE `drivers`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`first_name` VARCHAR(30) NOT NULL,
`last_name` VARCHAR(30) NOT NULL,
`age` INT NOT NULL,
`rating` FLOAT DEFAULT 5.5
);

CREATE TABLE `clients`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`full_name` VARCHAR(50) NOT NULL,
`phone_number` VARCHAR(20) NOT NULL
);

CREATE TABLE `categories`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(10) NOT NULL
);

CREATE TABLE `cars`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`make` VARCHAR(20) NOT NULL,
`model` VARCHAR(20),
`year` INT NOT NULL DEFAULT 0,
`mileage` INT DEFAULT 0,
`condition` CHAR(1) NOT NULL,
`category_id` INT NOT NULL,
CONSTRAINT fk_cars_categories
FOREIGN KEY (`category_id`)
REFERENCES `categories`(`id`)
);


CREATE TABLE `cars_drivers`(
`car_id` INT NOT NULL,
`driver_id` INT NOT NULL,
PRIMARY KEY(`car_id`,`driver_id`),
CONSTRAINT fk_cars_drivers_cars
FOREIGN KEY (`car_id`)
REFERENCES `cars`(`id`),
CONSTRAINT fk_cars_drivers_drivers
FOREIGN KEY (`driver_id`)
REFERENCES `drivers`(`id`)
);

CREATE TABLE `courses`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`from_address_id` INT NOT NULL,
CONSTRAINT fk_courses_addresses
FOREIGN KEY (`from_address_id`)
REFERENCES `addresses`(`id`),
`start` DATETIME NOT NULL,
`bill` DECIMAL(10,2) DEFAULT 10,
`car_id` INT NOT NULL,
CONSTRAINT fk_courses_cars
FOREIGN KEY (`car_id`)
REFERENCES `cars`(`id`),
`client_id` INT NOT NULL,
CONSTRAINT fk_courses_clients
FOREIGN KEY (`client_id`)
REFERENCES `clients`(`id`)
);

INSERT INTO `clients`(`full_name`, `phone_number`)
SELECT concat(`first_name`, " ", `last_name`), concat('(088) 9999',  `id` * 2)
FROM `drivers`
WHERE `id` BETWEEN 10 AND 20;

UPDATE `cars`
SET `condition` = 'C'
WHERE (`mileage`>= 800000 OR  `mileage` IS NULL) AND `year` <= 2010
AND `make` != 'Mercedes-Benz';

DELETE FROM `clients`
WHERE
`id` NOT IN (SELECT `client_id` FROM `courses`) AND 
char_length(`full_name`) > 3 ;

SELECT `make`, `model`, `condition`
FROM `cars`
ORDER BY `id`;

SELECT d.`first_name`, d.`last_name`, c.`make`, c.`model`, c.`mileage`
FROM `drivers` AS d
JOIN `cars_drivers` AS cd
ON cd.`driver_id` = d.`id`
JOIN `cars` AS c
ON c.`id` = cd.`car_id`
WHERE c.`mileage` IS NOT NULL
ORDER BY c.`mileage` DESC, d.`first_name` ASC;

SELECT c.`id`, c.`make`, c.`mileage`, COUNT(cu.`id`) AS 'count_of_courses',
round(AVG(cu.`bill`), 2) AS 'avg_bill'
FROM `cars` AS c
LEFT JOIN `courses` AS cu
ON cu.`car_id` = c.`id`
GROUP BY c.`id`
HAVING `count_of_courses` != 2
ORDER BY `count_of_courses` DESC, c.`id` ASC;

SELECT c.`full_name`,
COUNT(co.`car_id`) AS 'count_of_cars',
SUM(co.`bill`) AS 'total_sum'
FROM `clients` AS c
JOIN `courses` AS co
ON co.`client_id` = c.`id`
WHERE c.`full_name` LIKE '_a%'
GROUP BY c.`full_name`
HAVING `count_of_cars` > 1
ORDER BY c.`full_name`;

SELECT a.`name`,
IF(HOUR(cou.`start`) BETWEEN 6 AND 20,
'Day',
'Night') AS 'day_time',
cou.`bill`,
c.`full_name`, cr.`make`, cr.`model`, cat.`name`
FROM `addresses` AS a
JOIN `courses` AS cou
ON cou.`from_address_id` = a.`id`
JOIN `clients` AS  c
ON c.`id` = cou.`client_id`
JOIN `cars` AS cr
ON cr.`id` = cou.`car_id`
JOIN `categories` AS cat
ON cat.`id`= cr.`category_id`
ORDER BY cou.`id`;

DELIMITER ###
CREATE FUNCTION `udf_courses_by_client`(phone_num VARCHAR (20))
RETURNS INTEGER
BEGIN
RETURN (SELECT COUNT(co.`id`) AS 'count'
FROM `clients` AS c
JOIN `courses` AS co
ON co.`client_id` = c.`id`
WHERE c.`phone_number` = phone_num);
END
###

CREATE PROCEDURE `udp_courses_by_address`(address_name VARCHAR(100))
BEGIN
SELECT a.`name`,
c.`full_name` AS 'full_names',
CASE 
WHEN cou.`bill` <= 20 THEN 'Low' 
WHEN cou.`bill` BETWEEN 21 AND 30 THEN 'Medium'
ELSE 'High' 
END AS 'level_of_bill',
cr.`make`,
cr.`condition`,
cat.`name` AS 'cat_name'
FROM `addresses` AS a
JOIN `courses` AS cou
ON cou.`from_address_id` = a.`id`
JOIN `clients` AS  c
ON c.`id` = cou.`client_id`
JOIN `cars` AS cr
ON cr.`id` = cou.`car_id`
JOIN `categories` AS cat
ON cat.`id`= cr.`category_id`
WHERE a.`name` = address_name
ORDER BY cr.`make` ASC, `full_names` ASC;
END





























































