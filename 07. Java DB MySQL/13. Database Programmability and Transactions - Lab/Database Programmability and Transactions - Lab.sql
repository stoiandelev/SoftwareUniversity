USE soft_uni;
#1.	Count Employees by Town
DELIMITER ###
CREATE FUNCTION udf_count_employees_by_town(`town_name` VARCHAR(100))
RETURNS INT 
DETERMINISTIC
BEGIN
	RETURN
    (SELECT  COUNT(*)
	FROM `towns` AS t
	LEFT JOIN `addresses` AS a
	ON a.`town_id` = t.`town_id`
	LEFT JOIN `employees` AS e
	ON e.`address_id` = a.`address_id`
	WHERE t.`name` = `town_name`);
END ###


#2.	Employees Promotion
DELIMITER ###
CREATE PROCEDURE udp_raise_salaries(department_name VARCHAR(100))
BEGIN
UPDATE `employees` AS e
RIGHT JOIN `departments` AS d
ON d.`department_id` = e.`department_id`
SET	`salary` = `salary` * 1.05
WHERE d.`name` = `department_name`;
END
###
CALL usp_raise_salaries('Sales');

#3 Employees Promotion by ID
DELIMITER ###
CREATE PROCEDURE usp_raise_salary_by_id(`id` INT)
BEGIN
    IF(  (SELECT COUNT(*) FROM `employees` WHERE `employee_id` = `id`)  > 0 )
    THEN
	UPDATE `employees`
	SET `salary` = `salary` * 1.05
	WHERE `employee_id` = `id`;
    END IF;

END
###
CALL udp_promote(1);

#4 Triggered
CREATE TABLE deleted_employees(
	employee_id INT PRIMARY KEY AUTO_INCREMENT,
	first_name VARCHAR(20),
	last_name VARCHAR(20),
	middle_name VARCHAR(20),
	job_title VARCHAR(50),
	department_id INT,
	salary DOUBLE 
);

CREATE TRIGGER tr_deleted_employees
AFTER DELETE
ON employees
FOR EACH ROW
BEGIN
	INSERT INTO deleted_employees (first_name,last_name, middle_name,job_title,department_id,salary)
	VALUES(OLD.first_name,OLD.last_name,OLD.middle_name, OLD.job_title,OLD.department_id,OLD.salary);
END;

SELECT * FROM `employees`














































