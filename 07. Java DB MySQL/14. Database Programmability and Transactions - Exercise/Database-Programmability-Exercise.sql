USE soft_uni;

#1.Employees with Salary Above 35000
DELIMITER ###
CREATE PROCEDURE `usp_get_employees_salary_above_35000` ()
BEGIN
SELECT `first_name`, `last_name` FROM `employees`
WHERE `salary` > 35000
ORDER BY `first_name` ASC, `last_name` ASC, `employee_id` ASC;
END
###

#2.	Employees with Salary Above Number
DELIMITER ###
CREATE PROCEDURE `usp_get_employees_salary_above`(number_for_equals DECIMAL(12, 4))
BEGIN
SELECT `first_name`, `last_name` FROM `employees`
WHERE `salary` >= number_for_equals
ORDER BY `first_name` ASC, `last_name` ASC, `employee_id` ASC;
END
###

# 3. Town Names Starting With
DELIMITER ###
CREATE PROCEDURE usp_get_towns_starting_with(town_start_letter TEXT)
BEGIN
    SELECT `name` FROM `towns`
    WHERE `name` LIKE CONCAT(town_start_letter, '%')
    ORDER BY `name`;
END
###

#4.	Employees from Town
DELIMITER ###
CREATE PROCEDURE `usp_get_employees_from_town` (town_name VARCHAR(50))
BEGIN
SELECT e.`first_name`, e.`last_name`
FROM `employees` AS e
JOIN `addresses` AS a
ON a.`address_id` = e.`address_id`
JOIN `towns` AS t
ON t.`town_id` = a.`town_id`
WHERE t.`name` = town_name
ORDER BY e.`first_name` ASC, e.`last_name` ASC, e.`employee_id` ASC;
END
###

#5.	Salary Level Function
DELIMITER ###
CREATE FUNCTION `ufn_get_salary_level` (employee_salary DECIMAL)
RETURNS VARCHAR(10)
DETERMINISTIC
BEGIN
DECLARE salary_Level VARCHAR(10);
SET salary_Level :=
(SELECT
CASE
WHEN `employee_salary` < 30000 THEN 'Low'
WHEN `employee_salary` BETWEEN 30000 AND 50000 THEN 'Average'
ELSE 'High'
END);
RETURN salary_Level;
END;
###

#6.	Employees by Salary Level

CREATE PROCEDURE `usp_get_employees_by_salary_level` (salary_level VARCHAR(20))
BEGIN
SELECT e.`first_name`, e.`last_name` 
FROM `employees` AS e
WHERE (SELECT ufn_get_salary_level(e.`salary`) = salary_level)
ORDER BY e.`first_name` DESC, e.`last_name` DESC;
END;

#7.	Define Function
DELIMITER ###
CREATE FUNCTION ufn_is_word_comprised(set_of_letters varchar(50), word varchar(50))
RETURNS BIT
DETERMINISTIC
BEGIN
	RETURN word REGEXP (concat('^[',set_of_letters,']*$'));
END
###

#8. Find Full Name
DELIMITER ###
CREATE PROCEDURE `usp_get_holders_full_name` ()
BEGIN
SELECT concat_ws(' ', `first_name`, `last_name`) AS 'full_name'
FROM `account_holders`
ORDER BY `full_name` ASC, `id` ASC;
END;
###

#9.	People with Balance Higher Than
DELIMITER ###
CREATE PROCEDURE usp_get_holders_with_balance_higher_than (money DECIMAL(19,4))
BEGIN
SELECT first_name, last_name FROM account_holders as ah
	RIGHT JOIN accounts as ac ON ac.account_holder_id = ah.id
    GROUP BY ah.id
    HAVING sum(balance) > money
    ORDER BY ah.id;
END
###

#10.Future Value Function
    
DELIMITER ##
CREATE FUNCTION ufn_calculate_future_value (sum DECIMAL(19,4), interest DECIMAL(19,4), num_years INT)
RETURNS DECIMAL(19,4)
DETERMINISTIC
BEGIN
	RETURN sum * (pow((1 + interest), num_years));
