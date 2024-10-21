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
--     ("Algebra"),
--     ("Calculus 101"),
--     ("English C1"),
--     ("Philosophy"),
--     ("Quantum Mechanics"),
--     ("Networking"),
--     ("Descrete Mathematics"),
--     ("Statistics and Probability Theory"),
--     ("Digital Electronics");

SELECT * FROM Subjects;