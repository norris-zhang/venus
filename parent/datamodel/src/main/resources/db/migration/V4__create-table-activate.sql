CREATE TABLE public.activate
(
    id bigserial,
    user_id bigint NOT NULL,
    activate_code character(8) NOT NULL,
    created_at timestamp with time zone NOT NULL,
    activated_at timestamp with time zone,
    PRIMARY KEY (id),
    CONSTRAINT unique_activate_user_id UNIQUE (user_id),
    CONSTRAINT fk_activate_user_id FOREIGN KEY (user_id)
        REFERENCES public.users (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE CASCADE
)
WITH (
    OIDS = FALSE
);

ALTER TABLE public.activate
    OWNER to venus;