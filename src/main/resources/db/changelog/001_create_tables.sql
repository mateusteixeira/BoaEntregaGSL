--liquibase formatted sql
--changeset 001:1
CREATE TABLE IF NOT EXISTS CUSTOMER_OCCURRENCE (
  ID NUMERIC(18) NOT NULL,
  CODE NUMERIC(18) NOT NULL,
  COMMENT VARCHAR(2000) NOT NULL,
  PRIMARY KEY (ID)
);

--changeset 001:2
CREATE TABLE IF NOT EXISTS MERCHANDISE (
  ID NUMERIC(18) NOT NULL,
  CODE NUMERIC(18) NOT NULL,
  NAME VARCHAR(2000) NOT NULL,
  EAN VARCHAR(20) NOT NULL,
  PRIMARY KEY (ID)
);

--changeset 001:3
CREATE TABLE IF NOT EXISTS ROUTE (
  ID NUMERIC(18) NOT NULL,
  CODE NUMERIC(18) NOT NULL,
  NAME VARCHAR(2000) NOT NULL,
  CITY_FROM VARCHAR(256) NOT NULL,
  CITY_TO VARCHAR(256) NOT NULL,
  DURATION_IN_DAYS NUMERIC(6),
  PRIMARY KEY (ID)
);

--changeset 001:4
CREATE TABLE IF NOT EXISTS "USER" (
  ID NUMERIC(18) NOT NULL,
  LOGIN VARCHAR(256) NOT NULL,
  FIRST_NAME VARCHAR(256) NOT NULL,
  LAST_NAME VARCHAR(256) NOT NULL,
  EMAIL VARCHAR(256) NOT NULL,
  ACTIVE boolean NOT NULL,
  PRIMARY KEY (ID)
);

--changeset 001:5
CREATE TABLE IF NOT EXISTS USER_PROFILE (
  ID NUMERIC(18) NOT NULL,
  PROFILE VARCHAR(256) NOT NULL,
  ID_USER NUMERIC(18) NOT NULL,
  PRIMARY KEY (ID),
  FOREIGN KEY (ID_USER) REFERENCES "USER" (ID)
);

--changeset 001:6
CREATE TABLE IF NOT EXISTS WARE_HOUSE (
  ID NUMERIC(18) NOT NULL,
  CODE NUMERIC (6) NOT NULL,
  NAME VARCHAR(256) NOT NULL,
  CAPACITY NUMERIC(6) NOT NULL,
  LOCATION VARCHAR(256) NOT NULL,
  PRIMARY KEY (ID)
);

--changeset 001:7
CREATE SEQUENCE IF NOT EXISTS CUSTOMER_OCCURRENCE_SEQ INCREMENT BY 1 OWNED BY CUSTOMER_OCCURRENCE.ID

--changeset 001:8
CREATE SEQUENCE IF NOT EXISTS MERCHANDISE_SEQ INCREMENT BY 1 OWNED BY MERCHANDISE.ID

--changeset 001:9
CREATE SEQUENCE IF NOT EXISTS ROUTE_SEQ INCREMENT BY 1 OWNED BY ROUTE.ID

--changeset 001:10
CREATE SEQUENCE IF NOT EXISTS USER_SEQ INCREMENT BY 1 OWNED BY "USER".ID

--changeset 001:11
CREATE SEQUENCE IF NOT EXISTS USER_PROFILE_SEQ INCREMENT BY 1 OWNED BY USER_PROFILE.ID

--changeset 001:12
CREATE SEQUENCE IF NOT EXISTS WARE_HOUSE_SEQ INCREMENT BY 1 OWNED BY WARE_HOUSE.ID
