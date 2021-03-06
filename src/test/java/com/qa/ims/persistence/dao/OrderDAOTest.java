package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.DBUtils;

public class OrderDAOTest {

	private final OrderDAO DAO = new OrderDAO(new CustomerDAO(), new ItemDAO());
	private Order testOrder;
	private Item testItem;

	@Before
	public void setup() {
		DBUtils.connect();
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
		List<Item> listOfItems = new ArrayList<>();
		testItem = new Item(1L, "Rubber", "Stationaries", 2.99F);
		listOfItems.add(testItem);
		Customer customer = new Customer(1L, "Michael", "Jackson");
		testOrder = new Order(1L, customer, 2.99D, listOfItems);
	}

	@Test
	public void readTEST() {
		assertEquals(testOrder, DAO.read(1L));
	}

	@Test
	public void readLatestTEST() {
		assertEquals(testOrder, DAO.readLatest());
	}

	@Test
	public void readAllTEST() {
		List<Order> expected = new ArrayList<>();
		expected.add(testOrder);
		assertEquals(expected, DAO.readAll());
	}

	@Test
	public void createTest() {
		final Customer customer = new Customer(1L, "jordan", "harrison");
		final List<Item> listOfItems = new ArrayList<>();
		final Order newOrder = new Order(1L, customer, 2.99D, listOfItems);

		assertEquals(newOrder, DAO.create(newOrder));
	}

	@Test
	public void createNullTEST() {
		assertEquals(null, DAO.create(null));
	}

	@Test
	public void addToOrder_NewUpdateTEST() {
		testOrder.getOrdersItems().add(testItem);

		assertEquals(testOrder, DAO.addToOrder_NewUpdate(testOrder.getId(), testItem.getId()));
	}

	@Test
	public void addToOrder_NewUpdateNullTest() {
		testOrder.getOrdersItems().add(null);

		assertEquals(null, DAO.read(null));
	}

	@Test
	public void removeFromOrder_NewUpdateTEST() {
		testOrder.getOrdersItems().remove(testItem);

		assertEquals(testOrder, DAO.removeFromOrder_NewUpdate(testOrder.getId(), testItem.getId()));
	}

	@Test
	public void removeFromOrder_NewUpdateNullTEST() {
		testOrder.getOrdersItems().add(null);

		assertEquals(null, DAO.read(null));
	}

	@Test
	public void deleteTEST() {
		assertEquals(0, DAO.deleteOrdersItems(1L));
		assertEquals(0, DAO.delete(1L));
	}
}
