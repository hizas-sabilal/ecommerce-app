DROP SCHEMA IF EXISTS "inventory" CASCADE;

CREATE SCHEMA "inventory";

CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

DROP TABLE IF EXISTS "inventory".inventories CASCADE;

CREATE TABLE "inventory".inventories
(
    id uuid NOT NULL,
    warehouse_id uuid NOT NULL,
    sku_id uuid NOT NULL,
    quantity integer NOT NULL,
    reserved integer NOT NULL,
    failure_messages character varying COLLATE pg_catalog."default",
    CONSTRAINT inventories_pkey PRIMARY KEY (id)
);

DROP TABLE IF EXISTS "inventory".warehouses CASCADE;

CREATE TABLE "inventory".warehouses
(
    id uuid NOT NULL,
    name character varying COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT warehouses_pkey PRIMARY KEY (id)
);

DROP TABLE IF EXISTS "inventory".skus CASCADE;

CREATE TABLE "inventory".skus
(
    id uuid NOT NULL,
    name character varying COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT skus_pkey PRIMARY KEY (id)
);