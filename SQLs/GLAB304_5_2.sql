SELECT    customername, country
FROM    customers
WHERE    country = 'USA' OR country = 'France';
SELECT    customername, country, creditLimit  
FROM    customers
WHERE (country = 'USA' OR country = 'France') AND creditlimit > 100000;

SELECT     productCode,  productName,  buyPrice 
FROM    products
WHERE     buyPrice BETWEEN 90 AND 100;
SELECT productCode, productName, buyPrice 
FROM products
WHERE  buyPrice >= 90 AND buyPrice <= 100;




SELECT productCode, productName, buyPrice FROM products 
WHERE buyPrice NOT BETWEEN 20 AND 100;




SELECT productCode, productName, buyPrice FROM products
WHERE  buyPrice < 20     OR     buyPrice > 100; 

SELECT customerName, country, salesrepemployeenumber
FROM customers
WHERE salesrepemployeenumber IS NULL
ORDER BY  customerName; 

SELECT customerName, country, salesrepemployeenumber
FROM  customers
WHERE  salesrepemployeenumber IS NOT NULL
ORDER BY customerName;

SELECT  c.customerNumber, c.customerName,  orderNumber, o.STATUS
FROM customers c
LEFT JOIN orders o 
ON c.customerNumber = o.customerNumber
WHERE  orderNumber IS NULL;

