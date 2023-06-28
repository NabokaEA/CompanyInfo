--liquibase formatted sql

--changeset enaboka:1
CREATE TABLE IF NOT EXISTS company
(
    id SERIAL PRIMARY KEY,
    full_name VARCHAR(64) NOT NULL UNIQUE,
    short_name VARCHAR(32) NOT NULL UNIQUE,
    inn INT NOT NULL UNIQUE,
    ogrn INT NOT NULL UNIQUE,
    post_address VARCHAR(256) NOT NULL,
    legal_address VARCHAR(256) NOT NULL
);
--rollback DROP TABLE company;

--changeset enaboka:2
CREATE TABLE IF NOT EXISTS company_seo
(
    id SERIAL PRIMARY KEY ,
    seo_lastname VARCHAR(64) NOT NULL,
    seo_patronymicname VARCHAR(64) NOT NULL,
    seo_firstname VARCHAR(64) NOT NULL,
    seo_birth_date DATE NOT NULL,
    company_id INT REFERENCES company (id)
    );
--rollback DROP TABLE general_manager;

--changeset enaboka:3
CREATE TABLE IF NOT EXISTS company_branch
(
    id SERIAL PRIMARY KEY,
    full_name VARCHAR(64) NOT NULL UNIQUE,
    short_name VARCHAR(32) NOT NULL UNIQUE,
    post_address VARCHAR(256) NOT NULL,
    company_id INT REFERENCES company (id)
    );
--rollback DROP TABLE general_manager;