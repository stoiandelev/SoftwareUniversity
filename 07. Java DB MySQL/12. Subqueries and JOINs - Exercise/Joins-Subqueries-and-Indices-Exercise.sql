USE soft_uni;

#1.	Employee Address
SELECT e.`employee_id`, e.`job_title`, a.`address_id`, a.`address_text` FROM `employees` AS e
JOIN `addresses` AS a
ON e.`address_id` = a.`address_id`
ORDER BY e.`address_id` ASC LIMIT 5;

#2.	Addresses with Towns
SELECT e.`first_name`, e.`last_name`, t.`name`, a.`address_text` FROM `employees` AS e
JOIN `addresses` AS a
ON e.`address_id` = a.`address_id`
JOIN `towns`AS t
ON t.`town_id` = a.`town_id`
ORDER BY e.`first_name` ASC, e.`last_name` ASC LIMIT 5;

#3.	Sales Employee
SELECT e.`employee_id`,  e.`first_name`, e.`last_name`, d.`name` AS 'department_name'
FROM `employees` AS e
JOIN `departments` AS d
ON d.`department_id` = e.`department_id`
WHERE `name` = 'Sales'
ORDER BY `employee_id` DESC;

#4.	Employee Departments
SELECT e.`employee_id`,  e.`first_name`, e.`salary`, d.`name` AS 'department_name'
FROM `employees` AS e
JOIN `departments` AS d
ON d.`department_id` = e.`department_id`
WHERE e.`salary` > 15000
ORDER BY d.`department_id` DESC LIMIT 5;

#5.	Employees Without Project
SELECT e.`employee_id`, e.`first_name`
FROM `employees` AS e
WHERE e.`employee_id` NOT IN
(SELECT `employee_id` FROM `employees_projects`)
ORDER BY e.`employee_id` DESC LIMIT 3;

#6.	Employees Hired After
SELECT e.`first_name`, e.`last_name`, e.`hire_date`, d.`name` AS 'dept_name'
FROM `employees` AS e
JOIN `departments` AS d
ON d.`department_id` = e.`department_id`
WHERE YEAR(e.`hire_date`) > '1/1/1999' 
AND d.`name` IN ('Sales', 'Finance')
ORDER BY e.`hire_date` ASC;

USE soft_uni;
#7.	Employees with Project
SELECT e.`employee_id`, e.`first_name`, p.`name` AS 'project_name'
FROM `employees` AS e
JOIN `employees_projects` AS em_pr
ON em_pr.`employee_id` = e.`employee_id`
JOIN `projects` AS p
ON p.`project_id` = em_pr.`project_id`
WHERE DATE(p.`start_date`) > '2002-08-13' AND p.`end_date` IS NULL
ORDER BY e.`first_name` ASC, p.`name` ASC LIMIT 5;	

#8.	Employee 24
SELECT e.`employee_id`, e.`first_name`,
IF(YEAR(p.`start_date`) > 2004, NULL, p.`name`) AS 'project_name'
FROM `employees` AS e
RIGHT JOIN `employees_projects` AS em_pr
ON em_pr.`employee_id` = e.`employee_id`
RIGHT JOIN `projects` AS p
ON p.`project_id` = em_pr.`project_id`
WHERE e.`employee_id` = 24
ORDER BY p.`name` ASC;

#9.	Employee Manager
SELECT e.`employee_id`, e.`first_name`, e.`manager_id`, e2.`first_name`
FROM `employees` AS e
JOIN `employees` AS e2
ON e2.`employee_id` = e.`manager_id`
WHERE e.`manager_id` IN (3, 7)
ORDER BY e.`first_name` ASC;

#10.Employee Summary
SELECT e.`employee_id`,
CONCAT_WS(' ', e.`first_name`, e.`last_name`) AS 'employee_name',
CONCAT_WS(' ', m.`first_name`, m.`last_name`) AS 'manager_name',
d.`name` AS 'department_name'
FROM `employees` AS e
JOIN `employees` AS m
ON e.`manager_id` = m.`employee_id`
JOIN `departments` AS d
ON e.`department_id` = d.`department_id`
ORDER BY e.`employee_id` ASC LIMIT 5;

#11. Min Average Salary
SELECT  AVG(`salary`) AS 'min_average_salary'
FROM `employees`
GROUP BY `department_id`
ORDER BY `min_average_salary` ASC
LIMIT 1;

#12.	Highest Peaks in Bulgaria
USE geography;
SELECT m_c.`country_code`, m.`mountain_range`, p.`peak_name`, p.`elevation`
FROM `countries` AS c
JOIN `mountains_countries` AS m_c
ON m_c.`country_code` = c.`country_code`
JOIN `mountains` AS m
ON m.`id` = m_c.`mountain_id`
JOIN `peaks` AS p
ON p.`mountain_id` = m.`id`
WHERE m_c.`country_code` = 'BG' AND p.`elevation` > 2835
ORDER BY p.`elevation` DESC;


#13.Count Mountain Ranges
SELECT m_c.`country_code`, COUNT(m.`mountain_range`) AS 'mountain_range'
FROM `countries` AS c
JOIN `mountains_countries` AS m_c
ON m_c.`country_code` = c.`country_code`
JOIN `mountains` AS m
ON m.`id` = m_c.`mountain_id`
GROUP BY m_c.`country_code`
HAVING m_c.`country_code` IN ('BG', 'RU', 'US')
ORDER BY `mountain_range` DESC;

#14.Countries with Rivers
SELECT c.`country_name`, r.`river_name`
FROM `continents` con
LEFT JOIN `countries` AS c
ON c.`continent_code` = con.`continent_code`
LEFT JOIN `countries_rivers` AS cr
ON cr.`country_code` = c.`country_code`
LEFT JOIN `rivers` AS r
ON cr.`river_id` = r.`id`
WHERE con.`continent_name` = 'Africa'
ORDER BY c.`country_name` ASC LIMIT 5;

#15. Continents and Currencies
SELECT 
    c.`continent_code`,
    c.`currency_code`,
    COUNT(c.`currency_code`) AS `currency_usage`
FROM
    `countries` AS c
GROUP BY c.`continent_code` , c.`currency_code`
HAVING `currency_usage` > 1
    AND `currency_usage` = (SELECT 
        COUNT(*) AS `most_used_curr`
    FROM
        `countries` AS c2
    WHERE
        c2.`continent_code` = c.`continent_code`
    GROUP BY c2.`currency_code`
    ORDER BY `most_used_curr` DESC
    LIMIT 1)
ORDER BY c.`continent_code` , c.`currency_code`;

#16. Countries Without Any Mountains
SELECT COUNT(c.`country_name`) AS 'country_count'
FROM `countries` AS c
WHERE c.`country_code` NOT IN
(SELECT `country_code` FROM `mountains_countries`);

#17 Highest Peak and Longest River by Country
SELECT c.`country_name`,
MAX(p.`elevation`) AS 'highest_peak_elevation',
MAX(r.`length`) AS 'longest_river_length'
FROM `countries` AS c
JOIN `countries_rivers` AS cr
ON cr.`country_code` = c.`country_code`
JOIN `rivers` AS r
ON r.`id` = cr.`river_id`
JOIN `mountains_countries` AS mc
on mc.`country_code` = c.`country_code`
JOIN `mountains` AS m
ON m.`id` = mc.`mountain_id`
JOIN `peaks` AS p
ON p.`mountain_id` = m.`id`
GROUP BY c.`country_code`
ORDER BY `highest_peak_elevation` DESC,
`longest_river_length` DESC,
 c.`country_name` ASC LIMIT 5;






























































