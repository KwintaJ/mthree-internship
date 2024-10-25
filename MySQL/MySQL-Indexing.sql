-- Indexing is used only for DDL
-- it speeds up data retrieval process

CREATE DATABASE IF NOT EXISTS boyscouts;
USE boyscouts;

DROP TABLE IF EXISTS badges;
CREATE TABLE badges
(
    badgeName VARCHAR(255),
    badgeRank VARCHAR(255)
);

INSERT INTO badges VALUES
    ("First Aid", "Eagle"),
    ("Hiking", "Eagle"),
    ("Music", "Merit"),
    ("Sports", "Merit"),
    ("Lifesaving", "Eagle"),
    ("Chess", "Merit"),
    ("Bird Study", "Merit"),
    ("Cooking", "Eagle");

CREATE INDEX badgeIndex ON badges(badgeName ASC);
SELECT * FROM badges USE INDEX(badgeIndex);

CREATE OR REPLACE VIEW EagleBadges AS
    SELECT badgeName as eagleBadge FROM badges
    WHERE badgeRank = "Eagle";

SELECT * FROM EagleBadges;