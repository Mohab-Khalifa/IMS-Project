INSERT INTO `customers` (`first_name`, `surname`) VALUES ('Mohab', 'Khalifa');
INSERT INTO `items` (`item_name`, `item_category`, `price`) VALUES ('PS5', 'Gaming', '449.99');
INSERT INTO `orders` (`id`, `fk_customers_id`, `total_price`) VALUES (1L, 1L, 9.99D);