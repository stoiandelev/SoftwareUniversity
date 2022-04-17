#1.	Find Book Titles start with The
SELECT `title` FROM `books`
WHERE `title` LIKE 'The%'
ORDER BY `id`;

#2.	Replace Titles
SELECT replace(`title`, 'The', '***') FROM `books`
WHERE `title` LIKE 'The%'
ORDER BY `id`;

#3.	Sum Cost of All Books
SELECT round(SUM(`cost`), 2) FROM `books`;

#4.	Days Lived
SELECT concat(`first_name`, ' ', `last_name`) AS `full_name`,
timestampdiff(day, `born`, `died`) AS `days_lived`
FROM `authors`;

#5.	Harry Potter Books
SELECT `title` FROM `books`
WHERE `title` LIKE 'Harry Potter%'










