--liquibase formatted sql
--changeset 001:1
CREATE TABLE IF NOT EXISTS CUSTOMER_OCCURRENCE (
  ID NUMERIC(18) NOT NULL,
  CODE NUMERIC(18) NOT NULL,
  COMMENT VARCHAR(2000) NOT NULL,
  PRIMARY KEY (ID)
);

--changeset 001:2
CREATE SEQUENCE IF NOT EXISTS CUSTOMER_OCCURRENCE_SEQ INCREMENT BY 1 OWNED BY CUSTOMER_OCCURRENCE.ID
