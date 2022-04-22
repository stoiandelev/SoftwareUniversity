USE restaurant;

#Departments Info
SELECT `department_id`, COUNT(*) AS 'Number_of_employees'
FROM `employees`
GROUP BY `department_id`
ORDER BY `department_id`, `Number_of_employees`;

#2.	Average Salary
SELECT `department_id`,ROUND(AVG(`salary`), 2) AS 'average_salary'
FROM `employees`
GROUP BY `department_id`
ORDER BY `department_id`;

#Min Salary
SELECT `department_id`,ROUND(MIN(`salary`), 2 ) AS 'min_salary'
FROM `employees`
GROUP BY `department_id`
HAVING `min_salary` > 800;

#Appetizers Count
SELECT COUNT(`id`) FROM `products`
WHERE `category_id` = 2 AND `price` > 8;

#Menu Prices
SELECT `category_id`,
ROUND(AVG(`price`), 2) AS `avarage_price`,
ROUND(MIN(`price`), 2) AS `cheapest_product`,
ROUND(MAX(`price`), 2) AS `most_expensive_product`
FROM `products`
GROUP BY `category_id`;













