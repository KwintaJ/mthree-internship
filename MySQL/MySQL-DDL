USE Students;

ALTER TABLE StudentInfo ADD COLUMN Gender VARCHAR(2);

UPDATE StudentInfo SET Gender = "F" WHERE ID IN (1, 3, 6);
UPDATE StudentInfo SET Gender = "M" WHERE ID IN (2, 4, 5, 7);

SELECT * FROM StudentInfo;