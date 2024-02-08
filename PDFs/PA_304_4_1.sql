SELECT productName as "Name", productLine as "Product Line" , buyPrice as "Buy Price" FROM products ORDER BY buyPrice DESC;

SELECT contactLastName as "Last Name" , contactFirstName AS "First Name", city AS "City" FROM customers
ORDER BY contactLastName ASC;

SELECT DISTINCT status FROM orders ORDER BY status;

SELECT * FROM payments
WHERE paymentDate >= '2005-01-01'
ORDER BY paymentDate DESC;

SELECT lastName as "Last Name", firstName as "First Name", email as "email address", jobTitle as "job title" FROM employees
WHERE officeCode=1
ORDER BY lastName;

SELECT * FROM products
WHERE productLine IN ('Classic Cars', 'Vintage Cars')
ORDER BY 
	CASE WHEN productLine = 'Vintage Cars' THEN 0 ELSE 1 END, productName;
;