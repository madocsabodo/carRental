-- Table: public.address
-- DROP TABLE IF EXISTS public.address;
CREATE TABLE IF NOT EXISTS public.address
(
    id bigint NOT NULL,
    city character varying(255) COLLATE pg_catalog."default",
    street character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT address_pkey PRIMARY KEY (id)
)

-- Table: public.car
-- DROP TABLE IF EXISTS public.car;
CREATE TABLE IF NOT EXISTS public.car
(
    id bigint NOT NULL,
    body_type integer,
    color integer,
    daily_rate integer,
    fuel_type integer,
    gear_type integer,
    nr_of_seats integer,
    hourly_rate integer,
    hp_power integer,
    make character varying(255) COLLATE pg_catalog."default",
    model character varying(255) COLLATE pg_catalog."default",
    nr_of_doors integer,
    registration_date date,
    CONSTRAINT car_pkey PRIMARY KEY (id)
)

-- Table: public.client
-- DROP TABLE IF EXISTS public.client;

CREATE TABLE IF NOT EXISTS public.client
(
    id bigint NOT NULL,
    name text COLLATE pg_catalog."default",
    insurance_number text COLLATE pg_catalog."default",
    date_of_birth date,
    loyalty_points integer,
    address_id bigint,
    CONSTRAINT client_pkey PRIMARY KEY (id),
    CONSTRAINT fkb137u2cl2ec0otae32lk5pcl2 FOREIGN KEY (address_id)
        REFERENCES public.address (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)


-- Table: public.rental
-- DROP TABLE IF EXISTS public.rental;

CREATE TABLE IF NOT EXISTS public.rental
(
    id integer NOT NULL,
    car_id bigint,
    client_id bigint,
    rental_start_date date,
    rented_hours integer,
    was_returned boolean,
    CONSTRAINT rental_pkey PRIMARY KEY (id),
    CONSTRAINT fkfurpp295i3dhumquorur054dw FOREIGN KEY (client_id)
        REFERENCES public.client (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

