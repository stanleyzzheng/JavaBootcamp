SELECT orderNumber, SUM(quantityOrdered) as Qty, 
IF(MOD(SUM(quantityOrdered),2),'Odd','Even') as oddOrEven
FROM orderdetails
GROUP BY orderNumber
ORDER BY orderNumber;
SELECT productCode, 
AVG(quantityOrdered * priceEach) as avg_order_value
FROM orderdetails
GROUP BY productCode;

SELECT productCode, ROUND(AVG(quantityOrdered * priceEach)) AS avg_order_item_value
FROM orderDetails
GROUP BY productCode;
SELECT YEAR(shippeddate) as year,  COUNT(ordernumber) as orderQty
FROM    orders 
GROUP BY YEAR(shippeddate)
ORDER BY YEAR(shippeddate);

SELECT  DAY(orderdate) as dayofmonth, COUNT(*)
FROM    orders WHERE    YEAR(orderdate) = 2004
GROUP BY dayofmonth
ORDER BY dayofmonth;

SELECT orderNumber, DATEDIFF(requiredDate, shippedDate) as  daysLeft
FROM     orders
ORDER BY  daysLeft DESC;


SELECT  DAY(orderdate) as dayofmonth, COUNT(*)
FROM    orders WHERE    YEAR(orderdate) = 2004
GROUP BY dayofmonth
ORDER BY dayofmonth;










