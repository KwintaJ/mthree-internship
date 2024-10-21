CREATE DATABASE IF NOT EXISTS Students;

USE Students;

CREATE TABLE IF NOT EXISTS StudentInfo (
    ID INT UNSIGNED NOT NULL AUTO_INCREMENT,
    Name VARCHAR(255),
    Age INT UNSIGNED,
    PRIMARY KEY (ID)
);

INSERT INTO StudentInfo(Name, Age) values
    ("Veryan", 25),
    ("Jan", 21),
    ("Aysu", 21),
    ("Jordan", 25),
    ("Andre", 19),
    ("Joanna", 19),
    ("Vlad", 30);

SELECT * FROM StudentInfo;

-- UPDATE StudentInfo SET Age = 28 WHERE ID = 1;

-- DELETE FROM StudentInfo WHERE ID IN (1, 2);

-- DROP TABLE StudentInfo;