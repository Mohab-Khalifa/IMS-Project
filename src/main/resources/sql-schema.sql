drop schema ims;

CREATE SCHEMA IF NOT EXISTS `ims`;

USE `ims` ;

CREATE TABLE IF NOT EXISTS `ims`.`customers` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(40) NOT NULL,
    `surname` VARCHAR(40) NOT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `ims`.`items` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`item_name` VARCHAR(40) NOT NULL,
	`item_category` VARCHAR(40) NOT NULL,
	`price` DECIMAL(6,2) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `ims`.`orders` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`fk_customers_id` INT NOT NULL,
	`total_price` DECIMAL(6,2) NOT NULL,
	`date_placed` DATE,
	PRIMARY KEY (`id`),
	FOREIGN KEY (`fk_customers_id`) REFERENCES customers(`id`)
);

CREATE TABLE IF NOT EXISTS `ims`.`orders_items` (
	`fk_orders_id` INT NOT NULL,
	`fk_items_id` INT NOT NULL,
	FOREIGN KEY (`fk_orders_id`) REFERENCES orders(`id`),
	FOREIGN KEY (`fk_items_id`) REFERENCES items(`id`)
);