package com.assignment1.logic;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.assignment1.Database.ConnectDB;
import com.assignment1.common.Constants;

/**
 * This class is used to make the connection with the database and validate the
 * username and password
 *
 * @author Jyoti Date-2019/09/09
 *
 */
public class LoginLogic {
	/**
	 * This method is make a connection with the database and validate the user
	 *
	 * @param username
	 * @param password
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public boolean validateUser(String username, String password)
			throws ClassNotFoundException, SQLException {
		Connection objConnection = null;
		ConnectDB objConnectDB = null;
		ResultSet objResultSet = null;
		Statement objStatement = null;
		try {
			// initialize the object of ConnectDB class
			objConnectDB = new ConnectDB();
			// call connect method for database connection
			objConnection = objConnectDB.connect();
			// Sql Query
			String sql = Constants.SELECT_QUERY;
			objStatement = objConnection.createStatement();
			// Execute the Query
			objResultSet = objStatement.executeQuery(sql);
			// Loop till resultSet has records
			while (objResultSet.next()) {
				// check the USername and password
				if (username.equals(objResultSet.getString(2))
						&& password.equals(objResultSet.getString(3))) {
					return true;
				}
			}
		} catch (Exception e) {
			System.out.println("Error Occurred....." +e.getLocalizedMessage());
		} finally {
			// Close the objects
			objConnection.close();
			objResultSet.close();
			objStatement.close();
		}
		return false;
	}
}
