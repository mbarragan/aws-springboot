-- Table: public.T_USER

-- DROP TABLE public."T_USER";

CREATE TABLE public."T_USER"
(
    id bigint NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    username text COLLATE pg_catalog."default",
    password text COLLATE pg_catalog."default",
    CONSTRAINT "User_pkey" PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE public."T_USER"
    OWNER to postgres;

COMMENT ON TABLE public."T_USER"
    IS 'Users table';


-- -- SAMPLE DATA
insert into "T_USER" (password, username) values ('123', 'manu');