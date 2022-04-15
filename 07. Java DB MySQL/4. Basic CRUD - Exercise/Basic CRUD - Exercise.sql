USE soft_uni;

#Find All Information About Departments 
SELECT * FROM `departments`
ORDER BY `department_id`;

#Find all Department Names 
SELECT `name` FROM `departments`
ORDER BY `department_id`;

#Find salary of Each Employee 
SELECT `first_name`, `last_name`, `salary` FROM `employees`
ORDER BY `employee_id`;

#Find Full Name of Each Employee 
SELECT `first_name`, `middle_name`, `last_name` FROM `employees`
ORDER BY `employee_id`;

#Find Email Address of Each Employee 
SELECT concat(`first_name`, '.', `last_name`, '@softuni.bg') AS `full_email_address` FROM `employees`;

#Find All Different Employee's Salaries 
SELECT DISTINCT `salary` FROM `employees`;

#Find all Information About Employees
SELECT  * FROM `employees`
WHERE `job_title` = 'Sales Representative'
ORDER BY `employee_id`;

#Find Names of All Employees by salary in Range 
SELECT `first_name`, `last_name`, `job_title` FROM `employees`
WHERE `salary` BETWEEN 20000 AND 30000
ORDER BY `employee_id`;

#Find Names of All Employees
SELECT concat_ws(' ', `first_name`, `middle_name`, `last_name`) AS `Full Name` FROM `employees`
WHERE `salary` IN(25000, 14000, 12500, 23600);

#Find All Employees Without Manager
SELECT `first_name`, `last_name` FROM `employees`
WHERE `manager_id` IS NULL;

#Find All Employees with salary More Than 50000
SELECT `first_name`, `last_name`, `salary` FROM `employees`
WHERE `salary` > 50000
ORDER BY `salary` DESC;

#Find 5 Best Paid Employees
SELECT `first_name`, `last_name`FROM `employees`
ORDER BY `salary` DESC LIMIT 5;

#Find All Employees Except Marketing
SELECT `first_name`, `last_name` FROM `employees`
WHERE `department_id` != 4;

#Sort Employees Table
SELECT * FROM `employees`
ORDER BY `salary` DESC,
`first_name` ASC,
`last_name` DESC,
`middle_name` ASC;

#Create View Employees with Salaries
CREATE VIEW `v_employees_salaries` AS
SELECT `first_name`, `last_name`, `salary` FROM `employees`;

#Create View Employees with Job Titles
CREATE VIEW `v_employees_job_titles` AS
SELECT concat_ws(' ', `first_name`, `middle_name`, `last_name`) AS `full_name`,
`job_title` FROM `employees`;

#Distinct Job Titles
SELECT DISTINCT `job_title`  FROM `employees` 
ORDER BY `job_title` ASC;

#Find First 10 Started Projects
SELECT * FROM projects
ORDER BY `start_date`,
`name`,
`project_id` LIMIT 10;

#Last 7 Hired Employees
SELECT `first_name`, `last_name`, `hire_date` FROM employees
ORDER BY `hire_date` DESC LIMIT 7;

#Increase Salaries
UPDATE employees 
SET 
salary = salary * 1.12
WHERE department_id IN (1 , 2, 4, 11);
SELECT salary FROM employees;

#All Mountain Peaks
USE geography;
SELECT `peak_name` FROM peaks
ORDER BY `peak_name` ASC;

#Biggest Countries by Population
SELECT `country_name`, `population` FROM countries
WHERE `continent_code` = 'EU'
ORDER BY `population` DESC,
`country_name` ASC LIMIT 30;	

#Countries and Currency (Euro / Not Euro)
SELECT `country_name`, `country_code`,
IF (currency_code = 'EUR', 'Euro' , 'Not Euro') AS `currency` FROM countries
ORDER BY `country_name` ASC;


#All Diablo Characters 
USE diablo;
SELECT `name` FROM characters
ORDER BY `name` ASC;





































