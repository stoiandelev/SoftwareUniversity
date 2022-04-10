CREATE DATABASE `minions`;
USE `minions`;

#1.	Create Tables
CREATE TABLE `minions`(
	`id` INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
	`name` VARCHAR(30) NOT NULL,
	`age` INT
);

CREATE TABLE `towns`(
	`town_id` INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
	`name` VARCHAR(30) NOT NULL
);

#2.	Change table name
ALTER TABLE `towns`
CHANGE COLUMN `town_id` `id` INT AUTO_INCREMENT NOT NULL;

#2.1	Add new column and add new constraint foreign key
ALTER TABLE `minions`
ADD COLUMN `town_id` INT,
ADD CONSTRAINT fk_minions_towns
FOREIGN KEY (`town_id`)
REFERENCES `towns`(`id`);

#3 Insert Records in Both Tables
INSERT INTO `towns`
VALUES
(1, 'Sofia'),
(2, 'Plovdiv'),
(3, 'Varna');

INSERT INTO `minions`
VALUES
(1, 'Kevin', 22, 1),
(2, 'Bob', 15, 3),
(3, 'Steward', NULL, 2);

#4 Truncate Table Minions
TRUNCATE `minions`;

#5 Drop All Tables
DROP table `minions`;
DROP table `towns`;

#6 Create Table People
CREATE TABLE `people` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
	`name` VARCHAR(200) NOT NULL,
	`picture` BLOB,
	`height` FLOAT(5, 2),
	`weight` FLOAT(5, 2),
	`gender` CHAR(1) NOT NULL,
	`birthdate` DATE NOT NULL,
	`biography` TEXT
);

INSERT INTO `people`
VALUE
(1, 'Stoyan', NULL, 1.78, 100, 'M', '1989-03-30', 'My-biografy'),
(2, 'Marian', NULL, 1.78, 100, 'M', '1989-03-30', 'My-biografy'),
(3, 'Dimitar', NULL, 1.78, 100, 'M', '1989-03-30', 'My-biografy'),
(4, 'Angel', NULL, 1.78, 100, 'M', '1989-03-30', 'My-biografy'),
(5, 'Tatian', NULL, 1.78, 100, 'M', '1989-03-30', 'My-biografy');

#7 Create Table Users
CREATE TABLE `users` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
	`username` VARCHAR(30) NOT NULL,
	`password` VARCHAR(26) NOT NULL,
    `profile_picture` BLOB,
    `last_login_time` DATETIME,
    `is_deleted` BOOL
);

INSERT INTO `users` (`username`, `password`, `profile_picture`, `last_login_time`, `is_deleted`)
VALUES
('Stoyan', '123', NULL, '1993-06-01 00-00-01', false),
('Ivan', '123', NULL, '1993-06-01 00-00-01', true),
('Jordan', '123', NULL, '1993-06-01 00-00-01', false),
('Marian', '123', NULL, '1993-06-01 00-00-01', true),
('Atanas', '123', NULL, '1993-06-01 00-00-01', false);


 
#8 Change Primary Key with two columns (композитен primary cay)
ALTER TABLE `users`
DROP PRIMARY KEY,
ADD CONSTRAINT pk_users
PRIMARY KEY (`id`, `username`);

#9 Set Default Value of a Field
ALTER TABLE `users`
CHANGE COLUMN `last_login_time` `last_login_time` DATETIME  DEFAULT NOW();

#10 Set Unique Field
ALTER TABLE `users`
DROP PRIMARY KEY, 
ADD CONSTRAINT pk_users
PRIMARY KEY `users`(`id`), 
CHANGE COLUMN `username` `username` VARCHAR(50) UNIQUE;

#11 Movies Database
CREATE DATABASE `Movies`;
USE `Movies`;

CREATE TABLE `directors` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `director_name` VARCHAR(30),
    `notes` TEXT
);

CREATE TABLE `genres` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `genre_name` VARCHAR(30),
    `notes` TEXT
);

CREATE TABLE `categories` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `category_name` VARCHAR(30),
    `notes` TEXT
);

