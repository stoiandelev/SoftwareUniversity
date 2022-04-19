#1.	Find Names of All Employees by First Name
USE `soft_uni`;
SELECT `first_name`, `last_name` FROM `employees`
WHERE `first_name` LIKE 'Sa%'
ORDER BY `employee_id`;

#2.	Find Names of All Employees by Last Name
SELECT `first_name`, `last_name` FROM `employees`
WHERE `last_name` LIKE '%ei%'
ORDER BY `employee_id`;

#3.	Find First Names of All Employees
SELECT `first_name` FROM `employees`
WHERE `department_id` IN (3, 10) AND
YEAR(`hire_date`) BETWEEN 1995 AND 2005
ORDER BY `employee_id`;

#4.	Find All Employees Except Engineers
SELECT `first_name`, `last_name` FROM `employees`
WHERE `job_title` NOT LIKE '%engineer%'
ORDER BY `employee_id`;

#5.	Find Towns with Name Length
SELECT `name` FROM towns
WHERE char_length(`name`) IN (5, 6)
ORDER BY `name` ASC;

#Find Towns Starting With
SELECT `town_id`, `name` FROM towns
WHERE LEFT(`name`, 1) IN ('m', 'k', 'b', 'e') 
ORDER BY `name` ASC;

#Find Towns Not Starting With
SELECT `town_id`, `name` FROM towns
WHERE LEFT(`name`, 1) NOT IN ('r', 'b', 'd') 
ORDER BY `name` ASC;

#8.Create View Employees Hired After 2000 Year
CREATE VIEW `v_employees_hired_after_2000` AS
SELECT `first_name`, `last_name` FROM `employees`
WHERE YEAR(`hire_date`) > 2000;
SELECT * FROM `v_employees_hired_after_2000`;

#9.Length of Last Name
SELECT `first_name`, `last_name` FROM `employees`
WHERE character_length(`last_name`) = 5;

#10.Countries Holding 'A' 3 or More Times
USE geography;
SELECT `country_name`, `iso_code` FROM countries
WHERE `country_name` LIKE '%A%A%A%'
ORDER BY `iso_code`;

#11.Mix of Peak and River Names
SELECT `peak_name`, `river_name`,
LOWER(concat(`peak_name`, SUBSTRING(`river_name`, 2))) AS `mix`
FROM `peaks`, `rivers`
WHERE right(`peak_name`, 1) = left(`river_name`, 1)
ORDER BY `mix`;

#12.Games from 2011 and 2012 Year
USE diablo;
SELECT `name`, date_format(`start`, '%Y-%m-%d') AS `start` FROM games
WHERE YEAR(`start`) BETWEEN 2011 AND 2012
ORDER BY `start` LIMIT 50;

#User Email Providers
SELECT `user_name`, substring(`email`, locate('@', `email`) + 1)
AS `email_provider` FROM users
ORDER BY `email_provider`, `user_name`;

#Get Users with IP Address Like Pattern
SELECT `user_name`, `ip_address` FROM users
WHERE `ip_address` LIKE '___.1%.%.___'
ORDER BY `user_name`;

#Show All Games with Duration and Part of the Day
SELECT 
    `name`,
    (CASE
        WHEN HOUR(`start`) BETWEEN 0 AND 11 THEN 'Morning'
        WHEN HOUR(`start`) BETWEEN 12 AND 17 THEN 'Afternoon'
        ELSE 'Evening'
    END) AS `part_of_the_day`,
    (CASE
        WHEN `duration` < 4 THEN 'Extra Short'
        WHEN `duration` < 7 THEN 'Short'
        WHEN `duration` < 11 THEN 'Long'
        ELSE 'Extra Long'
    END) AS 'Duration'
FROM
    `games`;

#Orders Table
USE orders;
SELECT `product_name`, `order_date`,
DATE_ADD(`order_date`, INTERVAL 3 DAY) AS 'pay_due',
DATE_ADD(`order_date`, INTERVAL 1 MONTH) AS 'deliver_due'
FROM `orders`;




































