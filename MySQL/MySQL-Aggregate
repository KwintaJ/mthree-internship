USE Students;

-- Simple sum, min, max, avg
SELECT SUM(Age) AS "SumOfAges" 
    FROM StudentInfo;

SELECT MIN(Age) AS "YoungestStudentAge" 
    FROM StudentInfo;

SELECT MAX(Age) AS "EldestStudentName" 
    FROM StudentInfo;

SELECT AVG(Age) AS "AverageAge" 
    FROM StudentInfo;

-- Like, wildcards
SELECT * FROM StudentInfo
    WHERE Name LIKE "J%";

SELECT * FROM StudentInfo
    WHERE Name LIKE "__a%";

    -- % = multiple characters
    -- _ = one character

-- Grouping
SELECT AVG(Age) AS "AverageAgeByGender", Gender
    FROM StudentInfo 
    GROUP BY Gender;
-- Having
SELECT AVG(Age) AS "AverageAgeOfWomen"
    FROM StudentInfo 
    GROUP BY Gender
    HAVING Gender LIKE "F";


-- Sorting
SELECT Name, Age FROM StudentInfo ORDER BY Age DESC;
