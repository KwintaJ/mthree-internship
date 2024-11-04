DROP DATABASE IF EXISTS Gringotts;
CREATE DATABASE Gringotts;
USE Gringotts;

DROP TABLE IF EXISTS wizards;
CREATE TABLE wizards(
    id INT NOT NULL,
    name VARCHAR(255),
    PRIMARY KEY(id)
);

DROP TABLE IF EXISTS vaults;
CREATE TABLE vaults(
    vaultNum INT NOT NULL,
    wizard INT,
    galleon INT NOT NULL,
    sickle INT NOT NULL,
    knut INT NOT NULL,
    PRIMARY KEY(vaultNum),
    FOREIGN KEY (wizard) REFERENCES wizards(id)
);

DROP TABLE IF EXISTS transactions;
CREATE TABLE transactions(
    transactionId INT NOT NULL,
    fromVault INT NOT NULL,
    toVault INT NOT NULL,
    PRIMARY KEY(transactionId)
);