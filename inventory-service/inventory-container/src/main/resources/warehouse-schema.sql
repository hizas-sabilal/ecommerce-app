DROP SCHEMA IF EXISTS warehouse CASCADE;

CREATE SCHEMA warehouse;

CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

DROP TABLE IF EXISTS warehouse.warehouses CASCADE;

CREATE TABLE warehouse.warehouses
(
    id uuid NOT NULL,
    name character varying COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT warehouses_pkey PRIMARY KEY (id)
);