CREATE TABLE public.video_entity
(
    id                   bigint       NOT NULL,
    title                varchar(255) NOT NULL,
    author               varchar(255) NOT NULL,
    description          varchar(255) NULL,
    likes                bigint       NULL,
    duration_in_seconds  int          NOT NULL,
    creation_date        timestamp    NULL,
    PRIMARY KEY (id)
);

CREATE SEQUENCE public.video_id_seq START 1 INCREMENT 50;
