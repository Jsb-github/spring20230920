USE w3schools;

SELECT * FROM products;

SELECT * FROM categories;

-- chais 상품의 카테고리명은?
SELECT CategoryID FROM products
WHERE ProductName='chais';

SELECT  CategoryName FROM categories
Where  CategoryID = 1;


-- JOIN : 두개의 테이블 결함
SELECT *
FROM categories,products;

SELECT  COUNT(*)
FROM categories JOIN products;

SELECT COUNT(*)
FROM categories; -- 8
SELECT COUNT(*)
FROM products; -- 77

--
CREATE TABLE table_a (
                         product_id INT PRIMARY KEY AUTO_INCREMENT,
                         product_name VARCHAR(20),
                         category_id INT
);
CREATE TABLE table_b (
                         category_id INT PRIMARY KEY AUTO_INCREMENT,
                         category_name VARCHAR(20)
);
INSERT INTO table_b (category_name)
VALUES ('음료수'), ('반찬');
INSERT INTO table_a (product_name, category_id)
VALUES ('콜라', 1),
       ('사이다', 1),
       ('제육', 2),
       ('돈까스', 2),
       ('두부', 2);

SELECT *
FROM table_a JOIN table_b;

-- 두 테이블 결합하면
--  조회된 레코드 수는 A테이블 row * B테이블 row
--        컬럼 수는 A테이블 열 + B테이블 열

SELECT * FROM table_a;
SELECT *
FROM table_a JOIN table_b
WHERE product_name = '콜라'
  AND table_a.category_id = table_b.category_id;
-- 컬럼명이 하나의 테이블에만 있을 때 테이블명 생략 가능
-- 같은 컬럼명이 여러테이블에 있다면 테이블 명 작성

SELECT *
FROM table_a JOIN table_b
WHERE table_a.category_id = table_b.category_id
    AND product_name = '콜라';


SELECT ProductID,ProductName,CategoryName
FROM products JOIN categories
    ON products.CategoryID = categories.CategoryID
WHERE ProductName = 'chais';


SELECT ProductID,ProductName,CategoryName
FROM products AS p JOIN categories AS c
     ON p.CategoryID = c.CategoryID
WHERE ProductName = 'chais';

SELECT *
FROM suppliers;
-- 예) chais 상품을 공급자명, 전화번호
SELECT SupplierName, Phone
FROM products p JOIN suppliers s
    ON p.SupplierID = s.SupplierID
WHERE ProductName = 'chais';


-- 예) 1996년 7월 4일에 주문한 고객명
SELECT CustomerName
FROM customers c JOIN orders o
    ON c.CustomerID = o.CustomerID
WHERE OrderDate = '1996-07-04';

-- 예) 1996년 7월 4일에 주문을 담당한 직원명 e o
SELECT LastName,FirstName
FROM employees e JOIN orders o
    ON e.EmployeeID = o.EmployeeID
WHERE OrderDate = '1996-07-04';


SELECT  * FROM orders WHERE OrderDate ='1996-07-08';


SELECT * FROM products;
SELECT COUNT(*) FROM  products;  -- 77
SELECT COUNT(*) FROM  suppliers; -- 29
SELECT COUNT(*) FROM  categories; -- 8
SELECT  *
FROM products,suppliers,categories;

SELECT *
FROM products p, suppliers s, categories c
WHERE p.SupplierID= s.SupplierID
    AND p.CategoryID = c.CategoryID;

SELECT ProductName,SupplierName,Phone,CategoryName
FROM products p JOIN suppliers s
        ON p.SupplierID= s.SupplierID
     JOIN categories c
        ON  p.CategoryID = c.CategoryID
WHERE p.ProductName ='chais';


-- 예) 'chang' 상품의 공급자명 카테고리명 조회
SELECT SupplierName, CategoryName
FROM products p JOIN  suppliers s
     ON p.SupplierID = s.SupplierID
     JOIN categories c
     ON p.CategoryID = c.CategoryID
WHERE p.ProductName ='chang';


-- 예) 1996년 7월 9일에 주문한 고객명과 처리한 직원명
SELECT CustomerName,SupplierName
FROM orders o JOIN customers c
     ON o.CustomerID = c.CustomerID
     JOIN suppliers s
     ON o.ShipperID = s.SupplierID
WHERE OrderDate = '1996-07-09';


-- 예) 1996년 7월 9일에 주문한 상품명
SELECT ProductName
FROM orderdetails o JOIN orders o1
    ON o.OrderID = o1.OrderID
    JOIN products p
    On o.ProductID = p.ProductID
WHERE OrderDate =  '1996-07-09';

-- 예) 'chang' 상품이 주문된 날짜들
SELECT ProductName,OrderDate,CustomerName,CONCAT(FirstName,LastName)fullName
FROM products p join orderdetails od
    ON p.ProductID = od.ProductID
    JOIN orders o
    ON od.OrderID = o.OrderID
    Join customers c
    ON o.CustomerID = c.CustomerID
    JOIN employees e
    ON  o.EmployeeID = e.EmployeeID
WHERE ProductName ='Chang';


SELECT *
FROM products
WHERE ProductName  ='Chang'
order by ;

SELECT *
FROM orderdetails
WHERE ProductID = 2; -- 44

SELECT p.ProductID, OrderDetailID
FROM products p JOIN orderdetails od
    ON p.ProductID = od.ProductID
WHERE ProductName ='Chang';


SELECT p.ProductName,p.ProductID, OrderDetailID,o.OrderID
FROM products p join orderdetails od
    ON p.ProductID = od.ProductID
    JOIN orders o
    ON od.OrderID = o.OrderID
WHERE ProductName ='Chang';


SELECT p.ProductName,p.ProductID, OrderDetailID,o.OrderID
        ,c.CustomerID
FROM products p join orderdetails od
                     ON p.ProductID = od.ProductID
                JOIN orders o
                     ON od.OrderID = o.OrderID
                Join customers c
                     ON o.CustomerID = c.CustomerID
WHERE ProductName ='Chang';


SELECT *
FROM orders;