#Records' Count
USE `gringotts`;
SELECT COUNT(`id`) AS 'count' FROM `wizzard_deposits`;

#Longest Magic Wand
SELECT MAX(`magic_wand_size`) AS 'longest_magic_wand' FROM `wizzard_deposits`;

#Longest Magic Wand per Deposit Groups
SELECT 
    `deposit_group`,
    MAX(`magic_wand_size`) AS 'longest_magic_wand'
FROM
    `wizzard_deposits`
GROUP BY `deposit_group`
ORDER BY `longest_magic_wand` ASC , `deposit_group` ASC;

#Smallest Deposit Group per Magic Wand Size
SELECT `deposit_group` FROM `wizzard_deposits`
GROUP BY `deposit_group`
HAVING MIN(`magic_wand_size`) LIMIT 1;

#Deposits Sum
SELECT `deposit_group`, SUM(`deposit_amount`) AS 'total_sum' FROM `wizzard_deposits`
GROUP BY `deposit_group`
ORDER BY `total_sum`;	

#Deposits Sum for Ollivander Family
SELECT `deposit_group`, SUM(`deposit_amount`) AS 'total_sum'
FROM `wizzard_deposits`
WHERE `magic_wand_creator` = 'Ollivander family'
GROUP BY `deposit_group`
ORDER BY `deposit_group` ASC;

#Deposits Filter
SELECT `deposit_group`, SUM(`deposit_amount`) AS 'total_sum'
FROM `wizzard_deposits`
WHERE `magic_wand_creator` = 'Ollivander family'
GROUP BY `deposit_group`
HAVING `total_sum` < 150000
ORDER BY `total_sum` DESC;

#Deposit Charge
SELECT `deposit_group`, `magic_wand_creator`, MIN(`deposit_charge`) AS 'min_deposit_charge'
FROM `wizzard_deposits`
GROUP BY `deposit_group`, `magic_wand_creator`
ORDER BY `magic_wand_creator` ASC, `deposit_group` ASC;

#Age Groups
SELECT(
	CASE
		WHEN `age` BETWEEN 0 AND 10 THEN '[0-10]'
		WHEN `age` BETWEEN 11 AND 20 THEN '[11-20]'
		WHEN `age` BETWEEN 21 AND 30 THEN '[21-30]'
		WHEN `age` BETWEEN 31 AND 40 THEN '[31-40]'
		WHEN `age` BETWEEN 41 AND 50 THEN '[41-50]'
		WHEN `age` BETWEEN 51 AND 60 THEN '[51-60]'
        ELSE '[61+]'
    END
) AS 'age_group', COUNT(*) AS 'wizard_count'
FROM `wizzard_deposits`
GROUP BY `age_group`
ORDER BY `age_group`;

#First Letter
SELECT LEFT(`first_name`, 1) AS 'first_letter'  FROM `wizzard_deposits`
WHERE `deposit_group` = 'Troll Chest'
GROUP BY `first_letter`
ORDER BY `first_letter`;

#Average Interest
SELECT `deposit_group`, `is_deposit_expired`, AVG(`deposit_interest`) AS 'average_interest'
FROM `wizzard_deposits`
WHERE `deposit_start_date` > '1985-01-01'
GROUP BY `deposit_group`, `is_deposit_expired`
ORDER BY `deposit_group` DESC, `is_deposit_expired` ASC;

#Employees Minimum Salaries
USE soft_uni;
SELECT `department_id`, MIN(`salary`) AS 'minimum_salary' FROM employees
WHERE `department_id` IN (2, 5, 7) AND `hire_date` > '2000-01-01'
GROUP BY `department_id`
ORDER BY `department_id` ASC;

#Employees Average Salaries
CREATE TABLE `hp` AS
SELECT * FROM employees
WHERE `salary` > 30000 AND `manager_id` != 42;

UPDATE `hp`
SET `salary` = `salary` + 5000
WHERE `department_id` = 1;

SELECT `department_id`, AVG(`salary`) AS 'avg_salary' FROM `hp`
GROUP BY `department_id`
ORDER BY `department_id`;

#Employees Maximum Salaries
SELECT department_id, max(salary) AS 'max_salary'
FROM employees
GROUP BY department_id
HAVING `max_salary` NOT BETWEEN 30000 AND 70000
ORDER BY department_id;

#Employees Count Salaries
SELECT count(`employee_id`) FROM `employees` 
WHERE `manager_id` IS NULL;

#3rd Highest Salary*
SELECT e.`department_id`, (

SELECT DISTINCT e2.`salary` FROM `employees` AS e2
WHERE e2.`department_id` = e.`department_id`
ORDER BY e2.`salary` DESC
LIMIT 1 OFFSET 2

) AS 'third_highest_salary'
FROM `employees` AS e
GROUP BY e.`department_id`
HAVING `third_highest_salary` IS NOT NULL
ORDER BY e.`department_id` ASC;

#Salary Challenge**
SELECT e.`first_name`, e.`last_name`, e.`department_id`
FROM `employees` AS e
WHERE e.`salary` > (

SELECT AVG(e2.`salary`)
FROM `employees` AS e2
WHERE e2.`department_id` = e.`department_id`

)
ORDER BY e.`department_id`, e.`employee_id` LIMIT 10;

#Departments Total Salaries
SELECT e.`department_id`,
	(SELECT SUM(`salary`)
     FROM `employees`
     WHERE `department_id` = e.`department_id`) as 'total_salary'
FROM `employees` as e
GROUP BY e.`department_id`
ORDER BY e.`department_id`;







































































