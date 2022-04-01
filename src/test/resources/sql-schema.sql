DROP TABLE IF EXISTS `customers`;
DROP TABLE IF EXISTS `items`;

CREATE TABLE IF NOT EXISTS `customers` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(40) DEFAULT NULL,
    `surname` VARCHAR(40) DEFAULT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `items` (
	`id` BIGINT AUTO_INCREMENT,
	`item_name` VARCHAR(40) NOT NULL,
	`item_category` VARCHAR(40) NOT NULL,
	`price` DECIMAL(6,2) NOT NULL,
	PRIMARY KEY (`id`)
);