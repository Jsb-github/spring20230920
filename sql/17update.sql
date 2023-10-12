-- UPDATE

SELECT *
FROM products;

SELECT *
FROM products
WHERE ProductID =4;


UPDATE products
SET ProductName ='차이즈',
    Unit ='10박스',
    Price = 36.00
WHERE ProductID = 4;

UPDATE products
SET ProductName = '두부김치'; -- where 꼭 쓸 것 !!!!!!!!!!!

SELECT *
FROM customers;
-- 예) 1번 고객의 이름 수정하기
UPDATE customers
SET CustomerName='손흥민'
WHERE CustomerID = 3;

SELECT *
FROM employees;
-- 예) 5번 직원에 notes 변경하기
UPDATE employees
SET Notes ='축구'
WHERE EmployeeID = 5;

SELECT *
FROM suppliers;
-- 예) 1번 공급자의 전화번호, 주소 변경하기
UPDATE suppliers
SET Phone ='010-0000-0000',
    Address ='파리'
WHERE SupplierID =1;


--
SELECT *
FROM products
WHERE CategoryID = 1;

UPDATE products
SET Price = Price * 2
WHERE CategoryID = 1;

SELECT *
FROM shippers
WHERE ShipperID;


SELECT *
FROM employees;
