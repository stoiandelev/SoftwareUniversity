CREATE DATABASE gamebar;
USE gamebar;


#Create Tables
CREATE TABLE `employees`(
`id` INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
`first_name` VARCHAR(45) NOT NULL,
`last_name` VARCHAR(45) NOT NULL
);

CREATE TABLE `categories`(
`id` INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
`name` VARCHAR(45) NOT NULL
);

CREATE TABLE `products` (
    `id` INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    `name` VARCHAR(45) NOT NULL,
    `category_id` INT NOT NULL
);

# Insert Data in Tables
INSERT INTO `employees` (`id`, `first_name`, `last_name`)
VALUES
('1', 'Stoian', 'Delev'),
('2', 'Marian', 'Nikov'),
('3', 'Stoian', 'Antonov');

# Alter Table
ALTER TABLE `employees`
ADD COLUMN `middle_name` VARCHAR(45);

# Adding Constraints
ALTER TABLE `products`
ADD CONSTRAINT fk_products_categories
FOREIGN KEY (`category_id`)
REFERENCES `categories`(`id`);

# Modifying Columns
ALTER TABLE `employees`
MODIFY COLUMN `middle_name` VARCHAR(100); 
















