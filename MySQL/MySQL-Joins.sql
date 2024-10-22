USE Students;

CREATE TABLE IF NOT EXISTS Subjects (
    SubjectID INT UNSIGNED NOT NULL AUTO_INCREMENT,
    SubjectName VARCHAR(255),
    PRIMARY KEY (SubjectID)
);

CREATE TABLE IF NOT EXISTS StudentMarks (
    ID INT UNSIGNED NOT NULL,
    SubjectID INT UNSIGNED NOT NULL,
    Mark INT UNSIGNED
);

-- INSERT INTO Subjects(SubjectName) values
--     ("Algebra"), ("Calculus 101"), ("English C1"),
--     ("Philosophy"), ("Quantum Mechanics"), ("Networking"), 
--     ("Descrete Mathematics"), ("Statistics and Probability Theory"), 
--     ("Digital Electronics");

-- INSERT INTO StudentMarks(ID, SubjectID, Mark) values
--     (1, 1, 70), (1, 3, 72), (1, 4, 65), (1, 8, 100), (1, 9, 93),
--     (2, 2, 71), (2, 3, 70), (2, 5, 33), (2, 6, 50), (2, 7, 87),
--     (3, 1, 84), (3, 2, 84), (3, 4, 85), (3, 6, 13), (3, 7, 100), (3, 9, 98),
--     (4, 5, 99), (4, 6, 94), (4, 7, 96), (4, 8, 100), (4, 9, 100),
--     (5, 1, 0), (5, 3, 54), (5, 5, 67), (5, 6, 69), (5, 8, 71),
--     (6, 1, 70), (6, 2, 85), (6, 5, 88), (6, 9, 90), (7, 3, 100);

-- Simple join on, natural join
SELECT StudentInfo.ID as "StudentID", 
    Name as "StudentName", 
    SubjectName, 
    Mark 
        FROM StudentInfo 
        JOIN StudentMarks 
        ON StudentInfo.ID = StudentMarks.ID
        NATURAL JOIN Subjects;

-- Average per subject
SELECT SubjectName, AVG(Mark) as "AverageMark"
    FROM StudentInfo 
    JOIN StudentMarks 
    ON StudentInfo.ID = StudentMarks.ID
    JOIN Subjects
    ON Subjects.SubjectID = StudentMarks.SubjectID
    GROUP BY SubjectName;

-- Average per student
SELECT StudentInfo.ID as "StudentID",
    Name as "StudentName",
    AVG(Mark) as "AverageMark"
        FROM StudentInfo 
        JOIN StudentMarks 
        ON StudentInfo.ID = StudentMarks.ID
        JOIN Subjects
        ON Subjects.SubjectID = StudentMarks.SubjectID
        GROUP BY StudentInfo.ID;

-- Self join
-- Prints out pair of students with the same age
SELECT a.Name, b.Name
    FROM StudentInfo a
    JOIN StudentInfo b
    ON a.Age = b.Age
    WHERE a.Name != b.Name;
