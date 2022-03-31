package com.qa.ims.persistence.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.persistence.domain.Order;

public class OrderDAO {

	public static final Logger LOGGER = LogManager.getLogger();

	private ItemDAO itemDAO;
	private CustomerDAO customerDAO;

	public OrderDAO(CustomerDAO customerDao, ItemDAO itemDao) {
		super();
		this.itemDAO = itemDao;
		this.customerDAO = customerDao;
	}

	@Override
	public Order modelFromResultSet(ResultSet resultSet) throws SQLException {
		Long id = resultSet.getLong("id");
		Long fkCustomerId = resultSet.getLong("fk_customers_id");
		List<Item> itemList = getItemsInOrder(id);
		double TotalPrice = calculateTotalOrderCost(id);
		Customer customer = customerDao.read(fk_customers_id);
		return new Order(id, customer, itemList, TotalPrice);
	}

}
