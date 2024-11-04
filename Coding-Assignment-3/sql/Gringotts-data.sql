USE Gringotts;

INSERT INTO wizards VALUES
--  (id,     , name)
    (10000332, "Albus Dumbledore"),
    (10001334, "Harry Potter"),
    (10001335, "Ronald Weasley"),
    (10001336, "Hermione Granger"),
    (10001337, "Albus Severus Potter"),
    (10001338, "James Potter"),
    (10001339, "Lily Evans"),
    (10001340, "Neville Longbottom"),
    (10001341, "Hannah Abbot"),
    (10001364, "Reg Catermole"),
    (10001365, "Mary Catermole"),
    (10001366, "Crookshanks"),
    (10001367, "Scabbers"),
    (10001368, "Remus Lupin"),
    (10001389, "Nimfadora Tonks"),
    (10001390, "Sirius Black"),
    (10001391, "Regulus Black"),
    (10001392, "Narcissa Malfoy"),
    (10001393, "Lucius Malfoy"),
    (10002880, "Bellatrix Lestrange"),
    (10002881, "Alastor Moody"),
    (10002882, "Quirinius Quirrel"),
    (10002883, "Newt Scamander"),
    (10002884, "Bathilda Bagshot"),
    (10002885, "Arthur Weasley"),
    (10002886, "Kingsley Shacklebolt");

INSERT INTO vaults VALUES
--  (vaultNum, wizard(id), galleon,  sickle, knut)
    (312,      10000332,   12000000, 6000,   45000),
    (313,      10002882,   17862,    0,      0),
    (314,      NULL,       16346879, 50,     67),
    (315,      NULL,       0,        0,      0),
    (316,      10002885,   1,        45,     1000),
    (317,      10001366,   120,      0,      0),
    (318,      10001367,   12436,    345,    2346),
    (168,      10001392,   555,      6,      5222),
    (169,      10002880,   83457245, 7,      51),
    (170,      10001368,   3,        34,     44),
    (171,      10001334,   156,      883,    56),
    (172,      10002883,   247,      112,    568),
    (173,      10001389,   134613,   324,    1212),
    (174,      10001340,   1000,     34,     34),
    (175,      10002881,   2373,     6,      1),
    (176,      10002886,   45001,    25,     21),
    (455,      10002880,   13,       11111,  0),
    (456,      10000332,   0,        80001,  90),
    (457,      10001339,   123561,   2,      99);

SELECT name, vaultNum, galleon, sickle, knut
    FROM vaults v
    INNER JOIN wizards w
    ON v.wizard = w.id
    ORDER BY galleon DESC;
