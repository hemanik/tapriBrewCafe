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
