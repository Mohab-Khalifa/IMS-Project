Coverage: 60.7%
# Fundmental Project: Inventory Management System

This is an inventory management system (IMS) for an end user to interact with via a Command-Line Interface (CLI). This inventory management system allows for CRUD (Create, Read, Update, Delete) functionality for customers, items and orders in a database. 

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

For you to get the application running, you will need

```
- Java Version 11 or higher
- MySQL Version 8 or higher
- Git
- Maven
```

### Installing - How to Run the jar

Firstly, you will need to install everything that is mentioned above.

 - You must cd to the location of the jar file
 - Create a db.properties file in the same folder as the jar
 - The contents of the db.properties file will be as below:

```
# configured MySQL database
db.url=jdbc:mysql://localhost:3306/<your_db>
db.user=<username>
db.password=<password>

```
- You can execute the jar through the command line interface by running the following command:
``` 
'java -jar ims-0.0.1-jar-with-dependencies.jar'
```

## Running the tests

To run the tests on your system, you must fork this clone onto your own github repo. Then you must clone the repo into you local git repo.
To clone the repo you must use the following command in your local git bash:
```
git clone https://github.com/Mohab-Khalifa/IMS-Project.git
```

### Unit Tests 

In computer programming, unit testing is a software testing method by which individual units of source code are tested to determine whether they are fit for use. Furthermore, I isolated small pieces of code to logically test each individual function.

For instance, here is my unit tests for my item class:

```
@Test
	public void toStringTEST() {
		Item item = new Item(1L, "PS5", "Gaming", 449.99F);
		String expected = "Item [id=1, itemName=PS5, itemCategory=Gaming, price=449.99]";
		assertEquals(expected, item.toString());
	}

	@Test
	public void firstConstructorTEST() {
		Item item = new Item("PS5", "Gaming", 449.99F);
		assertEquals("PS5", item.getItemName());
		assertEquals("Gaming", item.getItemCategory());
		assertEquals(449.99, item.getPrice(), 0.02);
	}

	@Test
	public void secondConstructorTEST() {
		Item item = new Item(1L, "XBOX", "Gaming", 449.99F);
		assertEquals(Long.valueOf("1"), item.getId());
		assertEquals("XBOX", item.getItemName());
		assertEquals("Gaming", item.getItemCategory());
		assertEquals(449.99, item.getPrice(), 0.02);

	}

	@Test
	public void equalsTEST() {
		EqualsVerifier.simple().forClass(Item.class).verify();
	}

	@Test
	public void setIdTEST() {
		Item item = new Item(1L, "XBOX", "Gaming", 449.99F);
		item.setId(2L);
		assertEquals(Long.valueOf("2"), item.getId());

	}

	@Test
	public void setItemNameTEST() {
		Item item = new Item(1L, "XBOX", "Gaming", 449.99F);
		item.setItemName("NINTENDO SWITCH");
		assertEquals("NINTENDO SWITCH", item.getItemName());
	}

	@Test
	public void setItemCategoryTEST() {
		Item item = new Item(1L, "XBOX", "Gaming", 449.99F);
		item.setItemCategory("Toys");
		assertEquals("Toys", item.getItemCategory());
	}

	@Test
	public void setPriceTEST() {
		Item item = new Item(1L, "XBOX", "Gaming", 449.99F);
		item.setPrice(5000);
		assertEquals(5000, item.getPrice(), 0.02);

	}
```

### Integration Tests 
Integration testing is the phase in software testing in which individual software modules are combined and tested as a group. This is to see how the classes interact with one another. Intergration testing is conducted to evaluate the compliance of a system or component with specified functional requirements. This occurs after unit testing and before system testing.

Here is an example of how my integration tests look for my item classes:

```
@Mock
	private Utils utils;

	@Mock
	private ItemDAO dao;

	@InjectMocks
	private ItemController controller;

	@Test
	public void testCreate() {
		final String I_NAME = "PS5", I_CATEGORY = "Gaming";
		final Float PRICE = 449.99f;
		final Item created = new Item(I_NAME, I_CATEGORY, PRICE);

		Mockito.when(utils.getString()).thenReturn(I_NAME, I_CATEGORY);
		Mockito.when(utils.getFloat()).thenReturn(PRICE);
		Mockito.when(dao.create(created)).thenReturn(created);

		assertEquals(created, controller.create());

		Mockito.verify(utils, Mockito.times(2)).getString();
		Mockito.verify(utils, Mockito.times(1)).getFloat();
		Mockito.verify(dao, Mockito.times(1)).create(created);
	}

	@Test
	public void testReadAll() {
		List<Item> items = new ArrayList<>();
		items.add(new Item(1L, "XBOX ONE", "Gaming", 449.99f));

		Mockito.when(dao.readAll()).thenReturn(items);

		assertEquals(items, controller.readAll());

		Mockito.verify(dao, Mockito.times(1)).readAll();
	}

	@Test
	public void testUpdate() {
		Item updated = new Item(1L, "NINTENDO SWITCH", "Gaming", 299.99f);

		Mockito.when(this.utils.getLong()).thenReturn(1L);
		Mockito.when(this.utils.getString()).thenReturn(updated.getItemName(), updated.getItemCategory());
		Mockito.when(this.utils.getFloat()).thenReturn(updated.getPrice());
		Mockito.when(this.dao.update(updated)).thenReturn(updated);

		assertEquals(updated, this.controller.update());

		Mockito.verify(this.utils, Mockito.times(1)).getLong();
		Mockito.verify(this.utils, Mockito.times(2)).getString();
		Mockito.verify(this.utils, Mockito.times(1)).getFloat();
		Mockito.verify(this.dao, Mockito.times(1)).update(updated);
	}

	@Test
	public void testDelete() {
		final long ID = 1L;

		Mockito.when(utils.getLong()).thenReturn(ID);
		Mockito.when(dao.delete(ID)).thenReturn(1);

		assertEquals(1L, this.controller.delete());

		Mockito.verify(utils, Mockito.times(1)).getLong();
		Mockito.verify(dao, Mockito.times(1)).delete(ID);
	}
```

## Deployment

In order to deploy this project, you must connect it to a db. In this case, I would recommend connecting to a MySQL database. You will need to use your personal login information as I have already shown above in the 'Installing' subheading. when looged into your MySQL, to set up your database on MySQL, you must run the following:
```
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
```
This will build all your required tables to run the application.

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Versioning

We use [SemVer](http://semver.org/) for versioning.

## Authors

* **Chris Perrins** - *Initial work* - [christophperrins](https://github.com/christophperrins)
* **Mohab Khalifa**

## License

This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details 

*For help in [Choosing a license](https://choosealicense.com/)*

## Acknowledgments

* Hat tip to anyone whose code was used
* Inspiration
* etc
