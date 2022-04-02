DROP SCHEMA ims;

CREATE SCHEMA IF NOT EXISTS `ims`;

USE `ims` ;

SHOW TABLES;

DROP TABLE IF EXISTS orders_items;
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS items;
DROP TABLE IF EXISTS customers;

CREATE TABLE IF NOT EXISTS `customers` (
    `id` BIGINT AUTO_INCREMENT,
    `first_name` VARCHAR(40) NOT NULL,
    `surname` VARCHAR(40) NOT NULL,
    PRIMARY KEY (`id`)
);

INSERT INTO `customers` (`first_name`, `surname`) VALUES ('Harry', 'Maguire');
INSERT INTO `customers` (`first_name`, `surname`) VALUES ('Terrence', 'Crawford');
INSERT INTO `customers` (`first_name`, `surname`) VALUES ('Tyler', 'Perry');

SELECT * FROM customers;

CREATE TABLE IF NOT EXISTS `items` (
	`id` BIGINT AUTO_INCREMENT,
	`item_name` VARCHAR(40) NOT NULL,
	`item_category` VARCHAR(40) NOT NULL,
	`price` DECIMAL(6,2) NOT NULL,
	PRIMARY KEY (`id`)
);

INSERT INTO `items` (`item_name`, `item_category`, `price`) VALUES ('PS5', 'Gaming', '500');
INSERT INTO `items` (`item_name`, `item_category`, `price`) VALUES ('Pencil', 'Stationary', '1');
INSERT INTO `items` (`item_name`, `item_category`, `price`) VALUES ('Scooter', 'Toys', '19.99');

SELECT * FROM items;

CREATE TABLE IF NOT EXISTS `orders` (
	`id` BIGINT AUTO_INCREMENT,
	`fk_customers_id` BIGINT NOT NULL,
	`total_price` DECIMAL(6,2) NOT NULL,
	PRIMARY KEY (`id`),
	FOREIGN KEY (`fk_customers_id`) REFERENCES customers(`id`)
);

INSERT INTO `orders` (`fk_customers_id`, `total_price`) VALUES ('1', '200');
INSERT INTO `orders` (`fk_customers_id`, `total_price`) VALUES ('2', '34.99');
INSERT INTO `orders` (`fk_customers_id`, `total_price`) VALUES ('3', '5');

SELECT * FROM orders;

CREATE TABLE IF NOT EXISTS `orders_items` (
	`fk_orders_id` BIGINT NOT NULL,
	`fk_items_id` BIGINT NOT NULL,
	`quantity` INT DEFAULT 1,
	PRIMARY KEY (`fk_orders_id`, `fk_items_id`),
	FOREIGN KEY (`fk_orders_id`) REFERENCES orders(`id`),
	FOREIGN KEY (`fk_items_id`) REFERENCES items(`id`)
);

INSERT INTO `orders_items` (`fk_orders_id`, `fk_items_id`) VALUES ('1', '1');

SELECT * FROM orders_items;


SELECT `orders`.`id`, `customers`.`first_name`, `customers`.`surname`, `orders_items`.`fk_items_id`, `items`.`item_name`
FROM `orders` JOIN `customers` ON `orders`.`fk_customers_id`=`customers`.`id` 
JOIN `orders_items` ON `orders`.`id` = `orders_items`.`fk_orders_id`
JOIN `items` ON `items`.`id` = `orders_items`.`fk_items_id` WHERE `orders`.`id` = '1'