CREATE TABLE `movies` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `title` VARCHAR(30) NOT NULL,
	`director_id` INT,
    `copyright_year` DATE,
    `length` TIME,
	`genre_id` INT,
	`category_id` INT,
	`rating` FLOAT(5, 2),
	`notes` TEXT,
      
	 CONSTRAINT fk_movies_directors
     FOREIGN KEY (`director_id`) REFERENCES `directors`(`id`),
     CONSTRAINT fk_movies_genres
     FOREIGN KEY (`genre_id`) REFERENCES `genres`(`id`),
	 CONSTRAINT fk_movies_categories
     FOREIGN KEY (`category_id`) REFERENCES `categories`(`id`)
);

INSERT INTO `categories`
VALUES
(1, 'comedy', NULL),
(2, 'scary', NULL),
(3, 'drama', NULL),
(4, 'action', NULL),
(5, 'biografy', NULL);

INSERT INTO `directors`
VALUES
(1, 'Stoian', NULL),
(2, 'Marian', NULL),
(3, 'Angel', NULL),
(4, 'Katia', NULL),
(5, 'Tania', NULL);

INSERT INTO `genres`
VALUES
(1, '11111', NULL),
(2, '22222', NULL),
(3, '33333', NULL),
(4, '44444', NULL),
(5, '55555', NULL);

INSERT INTO `movies`
VALUES
(2, 'Movie1', 1, '2000-02-01', 1, 1, 1, NULL, NULL),
(3, 'Movie2', 1, '2000-02-01', 1, 1, 1, NULL, NULL),
(4, 'Movie3', 1, '2000-02-01', 1, 1, 1, NULL, NULL),
(5, 'Movie4', 1, '2000-02-01', 1, 1, 1, NULL, NULL),
(6, 'Movie5', 1, '2000-02-01', 1, 1, 1, NULL, NULL);


#12 Car Rental Database
CREATE DATABASE `car_rental`;
USE `car_rental`;



CREATE TABLE `categories` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `category` VARCHAR(40),
    `daily_rate` FLOAT(5,2),
    `weekly_rate` FLOAT(5,2),
    `monthly_rate` FLOAT(5,2),
    `weekend_rate` FLOAT(5,2)
);

CREATE TABLE `cars` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `plate_number` INT NOT NULL,
    `make` INT,
    `model` VARCHAR(30),
    `car_year` DATE,
    `category_id` INT,
    `doors` INT,
    `picture` BLOB,
    `car_condition` TEXT,
    `available` BOOL,
    CONSTRAINT fk_cars_categories
    FOREIGN KEY (`category_id`) REFERENCES `categories`(`id`)
);



CREATE TABLE `employees` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `first_name` VARCHAR(30) NOT NULL,
    `last_name` VARCHAR(30) NOT NULL,
    `title` VARCHAR(30),
    `notes`TEXT
);

CREATE TABLE `customers` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `driver_licence_number` INT NOT NULL,
    `full_name` VARCHAR(60) NOT NULL,
    `address` TEXT,
    `city` VARCHAR(30),
    `zip_code` INT,
    `notes`TEXT
);

CREATE TABLE `rental_orders` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `employee_id` INT,
    `customer_id` INT,
    `car_id` INT,
    `car_condition` VARCHAR(40),
    `tank_level` INT,
    `kilometrage_start` INT,
    `kilometrage_end` INT,
    `total_kilometrage` INT,
    `start_date` DATE,
    `end_date` DATE,
    `total_days` DATE,
    `rate_applied` INT,
    `tax_rate` INT,
    `order_status` VARCHAR(20),
    `notes` TEXT
);

ALTER TABLE `rental_orders`
ADD CONSTRAINT fk_rental_orders_emoloyees
FOREIGN KEY (`employee_id`) REFERENCES `employees`(`id`),
ADD CONSTRAINT fk_rental_orders_customers
FOREIGN KEY (`customer_id`) REFERENCES `customers`(`id`),
ADD CONSTRAINT fk_rental_orders_cars
FOREIGN KEY (`car_id`) REFERENCES `cars`(`id`);


