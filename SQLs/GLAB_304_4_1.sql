SELECT    orderNumber, orderlinenumber, quantityOrdered * priceEach
FROM    orderdetails
ORDER BY   quantityOrdered * priceEach DESC;

SELECT 
    orderNumber,
    orderLineNumber,
    quantityOrdered * priceEach AS subtotal
FROM    orderdetails
ORDER BY subtotal DESC;
SELECT
	firstName, lastName, reportsTo
FROM employees
ORDER BY reportsTo;

SELECT firstName, lastName, reportsTo
FROM employees
ORDER BY reportsTo DESC;