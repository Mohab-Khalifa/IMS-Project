DROP SCHEMA ims;

CREATE SCHEMA IF NOT EXISTS `ims`;

USE `ims` ;

CREATE TABLE IF NOT EXISTS `ims`.`customers` (
    `id` BIGINT AUTO_INCREMENT,
    `first_name` VARCHAR(40) NOT NULL,
    `surname` VARCHAR(40) NOT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `ims`.`items` (
	`id` BIGINT AUTO_INCREMENT,
	`item_name` VARCHAR(40) NOT NULL,
	`item_category` VARCHAR(40) NOT NULL,
	`price` DECIMAL(6,2) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `ims`.`orders` (
	`id` BIGINT AUTO_INCREMENT,
	`fk_customers_id` INT NOT NULL,
	`total_price` DECIMAL(6,2) NOT NULL,
	`date_placed` DATE,
	PRIMARY KEY (`id`),
	FOREIGN KEY (`fk_customers_id`) REFERENCES customers(`id`)
);

CREATE TABLE IF NOT EXISTS `ims`.`orders_items` (
	`fk_orders_id` INT NOT NULL,
	`fk_items_id` INT NOT NULL,
	`quantity` INT DEFAULT 1,
	PRIMARY KEY (`fk_orders_id`, `fk_items_id`),
	FOREIGN KEY (`fk_orders_id`) REFERENCES orders(`id`),
	FOREIGN KEY (`fk_items_id`) REFERENCES items(`id`)
);