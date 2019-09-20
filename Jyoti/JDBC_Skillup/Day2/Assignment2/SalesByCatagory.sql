CREATE PROCEDURE `SalesByCategory` (IN product1 varchar,IN year1 year)
BEGIN
SELECT 
    p.ProductName, SUM(od.UnitPrice * od.Quantity)
FROM
    products AS p
        JOIN
    orderdetails AS od ON p.ProductID = od.ProductID
        JOIN
    categories AS c ON c.CategoryID = p.CategoryID
        JOIN
    orders AS o ON o.OrderID = od.OrderID
WHERE
    YEAR(o.OrderDate) = year1
        AND c.CategoryName = product1
GROUP BY p.ProductName;
END
