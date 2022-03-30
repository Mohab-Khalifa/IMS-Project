package com.qa.ims.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcUtils {

	private String connectionUrl; // jdbc:vendor://url:port/databaseName?parameters
	private String username;
	private String password;

	private JdbcUtils(String connectionUrl, String username, String password) {
		super();
		this.connectionUrl = connectionUrl;
		this.username = username;
		this.password = password;
	}

	private static JdbcUtils utils;

	public static Connection getConnector() throws SQLException {
		if (utils == null) {
			utils = new JdbcUtils("jdbc:mysql://localhost:3306/ims?serverTimezone=UTC", "root", "Mysqlpassword123");
		}
		// use DriverManager.getConnection to get a connection to a database
		return DriverManager.getConnection(JdbcUtils.utils.connectionUrl, JdbcUtils.utils.username,
				JdbcUtils.utils.password);
	}

	public static Connection getConnection(String connectionUrl, String username, String password) throws SQLException {
		return DriverManager.getConnection(connectionUrl, username, password);
	}

}
