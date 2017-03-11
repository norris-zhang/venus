-- CREATE SCHEMA `venusdb` DEFAULT CHARACTER SET utf8 ;

CREATE TABLE `venusdb`.`users` (
  `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '',
  `name` VARCHAR(50) NULL COMMENT '',
  `email` VARCHAR(100) NOT NULL COMMENT '',
  `password` VARCHAR(32) NOT NULL COMMENT '',
  `phone` VARCHAR(20) NULL COMMENT '',
  `qq` VARCHAR(100) NULL COMMENT '',
  `facebook` VARCHAR(100) NULL COMMENT '',
  `twitter` VARCHAR(100) NULL COMMENT '',
  `linkedin` VARCHAR(500) NULL COMMENT '',
  `personal_url` VARCHAR(500) NULL COMMENT '',
  `active` BIT NOT NULL DEFAULT 0 COMMENT '',
  `status` INT NOT NULL DEFAULT 0 COMMENT '',
  `created_at` TIMESTAMP NOT NULL COMMENT '',
  `create_ip` VARCHAR(20) NULL COMMENT '',
  `updated_at` DATETIME NULL COMMENT '',
  `update_ip` VARCHAR(20) NULL COMMENT '',
  `last_login_at` DATETIME NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '',
  UNIQUE INDEX `email_UNIQUE` (`email` ASC)  COMMENT '');

CREATE TABLE `venusdb`.`categories` (
  `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '',
  `code` VARCHAR(100) NOT NULL COMMENT '',
  `name` VARCHAR(100) NOT NULL COMMENT '',
  `parent_id` BIGINT NULL COMMENT '',
  `order` INT NOT NULL DEFAULT 0 COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '',
  UNIQUE INDEX `code_UNIQUE` (`code` ASC)  COMMENT '');

CREATE TABLE `venusdb`.`regions` (
  `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '',
  `name` VARCHAR(100) NOT NULL COMMENT '',
  `cn_name` VARCHAR(100) NULL COMMENT '',
  `abbreviation` VARCHAR(10) NULL COMMENT '',
  `order` INT NOT NULL DEFAULT 0 COMMENT '',
  `parent_id` BIGINT NULL COMMENT '',
  `level` VARCHAR(20) NOT NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '');

CREATE TABLE `venusdb`.`posts` (
  `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '',
  `posted_at` TIMESTAMP NOT NULL COMMENT '',
  `user_id` BIGINT NOT NULL COMMENT '',
  `cate_id` BIGINT NOT NULL COMMENT '',
  `region_id` BIGINT NOT NULL COMMENT '',
  `address` VARCHAR(200) NOT NULL COMMENT '',
  `zipcode` VARCHAR(10) NULL COMMENT '',
  `title` VARCHAR(500) NOT NULL COMMENT '',
  `description` TEXT NOT NULL COMMENT '',
  `contact_person` VARCHAR(50) NOT NULL COMMENT '',
  `contact_number` VARCHAR(20) NULL COMMENT '',
  `contact_email` VARCHAR(100) NULL COMMENT '',
  `contact_wechat` VARCHAR(100) NULL COMMENT '',
  `contact_qq` VARCHAR(100) NULL COMMENT '',
  `contact_facebook` VARCHAR(500) NULL COMMENT '',
  `contact_twitter` VARCHAR(100) NULL COMMENT '',
  `contact_linkedin` VARCHAR(500) NULL COMMENT '',
  `website_url` VARCHAR(500) NULL COMMENT '',
  `pictures` VARCHAR(1000) NULL COMMENT '',
  `cate_aware_info` TEXT NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '');







ALTER TABLE `venusdb`.`categories` 
ADD INDEX `cate_parent_idx` (`parent_id` ASC)  COMMENT '';
ALTER TABLE `venusdb`.`categories` 
ADD CONSTRAINT `cate_parent`
  FOREIGN KEY (`parent_id`)
  REFERENCES `venusdb`.`categories` (`id`)
  ON DELETE CASCADE
  ON UPDATE NO ACTION;

ALTER TABLE `venusdb`.`regions` 
ADD INDEX `region_parent_idx` (`parent_id` ASC)  COMMENT '';
ALTER TABLE `venusdb`.`regions` 
ADD CONSTRAINT `region_parent`
  FOREIGN KEY (`parent_id`)
  REFERENCES `venusdb`.`regions` (`id`)
  ON DELETE CASCADE
  ON UPDATE NO ACTION;

ALTER TABLE `venusdb`.`posts` 
ADD INDEX `post_user_id_idx` (`user_id` ASC)  COMMENT '',
ADD INDEX `post_cate_id_idx` (`cate_id` ASC)  COMMENT '',
ADD INDEX `post_region_id_idx` (`region_id` ASC)  COMMENT '';
ALTER TABLE `venusdb`.`posts` 
ADD CONSTRAINT `post_user_id`
  FOREIGN KEY (`user_id`)
  REFERENCES `venusdb`.`users` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `post_cate_id`
  FOREIGN KEY (`cate_id`)
  REFERENCES `venusdb`.`categories` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `post_region_id`
  FOREIGN KEY (`region_id`)
  REFERENCES `venusdb`.`regions` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;






