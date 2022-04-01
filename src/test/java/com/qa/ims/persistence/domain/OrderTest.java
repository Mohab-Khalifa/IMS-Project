package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

public class OrderTest {

	@Test
	public void firstConstructorTest() {
		Customer customer = new Customer("John", "Doe");
		Order order = new Order(customer);

		assertEquals(customer, order.getFkCustomerId());
	}

	@Test
	public void secondConstructorTest() {
		Customer customer = new Customer("John", "Doe");
		Order order = new Order(3L, customer);

		assertEquals(Long.valueOf(3), order.getId());
		assertEquals(customer, order.getFkCustomerId());
	}

	@Test
	public void thirdConstructorTest() {
		Order order = new Order();

		assertNotNull(order);
	}

	@Test
	public void fourthConstructorTest() {
		Customer customer = new Customer("Barry", "Allen");
		Item Scooter = new Item("Scooter", "Toys", 19.99F);
		Item Notebook = new Item(3L, "Notebook", "Stationaries", 1.50F);
		List<Item> listOfItems = new ArrayList<>();
		listOfItems.add(Scooter);
		listOfItems.add(Notebook);
		String datePlaced = "2022/02/01";
		double totalPrice = Scooter.getPrice() + Notebook.getPrice();
		Order order = new Order(3L, customer, totalPrice, datePlaced, listOfItems);

		assertEquals(Long.valueOf(3), order.getId());
		assertEquals(totalPrice, order.getTotalPrice(), 0.01);
		assertEquals(listOfItems, order.getOrdersItems());
		assertEquals(customer, order.getFkCustomerId());
//		assertEquals(datePlaced, order.getDatePlaced());
	}

	@Test
	public void fifthConstructorTest() {
		Customer customer = new Customer("Mesut", "Ozil");
		Item Axe = new Item("Axe", "Gardening", 9.99F);
		Item Wood = new Item(3L, "Axe", "Gardening", 9.99F);
		List<Item> listOfItems = new ArrayList<>();
		listOfItems.add(Axe);
		listOfItems.add(Wood);
		String datePlaced = "2022/02/01";
		double totalPrice = Axe.getPrice() + Wood.getPrice();
		Order order = new Order(3L, customer, listOfItems, totalPrice, datePlaced);

		assertEquals(Long.valueOf(3), order.getId());
		assertEquals(totalPrice, order.getTotalPrice(), 0.01);
		assertEquals(listOfItems, order.getOrdersItems());
		assertEquals(customer, order.getFkCustomerId());
//		assertEquals(datePlaced, order.getDatePlaced());
	}

	@Test
	public void equalsTEST() {
		EqualsVerifier.simple().forClass(Order.class).verify();
		// verifies whether the contract for the equals and hashCode methods is met
	}

//	@Test
//	public void setTotalPriceTest(Double totalPrice) {
//		Customer customer = new Customer(3L, "Jake", "Peralta");
//		Item Scooter = new Item(3L, "Scooter", "Toys", 19.99F);
//		Item Notebook = new Item(4L, "Notebook", "Stationaries", 1.50F);
//		List<Item> ListOfItems = new ArrayList<>();
//		ListOfItems.add(Scooter);
//		ListOfItems.add(Notebook);
//		String datePlaced = "2022/02/01";
//		double TotalPrice = Scooter.getPrice() + Notebook.getPrice();
//		Order order = new Order(3L, customer, TotalPrice, datePlaced, ListOfItems);
//		order.setTotalPrice(200D);
//
//		assertEquals(200D, order.getTotalPrice());
//	}

	@Test
	public void toStringTEST() {
		Customer customer = new Customer(3L, "Jake", "Peralta");
		Item Scooter = new Item(3L, "Scooter", "Toys", 19.99F);
		Item Notebook = new Item(4L, "Notebook", "Stationaries", 1.50F);
		List<Item> ListOfItems = new ArrayList<>();
		ListOfItems.add(Scooter);
		ListOfItems.add(Notebook);
		String datePlaced = "2022/02/01";
		double totalPrice = Scooter.getPrice() + Notebook.getPrice();
		Order order = new Order(3L, customer, totalPrice, datePlaced, ListOfItems);

		assertEquals("Order [id=3, [fkCustomerId=id:3 first name:Jake surname:Peralta, "
				+ "totalPrice=21.489999771118164, datePlaced=null, "
				+ "ordersItems=[Item [id=3, itemName=Scooter, itemCategory=Toys, price=19.99], "
				+ "Item [id=4, itemName=Notebook, itemCategory=Stationaries, price=1.5]]]]", order.toString());
	}
}