INSERT INTO `cars`
VALUES
(2, 1234, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(3, 1234, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(4, 1234, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

INSERT INTO `categories`
VALUES
(2, NUll, NUll, NUll, NUll, NUll),
(3, NUll, NUll, NUll, NUll, NUll),
(4, NUll, NUll, NUll, NUll, NUll);

INSERT INTO `employees`
VALUES
(1, 'Stoian', 'Delev', NUll, NUll),
(2, 'Marian', 'Nikov', NUll, NUll),
(3, 'Katia', 'Nikovа', NUll, NUll);

INSERT INTO `rental_orders`
VALUES
(2, NUll, NUll, NUll, NUll, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL ),
(3, NUll, NUll, NUll, NUll, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL ),
(4, NUll, NUll, NUll, NUll, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL ),
(5, NUll, NUll, NUll, NUll, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL );










#13 Basic Insert
CREATE DATABASE `soft_uni`;
USE `soft_uni`;

CREATE TABLE `towns` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(30) NOT NULL
);

CREATE TABLE `addresses` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `address_text` VARCHAR(100) NOT NULL,
    `town_id` INT NOT NULL,
    CONSTRAINT fk_addresses_towns
    FOREIGN KEY (`town_id`) REFERENCES `towns`(`id`)
);

CREATE TABLE `departments` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(30) NOT NULL
);

CREATE TABLE `employees` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `first_name` VARCHAR(30) NOT NULL,
    `middle_name` VARCHAR(30) NOT NULL,
    `last_name` VARCHAR(30) NOT NULL,
    `job_title` VARCHAR(20) ,
    `department_id` INT ,
    `hire_date` DATE,
    `salary` DECIMAL(10,2),
    `address_id` INT,
    CONSTRAINT fk_employees_departments
    FOREIGN KEY (`department_id`) REFERENCES `departments` (`id`),
    CONSTRAINT fk_employees_addresses
    FOREIGN KEY (`address_id`) REFERENCES `addresses` (`id`)
);

INSERT INTO `towns`
VALUES
(1, 'Sofia'),
(2, 'Plovdiv'),
(3, 'Varna'),
(4, 'Burgas');

INSERT INTO `departments`
VALUES
(1, 'Engineering'),
(2, 'Sales'),
(3, 'Marketing'),
(4, 'Software Development'),
(5, 'Quality Assurance');

INSERT INTO `employees`(`id`, `first_name`, `middle_name`, `last_name`, `job_title`,
`department_id`, `hire_date`, `salary`, `address_id`)
VALUES
(1, 'Ivan', 'Ivanov', 'Ivanov', '.NET Developer', 4, '2013-02-01', 3500.00, NULL),
(2, 'Petar', 'Petrov', 'Petrov', 'Senior Engineer', 1, '2004-03-02', 4000.00, NULL),
(3, 'Maria', 'Petrova', 'Ivanova', 'Intern', 5, '2016-08-28', 525.25, NULL),
(4, 'Georgi', 'Terziev', 'Ivanov', 'CEO', 2, '2007-12-09', 3000.00, NULL),
(5, 'Peter', 'Pan', 'Pan', 'Intern', 3, '2016-08-28', 599.88, NULL);

#14 Basic Select All Fields
SELECT * FROM `towns`;
SELECT * FROM `departments`;
SELECT * FROM `employees`;

#15 Basic Select All Fields and Order Them
SELECT * FROM `towns`
ORDER BY `name`; 

SELECT * FROM `departments`
ORDER BY `name`;

SELECT * FROM `employees`
ORDER BY `salary` DESC;

#16 Basic Select Some Fields
SELECT `name` FROM `towns`
ORDER BY `name`; 

SELECT `name` FROM `departments`
ORDER BY `name`;

SELECT `first_name`, `last_name`, `job_title`, `salary` FROM `employees`
ORDER BY `salary` DESC;

#17 Increase Employees Salary
UPDATE `employees`
SET `salary` = `salary` * 1.1;
SELECT `salary` FROM `employees`;

#18 Delete All Records
TRUNCATE `occupancies`;

#DELETE FROM `employees`
#WHERE `id` = 5 OR `id` = 1;



























































