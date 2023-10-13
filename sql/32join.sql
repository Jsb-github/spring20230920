USE w3schools;
-- self join
SELECT CONCAT(e1.FirstName, e1.LastName)name, e1.BirthDate
FROM employees e1 JOIN employees e2
WHERE e1.BirthDate < e2.BirthDate
     AND e2.LastName='Leverling';


-- 예) `Ipoh coffee`보다 비싼 상품명 조회

SELECT p1.ProductName ,p1.Price
FROM products p1 JOIN products p2
WHERE p1.Price > p2.Price
        AND p2.ProductName ='Ipoh coffee'
ORDER BY Price ;


SELECT ProductName,Price
FROM products
WHERE ProductName = 'Ipoh coffee';