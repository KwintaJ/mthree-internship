CREATE DATABASE IF NOT EXISTS lti;
USE lti;

-- Window Function Strcture
--    window_function_name(expression) OVER ( 
--        [partition_defintion]
--        [order_definition]
--        [frame_definition]
--    )

DROP TABLE IF EXISTS sales;
CREATE TABLE sales
(
    year INT,
    country VARCHAR(20),
    product VARCHAR(32),
    profit INT
);

INSERT INTO sales VALUES
    (2200, 'Finland', 'Computer'  ,     1700),
    (2200, 'Finland', 'Phone'     ,     120), 
    (2201, 'Finland', 'Phone'     ,     10),
    (2200, 'India'  , 'Calculator',     75),
    (2200, 'India'  , 'Calculator',     75),
    (2200, 'India'  , 'Computer'  ,   1220),
    (2200, 'USA'    , 'Calculator',     75),
    (2200, 'USA'    , 'Computer'  ,   1700),
    (2201, 'USA'    , 'Calculator',     50),
    (2201, 'USA'    , 'Computer'  ,   1700),
    (2201, 'USA'    , 'Computer'  ,   1220),
    (2201, 'USA'    , 'TV'        ,    170),
    (2201, 'USA'    , 'TV'        ,    120);


SELECT * FROM sales;

-- 1. gives sinlge values using aggregate functions
SELECT SUM(profit) AS total_profit FROM sales;

-- 2. gives multi values using aggregate functions with group by with sorting using oreder by
SELECT country, SUM(profit) AS country_profit
       FROM sales
       GROUP BY country
       ORDER BY country;


-- 3. window functions provide multi values for each rows for comparision

-- using only OVER()
SELECT
    year, country, product, profit,
    SUM(profit) OVER() AS total_profit
FROM sales
ORDER BY country, year, product, profit;

-- other window functions avg(), sum(), min(), max(), count() --> comes as aggregate functions
SELECT
    year, country, product, profit,
    SUM(profit) OVER() AS total_profit
FROM sales
ORDER BY country, year, product, profit;


-- using OVER(PARTITION BY)
SELECT
    year, country, product, profit,
    SUM(profit) OVER(PARTITION BY country) AS country_profit
FROM sales
ORDER BY country, year, product, profit;


-- non aggregate functions 
-- FIRST_VALUE(), LAST_VALUE()
-- LAG(), LEAD()
-- RANK(), DENSE_RANK()


-- FIRST_VALUE(), LAST_VALUE()

SELECT
    year, country, product, profit,
    FIRST_VALUE(profit) OVER() AS country_profit
FROM sales
ORDER BY country, year, product, profit;

SELECT
    year, country, product, profit,
    FIRST_VALUE(profit) OVER(PARTITION BY country) AS country_profit
FROM sales
ORDER BY country, year, product, profit;

SELECT
    year, country, product, profit,
    LAST_VALUE(profit) OVER(PARTITION BY country) AS country_profit
FROM sales
ORDER BY country, year, product, profit;


-- LAG(), LEAD() 

-- LAG(expression,offset, default_value) 
-- offset by default it is 1
-- default_value any value that you want to set if previous row is absent

DROP TABLE IF EXISTS sales_two;
CREATE TABLE sales_two(
    sales_emp VARCHAR(10),
    finance_year INT,
    sale DECIMAL(10,2)
);

INSERT INTO sales_two(sales_emp,finance_year,sale)
VALUES('Manav',2024,120),
      ('Manav',2023,170),
      ('Manav',2022,220),
      ('Srujana',2024,170),
      ('Srujana',2023,120),
      ('Srujana',2022,220),
       ('Girdhar',2024,220),
      ('Girdhar',2023,170),
      ('Girdhar',2022,250);
      
SELECT * FROM sales_two;


SELECT 
  sales_emp, 
  finance_year, 
  sale, 
  LAG(sale, 1 , 0) OVER (
    PARTITION BY sales_emp 
    ORDER BY finance_year 
  ) 'previous year sale' 
FROM 
  sales_two;
  

SELECT * FROM sales_two;

  
-- LEAD() 

SELECT 
  sales_emp, 
  finance_year, 
  sale, 
  LEAD(sale, 1 , 0) OVER (
    PARTITION BY sales_emp 
    ORDER BY finance_year
  ) 'next year sale' 
FROM 
  sales_two;
  
  
-- RANK() DENSE_RANK()

DROP TABLE IF EXISTS sales_values;
CREATE TABLE sales_values (valueIS INT);

INSERT INTO sales_values(valueIS) VALUES
    (1),(2),(2),(3),(4),(4),(5);


SELECT * FROM sales_values;


-- using rank() function for the same table

SELECT
    valueIS,
    RANK() OVER (
        ORDER BY valueIS
    ) my_rank
FROM
    sales_values; 
    
DROP TABLE IF EXISTS sales_three;
CREATE TABLE sales_three(
    sales_emp VARCHAR(50) NOT NULL,
    finance_year INT NOT NULL,
    sale DECIMAL(10,2) NOT NULL,
    PRIMARY KEY(sales_emp,finance_year)
);

INSERT INTO sales_three(sales_emp,finance_year,sale)
VALUES('Manav',2024,120),
      ('Manav',2023,170),
      ('Manav',2022,220),
      ('Srujana',2024,170),
      ('Srujana',2023,120),
      ('Srujana',2022,220),
       ('Girdhar',2024,220),
      ('Girdhar',2023,170),
      ('Girdhar',2022,250);
      
SELECT * FROM sales_three;


-- rank()

SELECT
    sales_emp,
    finance_year,
    sale,
    RANK() OVER (
    PARTITION BY finance_year
    ORDER BY sale DESC
                ) sales_rank
FROM
    sales_three;
    
-- dense_rank()

SELECT
    valueIS,
    DENSE_RANK() OVER (
        ORDER BY valueIS
    ) my_rank
FROM
    sales_values; 
    
    
SELECT
    sales_emp,
    finance_year,
    sale,
    DENSE_RANK() OVER (
    PARTITION BY finance_year
    ORDER BY sale DESC
                ) sales_rank
FROM
    sales_three;
    


-- NTH_VALUE() select values from particular row REFER SALES TABLE
select * from sales;

SELECT
    year,
    country,
    profit,
    NTH_VALUE(country, 2) OVER  (
        ORDER BY profit DESC
    ) second_highest_profit
FROM
    sales;

-- NTILE()   used to divide rows among groups based on given number

DROP TABLE IF EXISTS sales_values_two;
CREATE TABLE sales_values_two (valueIS INT);

INSERT INTO sales_values_two(valueIS) VALUES
    (1),(2),(3),(4),(5),(6),(7);


SELECT * FROM sales_values_two;

SELECT
    valueIS,
    NTILE(3) OVER (
        ORDER BY valueIS
    ) my_rank
FROM
    sales_values_two; 
    