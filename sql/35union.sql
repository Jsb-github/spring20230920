-- union 합집합

USE w3schools;

SELECT  Country FROM customers; -- 91
SELECT  Country FROM suppliers; -- 29

SELECT DISTINCT Country FROM customers; -- 21
SELECT DISTINCT Country FROM suppliers; -- 16

SELECT  Country FROM customers
UNION ALL
SELECT Country FROM suppliers;


SELECT CustomerName, Country, City FROM customers
UNION
SELECT SupplierName,Country, City FROM suppliers;

-- 예) 직원의 lastName과 firstName을 name이라는 하나의 컬럼으로 조회

SELECT LastName name FROM employees
UNION ALL
SELECT FirstName FROM employees;



-- FULL OUTRE JOIN

-- LEFT OUTER JOIN
SELECT * FROM  my_table44_a  a LEFT JOIN my_table45_b b
ON a.col1 = b.col1;

-- RIGHT OUTRE JOIN
SELECT * FROM  my_table44_a  a RIGHT JOIN my_table45_b b
ON a.col1 = b.col1;


-- FULL OUTRE JOIN

SELECT * FROM  my_table44_a  a LEFT JOIN my_table45_b b
     ON a.col1 = b.col1
UNION
SELECT * FROM  my_table44_a  a RIGHT JOIN my_table45_b b
     ON a.col1 = b.col1;