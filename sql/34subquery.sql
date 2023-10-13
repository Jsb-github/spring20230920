-- 비상관쿼리 : 외부쿼리의 컬럼이 내부쿼리에 사용되지 않을 때

SELECT COUNT(*) FROM customers s
WHERE Country = -- 외부 쿼리
      (SELECT Country FROM suppliers WHERE SupplierID = 1); -- 내부쿼리

-- 상관쿼리 : 외부쿼리의 컬럼이 내부쿼리에 사용될 때

SELECT
    s.supplierID,
    (SELECT COUNT(*)
     FROM customers
     WHERE customers.Country = s.Country) AS `Number Of Cusomters`
    -- 외부 suppliers s가    s.country 내부 쿼리로 사용 되서 상관쿼리
FROM suppliers s;




-- 각 공급자가 있는 나라의 고객 수는?
USE w3schools;
SELECT * FROM suppliers;

SELECT COUNT(*) FROM customers
WHERE Country = (SELECT Country FROM suppliers WHERE SupplierID = 1);
SELECT COUNT(*) FROM customers
WHERE Country = (SELECT Country FROM suppliers WHERE SupplierID = 2);
SELECT COUNT(*) FROM customers
WHERE Country = (SELECT Country FROM suppliers WHERE SupplierID = 3);
SELECT COUNT(*) FROM customers
WHERE Country = (SELECT Country FROM suppliers WHERE SupplierID = 4);

SELECT
    s.supplierID,
    (SELECT COUNT(*)
     FROM customers
     WHERE customers.Country = s.Country) AS `Number Of Cusomters`
FROM suppliers s;

-- 예) 각 직원보다 나이가 많은 직원의 수 (lastName, NumberOfEmp)
SELECT * FROM employees;

SELECT
      (SELECT COUNT(*)
       FROM employees e
       WHERE s.BirthDate > e.BirthDate) NumberOfEmp
FROM employees s;