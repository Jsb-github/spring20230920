-- INSERT INTO tableName (columName1, columnName2, ....)
-- VALUES (value1,value2, ....)

INSERT INTO employees(EmployeeID, LastName, FirstName, BirthDate, Photo, Notes)
VALUE (10,'손','흥민','2000-01-01','사진10','epl 득점왕');

SELECT *
FROM employees
ORDER BY EmployeeID DESC ;


INSERT INTO  employees(employeeid, lastname, firstname, birthdate, photo, notes)
VALUE (11,'이','강인','2000-02-02','사진11','드리블 잘함');


-- 모든 컬럼에 값 넣을 떄 컬럼명 나열 생략 가능
INSERT INTO employees
VALUE (12,'김','민재','2000-03-03','사진12','수비잘함');


-- 특정 컬럼에만 값을 넣을 떄 컬럼명 나열 생략하면 안됨
INSERT INTO employees(EmployeeID,LastName,FirstName)
VALUE (13,'박','지성'); -- 나열된 컬럼명과 값의 순서, 갯수가 같아야함

SELECT *
FROM employees
ORDER BY EmployeeID DESC ;

INSERT INTO employees(EmployeeID, LastName, FirstName)
VALUE (14,'차','범근');

INSERT INTO employees(EmployeeID, LastName, FirstName)
    VALUE (15,'김','두식','하늘은 난다');

INSERT INTO employees(EmployeeID, LastName, FirstName)
    VALUE (16,'김');

SELECT *
FROM employees
ORDER BY EmployeeID DESC ;

-- 값에 타입에 따라 넣는 방법이 다름
INSERT INTO employees(EmployeeID)
VALUE (15);


INSERT INTO employees(EmployeeID)
    VALUE ('16');


INSERT INTO employees(LastName)
VALUE ('son');

INSERT INTO employees(LastName)
value ('10000');  -- 따움표 사용 권장

INSERT INTO employees(LastName)
    value (10000); -- 되긴 됨


INSERT INTO employees(BirthDate)
value ('2000-01-01');


SELECT *
FROM employees
ORDER BY EmployeeID DESC ;

SELECT *
FROM products;

INSERT INTO products(Price)
value (20.10);

INSERT INTO products(ProductID,Price)
    value (79,'30.33'); -- 되긴 됨

INSERT INTO products(Price)
    value ('thirteen');  -- 안됨


SELECT *
FROM products
ORDER BY ProductID DESC;
-- 예) 80 번 상품 입력(productId, productName, supplierId categoryId unit price)
INSERT INTO products(productid, productname, supplierid, categoryid, unit, price)
value (80,'과자',15,2,'1box',20.00);

-- 예) 새 상품 입력(productName, supplierId categoryId unit price)
INSERT INTO products(productname, supplierid, categoryid, unit, price)
value ('초코송이',15,3,'1box',50.00);


INSERT INTO products(ProductID,productname, supplierid, categoryid, unit, price)
    value (82,'초코송이',15,3,'1box',50.00);

INSERT INTO products
    value (83,'초코송이',15,3,'1box',50.00);


SELECT *
FROM suppliers
ORDER BY SupplierID DESC ;

SELECT *
FROM employees
ORDER BY EmployeeID DESC;

SELECT *
FROM employees
WHERE LastName = 'Fuller';