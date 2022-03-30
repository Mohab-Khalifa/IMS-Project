package com.qa.ims;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.CustomerDAO;
import com.qa.ims.persistence.domain.Customer;

public class Runner {

	public static final Logger LOGGER = LogManager.getLogger();

	public static void main(String[] args) {
//		IMS ims = new IMS();
//		ims.imsSystem();
//		LOGGER.info("SO LONG!");

		CustomerDAO customerDAO = new CustomerDAO();

		Customer customer = customerDAO.read(1);
		System.out.println(customer);

	}

}
