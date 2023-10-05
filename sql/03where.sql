SELECT CustomerName,Address,City,Country FROM customers;

-- WHERE : 레코드 선택(솎아내기)
SELECT * FROM customers WHERE CustomerID = 1;

SELECT * FROM  customers WHERE  CustomerID = 2;

SELECT * FROM  customers WHERE  Country ='USA';

SELECT *
FROM  customers
WHERE  Country ='Mexico';

SELECT *
FROM customers
WHERE Country = 'mexico';

SELECT  *
FROM customers
WHERE Country = 'MEXICO'; -- 대소문자 구분 안함

SELECT *
FROM customers
WHERE Country = 'France'; -- 문자열은 ''

SELECT  *
FROM customers
WHERE Country = 'France'; -- 문자열은 ''

SELECT *
FROM customers
WHERE CustomerID = 3; -- 수형식은 따움표 없이

SELECT *
FROM customers
WHERE CustomerID = '3';

-- 예) 영국(uk)에 사는 고객들 조회
SELECT *
FROM customers
WHERE Country ='uk';

-- 예) 1번 카테고리에 속한 상품(Products)들 조회
SELECT *
FROM products
WHERE CategoryID =1;

-- 예) 0Saka에 있는 공급자들 조회
SELECT *
FROM suppliers
WHERE City ='osaka';


-- 미국에 사는 고객의 이름들 조회
SELECT CustomerName
FROM customers
WHERE Country ='USA';

-- 영국에 사는 고객이름과, 고객번호 조회
SELECT CustomerID,CustomerName
FROM customers
WHERE Country = 'UK';

-- 예) 2번 카테고리에 있는 삼풍명과 가격조회
SELECT  ProductName,Price
FROM products
WHERE CategoryID = 2;


-- 예) 일본에 있는 공급자의 이름(SupplierName과 전화번호 조회
SELECT SupplierName, Phone
FROM suppliers
WHERE Country = 'japan';

-- 예) 2번 카테고리의 이름(categoryName) 조회
SELECT CategoryName
FROM categories
WHERE CategoryID = 2;



SELECT ProductID,ProductName,Unit,Price
FROM  products;

SELECT *
FROM customers
WHERE Country = 'spain';