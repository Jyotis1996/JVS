package com.uks.Login;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.uks.common.Constants;
import com.uks.common.DbLogic;

/**
 * This class is used to make the connection with the database and validate the
 * username and password
 *
 * @author Jyoti Date-2019/08/30
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
	public boolean validateUser(String username, String password) throws ClassNotFoundException, SQLException {
		DbLogic objDbLogic = new DbLogic();
		Connection con = null;
		ResultSet objResultSet = null;
		Statement objStatement = null;
		try {
			// initialize the object of ConnectDB class
			objDbLogic = new DbLogic();
			// call connect method for database connection
			con = objDbLogic.connect();
			// Sql Query
			String sql = Constants.SELECT_QUERY;
			objStatement = con.createStatement();
			// Execute the Query
			objResultSet = objStatement.executeQuery(sql);
			// Loop till resultSet has records
			while (objResultSet.next()) {
				// check the USername and password
				if (username.equals(objResultSet.getString(2)) && password.equals(objResultSet.getString(3))) {
					return true;
				}
			}
		} catch (Exception e) {
			System.out.println(Constants.ERROR_OCCURRED + e.getLocalizedMessage());
		} finally {
			// Close the objects
			con.close();
			objResultSet.close();
			objStatement.close();
		}
		return false;
	}
}
