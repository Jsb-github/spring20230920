USE w3schools;

SELECT *
FROM products p JOIN suppliers s
    ON p.ProductID = s.SupplierID

    ;

SELECT *
FROM products p JOIN suppliers s
    USING (supplierID);

SELECT *
FROM products p NATURAL  JOIN suppliers s;
