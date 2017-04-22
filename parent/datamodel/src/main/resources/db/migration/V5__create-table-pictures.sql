CREATE TABLE public.pictures
(
   id bigserial, 
   user_id bigint NOT NULL, 
   post_id bigint, 
   pic_status integer NOT NULL, 
   created_at timestamp with time zone NOT NULL, 
   original_file_name character varying(500), 
   original_file_ext character varying(10) NOT NULL, 
   original_dim_width integer NOT NULL, 
   original_dim_height integer NOT NULL, 
   CONSTRAINT pk_pictures_id PRIMARY KEY (id), 
   CONSTRAINT fk_pictures_user_id FOREIGN KEY (user_id) REFERENCES public.users (id) ON UPDATE NO ACTION ON DELETE CASCADE, 
   CONSTRAINT fk_pictures_post_id FOREIGN KEY (post_id) REFERENCES public.posts (id) ON UPDATE NO ACTION ON DELETE CASCADE
) 
WITH (
  OIDS = FALSE
)
;
ALTER TABLE public.pictures
  OWNER TO venus;
