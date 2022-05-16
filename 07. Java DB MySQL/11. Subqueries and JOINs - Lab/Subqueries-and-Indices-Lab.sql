#1.	Managers
USE soft_uni;
SELECT  e.`employee_id`, CONCAT(e.`first_name`, ' ', e.`last_name`) AS 'full_name',
d.`department_id`, d.`name` AS 'department_name'
FROM `employees` AS e
RIGHT JOIN `departments` AS d
ON d.`manager_id` = e.`employee_id`
ORDER BY e.`employee_id` LIMIT 5;

#2.	Towns Addresses
SELECT a.`town_id`, `name` AS 'town_name', `address_text` 
FROM `towns` AS e
JOIN `addresses` AS a
ON e.`town_id` = a.`town_id`
WHERE `name` IN('San Francisco', 'Sofia', 'Carnation')
ORDER BY e.`town_id`, a.`address_id` ;

#3.	Employees Without Managers
SELECT e.`employee_id`, e.`first_name`, e.`last_name`, e.`department_id`, e.`salary` 
FROM `employees` AS e
JOIN `departments` AS d
ON e.`department_id` = d.`department_id`
WHERE e.`manager_id` IS NULL;

#4.	Higher Salary
SELECT COUNT(e.`employee_id`) AS 'count' 
FROM `employees` AS e
WHERE e.`salary` >
(
SELECT AVG(`salary`) FROM `employees`
);










