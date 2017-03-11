CREATE TABLE public.users
(
    id bigserial,
    name character varying(50),
    email character varying(100) NOT NULL,
    password character(32) NOT NULL,
    phone character varying(20),
    qq character varying(100),
    facebook character varying(100),
    twitter character varying(100),
    linkedin character varying(500),
    personal_url character varying(500),
    active bit NOT NULL,
    status integer NOT NULL,
    created_at timestamp with time zone NOT NULL,
    create_ip character varying(20),
    updated_at timestamp with time zone,
    update_ip character varying(20),
    last_login_at timestamp with time zone,
    PRIMARY KEY (id),
    CONSTRAINT email_unique UNIQUE (email)
)
WITH (
    OIDS = FALSE
);
ALTER TABLE public.users
    OWNER to venus;

CREATE TABLE public.categories
(
    id bigserial,
    code character varying(100) NOT NULL,
    name character varying(100) NOT NULL,
    parent_id bigint,
    "order" integer NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT cate_code_unique UNIQUE (code)
)
WITH (
    OIDS = FALSE
);

ALTER TABLE public.categories
    OWNER to venus;

CREATE TABLE public.regions
(
    id bigserial,
    name character varying(100) NOT NULL,
    cn_name character varying(100),
    abbreviation character varying(10),
    "order" integer NOT NULL,
    parent_id bigint,
    level character varying(20) NOT NULL,
    PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
);

ALTER TABLE public.regions
    OWNER to venus;

CREATE TABLE public.posts
(
    id bigserial,
    posted_at timestamp with time zone NOT NULL,
    user_id bigint NOT NULL,
    cate_id bigint NOT NULL,
    region_id bigint NOT NULL,
    address character varying(200) NOT NULL,
    zipcode character varying(10),
    title character varying(500) NOT NULL,
    description text NOT NULL,
    contact_person character varying(50) NOT NULL,
    contact_number character varying(20),
    contact_email character varying(100),
    contact_wechat character varying(100),
    contact_qq character varying(100),
    contact_facebook character varying(500),
    contact_twitter character varying(100),
    contact_linkedin character varying(500),
    website_url character varying(500),
    pictures character varying(1000),
    cate_aware_info text,
    status integer NOT NULL,
    PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
);

ALTER TABLE public.posts
    OWNER to venus;


ALTER TABLE public.categories
    ADD CONSTRAINT cate_parent FOREIGN KEY (parent_id)
    REFERENCES public.categories (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE CASCADE;
CREATE INDEX fki_cate_parent
    ON public.categories(parent_id);

ALTER TABLE public.regions
    ADD CONSTRAINT region_parent FOREIGN KEY (parent_id)
    REFERENCES public.regions (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE CASCADE;
CREATE INDEX fki_region_parent
    ON public.regions(parent_id);

ALTER TABLE public.posts
    ADD CONSTRAINT post_user_id_idx FOREIGN KEY (user_id)
    REFERENCES public.users (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;
CREATE INDEX fki_post_user_id_idx
    ON public.posts(user_id);

ALTER TABLE public.posts
    ADD CONSTRAINT post_cate_id FOREIGN KEY (cate_id)
    REFERENCES public.categories (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;
CREATE INDEX fki_post_cate_id
    ON public.posts(cate_id);

ALTER TABLE public.posts
    ADD CONSTRAINT post_region_id FOREIGN KEY (region_id)
    REFERENCES public.regions (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;
CREATE INDEX fki_post_region_id
    ON public.posts(region_id);
