package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.DBUtils;

public class ItemDAOTest {

	private final ItemDAO DAO = new ItemDAO();

	@Before
	public void setup() {
		DBUtils.connect();
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
	}

	@Test
	public void readAllTEST() {
		List<Item> expected = new ArrayList<>();
		expected.add(new Item(1L, "PS5", "Gaming", 449.99F));
		assertEquals(expected, DAO.readAll());
	}

	@Test
	public void createTEST() {
		final Item created = new Item(2L, "XBOX ONE", "Gaming", 449.99F);
		assertEquals(created, DAO.create(created));
		assertEquals(null, DAO.create(null));
	}

	@Test
	public void readTEST() {
		final long ID = 1L;
		assertEquals(new Item(ID, "PS5", "Gaming", 449.99F), DAO.read(ID));
		assertEquals(null, DAO.read(null));
	}

	@Test
	public void deleteTEST() {
		assertEquals(1, DAO.delete(1L));
		assertEquals(0, DAO.delete(0L));
	}

//	@Test
//	public void removeOrdersItemsTEST() {
//		assertEquals(0, DAO.removeOrdersItems(new Item(1L, "PS5", "Gaming", 449.99F), 1L));
//	}

	@Test
	public void readLatestTEST() {
		assertEquals(new Item(1L, "PS5", "Gaming", 449.99F), DAO.readLatest());
	}

	@Test
	public void updateTEST() {
		final Item updated = new Item(1L, "PS5", "Gaming", 449.99F);
		assertEquals(updated, DAO.update(updated));
	}

}
