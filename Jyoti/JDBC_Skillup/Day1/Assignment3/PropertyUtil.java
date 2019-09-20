
package com.uks.jvs.Jyoti.Day1.Assignment3;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

import com.uks.jvs.Jyoti.Constants;

/**
 * Class Name:PropertyUtil Description: property util class fetches database
 * connection details from properties file and displays data
 *
 * @author Jyoti [22/07/2019]
 *
 */
public class PropertyUtil {

	// initializing the object of connection
	static Connection objConnection = null;

	/**
	 * Method Name:connect Description:connection generation and open with jdbc
	 * driver
	 *
	 * @return objConnection
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
        public Connection getObjConnection() {
		return objConnection;
	}
	public Connection connect() throws ClassNotFoundException, SQLException {
		try {
			// Passing the property file location
			FileInputStream fis = new FileInputStream(Constants.strSettingsPropertyfile);
			ResourceBundle myBundle = new PropertyResourceBundle(fis);
			String dbname = myBundle.getString("DBname");
			String url = myBundle.getString("URL");
			String uname = myBundle.getString("Username");
			String pass = myBundle.getString("Password");

			// finding the class
			Class.forName(dbname);
			// establishmenting the connection
			objConnection = DriverManager.getConnection(url, uname, pass);
			System.out.println("Database Connecting.....");
		} catch (Exception e) {
			e.printStackTrace();
		}
        return objConnection;
	}




	/**
	 * Method Name:disconnect Description:close open connection
	 *
	 * @throws SQLException
	 */
	public void disconnect() throws SQLException {
		System.out.println("Database Disconnecting.....");
		objConnection.close();
		// closing the connection
	}
}