END
##

#11.Calculating Interest
DELIMITER ##
CREATE PROCEDURE usp_calculate_future_value_for_account(acc_id INT, interest DECIMAL(19,4))
BEGIN
	SELECT ac.id AS 'account_id', ah.first_name, ah.last_name, ac.balance AS 'current_balance',
			ufn_calculate_future_value(ac.balance, interest, 5)
		FROM accounts AS ac
		JOIN account_holders AS ah ON ah.id = ac.account_holder_id
		WHERE ac.id = acc_id;
END
##

#12.Deposit Money
  
DELIMITER ###
CREATE PROCEDURE usp_deposit_money(account_id INT, money_amount DECIMAL(19,4))
BEGIN
	START TRANSACTION;
    IF ((SELECT count(a.id) FROM accounts as a WHERE a.id = account_id) != 1 OR money_amount < 0)
		THEN ROLLBACK;
		ELSE
			UPDATE accounts set balance = balance + money_amount WHERE id = account_id;
			COMMIT;
	END IF;
END
###

#13.Withdraw Money
DELIMITER ###
CREATE PROCEDURE usp_withdraw_money(account_id INT, money_amount DECIMAL(19,4))
BEGIN
	START TRANSACTION;
    IF((SELECT count(a.id) FROM accounts as a WHERE a.id = account_id) != 1 OR
		money_amount < 0 OR
        (SELECT balance FROM accounts WHERE id = account_id) < money_amount)
        THEN ROLLBACK;
        ELSE
			UPDATE accounts SET balance = balance - money_amount WHERE id = account_id;
            COMMIT;
		END IF;
END
###

#14. Money Transfer
DELIMITER ###
CREATE PROCEDURE usp_transfer_money(from_account_id INT, to_account_id INT, amount DECIMAL(19,4))
BEGIN
	START TRANSACTION;
    IF (
		(SELECT count(a.id) FROM accounts as a WHERE a.id = from_account_id) != 1 OR
        (SELECT count(a.id) FROM accounts as a WHERE a.id = to_account_id) != 1 OR
        amount < 0 OR from_account_id = to_account_id OR
        (SELECT balance FROM accounts WHERE id = from_account_id) < amount
	)	THEN ROLLBACK;
		ELSE
			UPDATE accounts SET balance = balance - amount WHERE id = from_account_id;
			UPDATE accounts SET balance = balance + amount WHERE id = to_account_id;
            COMMIT;
	END IF;
END
###

#15.	Log Accounts Trigger
CREATE TABLE logs (
	log_id INT PRIMARY KEY AUTO_INCREMENT,
    account_id INT NOT NULL,
    old_sum DECIMAL(19,4) NOT NULL,
    new_sum DECIMAL(19,4) NOT NULL
);

DELIMITER ###
CREATE TRIGGER tr_transaction_log
AFTER UPDATE
ON accounts
FOR EACH ROW
BEGIN
	INSERT INTO logs SET account_id = old.id, old_sum = old.balance,
		new_sum = (SELECT balance FROM accounts WHERE id = old.id);
END
###

#16.Emails Trigger

SELECT date_format(current_timestamp(), '%b %e %Y at %l:%i:%s %p');

CREATE TABLE notification_emails (
	id INT PRIMARY KEY AUTO_INCREMENT,
    recipient INT NOT NULL,
    subject VARCHAR(100),
    body TEXT
);

DELIMITER ###
CREATE TRIGGER tr_notification_emails
BEFORE INSERT
ON logs
FOR EACH ROW
BEGIN
	INSERT INTO notification_emails SET
			recipient = new.account_id,
            subject = concat('Balance change for account: ', new.account_id),
            body = concat('On ', date_format(current_timestamp(), '%b %e %Y at %l:%i:%s %p'),
					'AM your balance was changed from ', new.old_sum,
                    ' to ', new.new_sum, '.');

END
###




















































































