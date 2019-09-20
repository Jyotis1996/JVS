package com.uks.jvs.Jyoti.Day1.Assignment1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.uks.jvs.Jyoti.Constants;

/**
 * Class Name:RecordDisplay Description:get the data from database
 *
 * @author Jyoti [19/07/2019]
 */

public class RecordDisplay {
	Connection objConnection = null;
	Statement objStatement;
	ResultSet objResultSet = null;

	String employeeId = null;
	String name = null;
	String title = null;
	String address = null;
	String homePhone = null;

	/**
	 * Default Constructor to call all methods
	 */
	public RecordDisplay() throws ClassNotFoundException, SQLException {
		this.connect();
		this.displayRecords();
		this.disconnect();
	}

	/**
	 * Method Name:connect Description:connection generation and open with jdbc
	 * driver
	 *
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void connect() throws ClassNotFoundException, SQLException {
		try {
			// connection open
				Class.forName(Constants.strtype1driver);
				// connection open
				objConnection = DriverManager.getConnection(Constants.strconnectionStringtype1);
		} finally {

		}
	}

	/**
	 * Method Name:displayRecords Description:display the data from database
	 * table
	 *
	 * @throws SQLException
	 */
	public void displayRecords() throws SQLException {
		try {
			objStatement = objConnection.createStatement();

			objResultSet = objStatement.executeQuery(Constants.strQuery_Ass1);// Query																	// execution
			System.out.printf("%5s %15s %30s %40s %45s \n", "Employee ID", "Name", "Title", "Address", "HomePhone");
			System.out.println(Constants.Seperator);
			// is executed until no more rows is there
			while (objResultSet.next()) {
				employeeId = objResultSet.getString(1);
				name = objResultSet.getString(2);
				title = objResultSet.getString(3);
				address = objResultSet.getString(4);
				homePhone = objResultSet.getString(5);
				if (employeeId == null) {
					employeeId = "-";
				}
				if (name == null) {
					name = "-";
				}
				if (title == null) {
					title = "-";
				}
				if (address == null) {
					address = "-";
				}
				if (homePhone == null) {
					homePhone = "-";
				}
				// Printing the Result in tabular format
				System.out.format("%-20s %-30s %-30s %-50s %-25s \n",employeeId,name,title,address,homePhone);
			}
			System.out.println(Constants.Seperator);
		} finally {
		}
	}


	/**
	 * Method Name:disconnect Description:close open connection
	 *
	 * @throws SQLException
	 */
	public void disconnect() throws SQLException {
		try {
			System.out.println("\n Database Dissconnected");
			objConnection.close();

		} finally {
			objConnection = null;
			objResultSet = null;
			objStatement = null;
		}
	}
}
