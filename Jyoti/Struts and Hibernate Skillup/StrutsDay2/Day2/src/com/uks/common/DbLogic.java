package com.uks.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.uks.common.Constants;

public class DbLogic {
	Connection con = null;

	/**
	 * This method connect java application with the database
	 *
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public Connection connect() throws ClassNotFoundException, SQLException {
		try {

			// Passing the property file location

			ResourceBundle myBundle = ResourceBundle.getBundle(Constants.PATH);
			String URL = myBundle.getString(Constants.DB_URL);
			String Driver = myBundle.getString(Constants.DB_DriverName);
			String db_username = myBundle.getString(Constants.DB_username);
			String db_password = myBundle.getString(Constants.Db_password);

			// finding the class
			Class.forName(Driver);
			con = DriverManager.getConnection(URL, db_username, db_password);
			System.out.println(Constants.CONNECTION);
		} finally {
		}
		return con;
	}
	public void disconnect() {
		try {
			System.out.println(Constants.DISCONNECTION);
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}