CREATE DATABASE online_store;
USE online_store;

CREATE TABLE `customers`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`first_name` VARCHAR(20) NOT NULL,
`last_name` VARCHAR(20) NOT NULL,
`phone` VARCHAR(30) NOT NULL UNIQUE,
`address` VARCHAR(60) NOT NULL,
`discount_card` BIT DEFAULT FALSE
);

CREATE TABLE `orders`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`order_datetime` DATETIME NOT NULL,
`customer_id` INT NOT NULL,
CONSTRAINT fk_orders_customers
FOREIGN KEY (`customer_id`)
REFERENCES `customers` (`id`)
);

CREATE TABLE `brands`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(40) NOT NULL UNIQUE
);

CREATE TABLE `reviews`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`content` TEXT,
`rating` DECIMAL(10,2) NOT NULL,
`picture_url`VARCHAR(80) NOT NULL,
`published_at` DATETIME NOT NULL
);

CREATE TABLE `categories`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(40) NOT NULL UNIQUE
);

CREATE TABLE `products`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(40) NOT NULL,
`price` DECIMAL(19,2) NOT NULL,
`quantity_in_stock` INT,
`description` TEXT,
`brand_id` INT NOT NULL,
CONSTRAINT fk_products_brands
FOREIGN KEY (`brand_id`)
REFERENCES `brands`(`id`),
`category_id` INT NOT NULL,
CONSTRAINT fk_products_categories
FOREIGN KEY (`category_id`)
REFERENCES `categories`(`id`),
`review_id` INT,
CONSTRAINT fk_products_reviews
FOREIGN KEY (`review_id`)
REFERENCES `reviews`(`id`)
);

CREATE TABLE `orders_products`(
`order_id` INT,
`product_id` INT,
CONSTRAINT fk_orders_products_orders
FOREIGN KEY (`order_id`)
REFERENCES `orders`(`id`),
CONSTRAINT fk_orders_products_products
FOREIGN KEY (`product_id`)
REFERENCES `products`(`id`)
);

INSERT INTO `reviews`(`content`, `picture_url`, `published_at`, `rating`)
SELECT LEFT(p.`description`, 15), reverse(p.`name`), '2010-10-10', round(p.`price` / 8 ,2)
FROM `products` AS p
WHERE p.`id` >= 5;


UPDATE `products`
SET `quantity_in_stock` = `quantity_in_stock` - 5
WHERE `quantity_in_stock`>= 60 AND `quantity_in_stock`<= 70;

DELETE FROM `customers`
WHERE `id` NOT IN (SELECT `customer_id` FROM `orders`);

SELECT `id`, `name`
FROM `categories`
ORDER BY `name` DESC;

SELECT `id`, `brand_id`, `name`, `quantity_in_stock`
FROM `products`
WHERE `price` > 1000 AND `quantity_in_stock` < 30
ORDER BY `quantity_in_stock` ASC, `id` ASC;

SELECT `id`, `content`, `rating`, `picture_url`, `published_at` 
FROM `reviews`
WHERE `content` LIKE 'My%' AND char_length(`content`) > 61
ORDER BY `rating` DESC;

SELECT concat(c.`first_name`, " ", c.`last_name`) AS 'full_name', c.`address`,
o.`order_datetime`  AS 'order_date'
FROM `customers` AS c
JOIN `orders` AS o
ON o.`customer_id` = c.`id`
WHERE YEAR(`order_datetime`) <= 2018
ORDER BY `full_name` DESC;

# 9 та задачa!!!!
SELECT count(*) as 'items_count',
c.`name`, SUM(p.quantity_in_stock) as 'total_quantity'
FROM `products`  AS p 
JOIN `categories` AS c
ON p.`category_id` = c.`id`
GROUP BY c.`id`
ORDER BY `items_count` DESC, `total_quantity` ASC
LIMIT 5;

DELIMITER ###
CREATE FUNCTION `udf_customer_products_count`(name VARCHAR(30))
RETURNS INTEGER
BEGIN
RETURN
(SELECT c.`first_name`, c.`last_name`, COUNT(p.`id`) AS 'total_products' 
FROM `customers` AS c
JOIN `orders` AS o
ON o.`customer_id` = c.`id`
JOIN `orders_products` AS op
ON op.`order_id` = o.`id`
JOIN `products`AS p
ON p.`id` = op.`product_id`
WHERE c.`first_name` = name
GROUP BY c.`id`);	
END
###

#SELECT p.`name`
#FROM `products` AS p
#JOIN `categories` AS c
#ON c.`id` = p.`category_id`
#JOIN `reviews` AS r
#ON r.`id` = p.`review_id`;

UPDATE `products` AS p
JOIN `categories` AS c
ON c.`id` = p.`category_id`
JOIN `reviews` AS r
ON r.`id` = p.`review_id`
SET `price` = `price` - (`price` * 0.3)
WHERE c.`name` = 'Phones and tablets' AND r.`rating` < 4;


CREATE PROCEDURE `udp_reduce_price` (category_name VARCHAR(50))
BEGIN
UPDATE `products` AS p
JOIN `categories` AS c
ON c.`id` = p.`category_id`
JOIN `reviews` AS r
ON r.`id` = p.`review_id`
SET `price` = `price` - (`price` * 0.3)
WHERE c.`name` = category_name AND r.`rating` < 4;
END







# Друго решение 10 задача
CREATE FUNCTION udf_customer_products_count(customer_name VARCHAR(30))
RETURNS INT
DETERMINISTIC
BEGIN
 RETURN (SELECT COUNT(o.id) AS `total_products`
 FROM `orders` AS o
 LEFT JOIN `orders_products` AS op 
 ON o.id = op.order_id
 WHERE o.`customer_id` = (SELECT id FROM customers WHERE first_name = customer_name));
 END


































































