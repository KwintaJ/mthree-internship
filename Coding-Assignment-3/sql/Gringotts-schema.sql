DROP DATABASE IF EXISTS Gringotts;
CREATE DATABASE Gringotts;
USE Gringotts;

DROP TABLE IF EXISTS wizard;
CREATE TABLE wizard(
    id INT NOT NULL,
    name VARCHAR(255),
    password VARCHAR(255),
    PRIMARY KEY(id)
);

DROP TABLE IF EXISTS vault;
CREATE TABLE vault(
    vault_num INT NOT NULL,
    wizard INT NOT NULL,
    galleon INT NOT NULL,
    sickle INT NOT NULL,
    knut INT NOT NULL,
    PRIMARY KEY(vault_num),
    FOREIGN KEY (wizard) REFERENCES wizard(id)
);

DROP TABLE IF EXISTS transaction;
CREATE TABLE transaction(
    transaction_id INT NOT NULL,
    from_vault INT NOT NULL,
    to_vault INT NOT NULL,
    knuts INT NOT NULL,
    transaction_time DATETIME(6),
    PRIMARY KEY(transaction_id)
);

DROP TABLE IF EXISTS wizard_seq;
CREATE TABLE wizard_seq(
    next_val BIGINT
);

DROP TABLE IF EXISTS vault_seq;
CREATE TABLE vault_seq(
    next_val BIGINT
);

DROP TABLE IF EXISTS transaction_seq;
CREATE TABLE transaction_seq(
    next_val BIGINT
);