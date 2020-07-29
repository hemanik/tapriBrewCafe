--liquibase formatted sql

--changeset hkatyal:1

CREATE TABLE IF NOT EXISTS staff
(
    staff_id                    VARCHAR(64)         NOT NULL,
    name                        VARCHAR(64),
    username                    VARCHAR(64)         NOT NULL,
    password                    VARCHAR(64)         NOT NULL,
    email                       VARCHAR(64),
    mob_no                      INT,
    dob                         TIMESTAMP,
    CONSTRAINT user_pkey PRIMARY KEY (staff_id)
);

CREATE TABLE IF NOT EXISTS item
(
    id                          VARCHAR(64)         NOT NULL,
    name                        VARCHAR(64)         NOT NULL,
    description                 VARCHAR(64),
    type                        VARCHAR(64)         NOT NULL,
    cost                        INT,
    CONSTRAINT item_pkey PRIMARY KEY (id)
);
