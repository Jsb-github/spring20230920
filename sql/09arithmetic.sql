-- 산술 연산자

SELECT *
FROM products
WHERE ProductID = 1;

SELECT Price
FROM products
WHERE ProductID = 1;

SELECT Price+1
FROM products
WHERE ProductID = 1;

SELECT Price -10.5
FROM products
WHERE ProductID = 1;


SELECT Price *3
FROM products
WHERE ProductID = 1;

SELECT Price/5
FROM products
WHERE ProductID = 1;

SELECT ProductName,Price*2
FROM products;

SELECT ProductName +1 ,Price
FROM products; -- 문자열 연결연산은 안됨

SELECT  CONCAT(ProductName,1),Price
FROM products; -- 문자열 연결은 concat 사용

-- 1968-12-08
SELECT LastName,BirthDate
FROM employees
WHERE EmployeeID = 1;

-- 19681209
SELECT LastName,BirthDate+1
FROM employees
WHERE EmployeeID = 1;

SELECT LastName,ADDDATE(BirthDate,INTERVAL 1 DAY )
FROM employees
WHERE EmployeeID = 1; -- 날짜 변경 함수 사용

SELECT *
FROM employees;

SELECT EmployeeID,LastName,FirstName
FROM employees;

SELECT EmployeeID,CONCAT(LastName,FirstName)
FROM employees;

SELECT EmployeeID,CONCAT(LastName,' ',FirstName)
FROM employees;


SELECT EmployeeID,CONCAT(FirstName,' ',LastName)
FROM employees;


SELECT EmployeeID,
       CONCAT(FirstName,' ',LastName)
       ,ADDDATE(BirthDate,INTERVAL 1 Year )
FROM employees;


-- 예) 주문수량(quantity) * 2 결과 조회(orderDEtails)테이블
    SELECT OrderDetailID,OrderID,ProductID,Quantity, Quantity*2
    FROM orderdetails;

-- 예) "city, country 고객테이블 조회
    SELECT CONCAT(City,', ',Country)
    FROM customers;

-- 예)