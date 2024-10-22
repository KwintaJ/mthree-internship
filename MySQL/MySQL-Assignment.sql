CREATE DATABASE IF NOT EXISTS company;
USE company;


-- Schema
DROP TABLE IF EXISTS students;
CREATE TABLE IF NOT EXISTS students (
    student_id INT NOT NULL,
    student_name VARCHAR(255),
    age INT UNSIGNED,
    gender VARCHAR(10),
    PRIMARY KEY (student_id)
);

DROP TABLE IF EXISTS courses;
CREATE TABLE IF NOT EXISTS courses (
    course_id INT NOT NULL,
    course_name VARCHAR(255),
    instructor VARCHAR(255),
    PRIMARY KEY (course_id)
);

DROP TABLE IF EXISTS enrollments;
CREATE TABLE IF NOT EXISTS enrollments (
    enrollment_id INT NOT NULL,
    student_id INT,
    course_id INT,
    grade VARCHAR(2),
    PRIMARY KEY (enrollment_id)
);


-- Data
INSERT INTO students VALUES
    (1, "Smith", 20, "F"),
    (2, "Brown", 25, "M"),
    (3, "Roberts", 19, "F"),
    (4, "Potter", 23, "M");

INSERT INTO courses VALUES
    (1, "English", "Kate"),
    (2, "Maths", "Bob"),
    (3, "Computer Science", "Bob"),
    (4, "Philosophy", "Kate");

INSERT INTO enrollments VALUES
    (1, 1, 1, "A"),
    (2, 1, 2, "C"),
    (3, 1, 3, "A"),
    (4, 2, 1, "A"),
    (5, 2, 4, "B"),
    (6, 3, 1, "B"),
    (7, 3, 2, "B"),
    (8, 4, 1, "C");


-- Queries
SELECT c.course_name, count(e.student_id) AS "students_count"
    FROM enrollments e
    INNER JOIN courses c 
    ON e.course_id = c.course_id
        WHERE e.grade = 'A'
        GROUP BY c.course_name
        ORDER BY students_count DESC;

SELECT DISTINCT student_name as "students_who_have_A" 
    FROM enrollments e 
    JOIN students s 
    ON e.student_id = s.student_id 
    WHERE grade LIKE "A";

SELECT * FROM

