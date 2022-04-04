package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

public class CustomerTest {

	@Test
	public void testEquals() {
		EqualsVerifier.simple().forClass(Customer.class).verify();
	}

	@Test
	public void toStringTest() {
		Customer customer = new Customer(1L, "James", "Arthur");
		String expected = "id:1 first name:James surname:Arthur";
		assertEquals(expected, customer.toString());
	}

	@Test
	public void firstConstructorTest() {
		Customer customer = new Customer("Peter", "Dinklage");
		assertEquals("Peter", customer.getFirstName());
		assertEquals("Dinklage", customer.getSurname());

	}

	@Test
	public void secondConstructorTest() {
		Customer customer = new Customer(1L, "Harry", "Pinero");
		assertEquals(Long.valueOf("1"), customer.getId());
		assertEquals("Harry", customer.getFirstName());
		assertEquals("Pinero", customer.getSurname());

	}

}
