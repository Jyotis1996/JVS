package com.assignment1.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
	Connection con = null;

	/**
	 * This method connect java application with the database
	 *
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public Connection connect() throws ClassNotFoundException, SQLException {
		try {
			// Load the driver
			Class.forName("com.mysql.jdbc.Driver");
			// create the connection
			con = DriverManager.getConnection("jdbc:mysql://172.16.1.15:3306/northwind_jyoti", "jyoti", "jyoti@741");
		} finally {
		}
		return con;
	}

}
