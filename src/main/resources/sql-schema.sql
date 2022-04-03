DROP SCHEMA ims;

CREATE SCHEMA IF NOT EXISTS ims;

SHOW TABLES;

DROP TABLE  orders_items;
DROP TABLE  orders;
DROP TABLE  items;
DROP TABLE  customers;

CREATE TABLE IF NOT EXISTS customers (
id INT(11) NOT NULL AUTO_INCREMENT,
first_name VARCHAR(64) DEFAULT NULL,
surname VARCHAR(64) DEFAULT NULL,
PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS items (
id INT(11) NOT NULL AUTO_INCREMENT,
item_name VARCHAR(64) NOT NULL,
item_category VARCHAR(64) NOT NULL,
price DECIMAL(6,2) NOT NULL,
PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS orders (
id BIGINT NOT NULL AUTO_INCREMENT,
fk_customers_id BIGINT NOT NULL,
total_price DECIMAL(6,2) NOT NULL,
PRIMARY KEY (id),
FOREIGN KEY (fk_customers_id) REFERENCES customers(id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS orders_items (
fk_orders_id BIGINT NOT NULL,
fk_items_id BIGINT NOT NULL,
PRIMARY KEY (fk_orders_id, fk_items_id),
FOREIGN KEY (fk_orders_id) REFERENCES orders(id) ON DELETE CASCADE,
FOREIGN KEY (fk_items_id) REFERENCES items(id) ON DELETE CASCADE
);