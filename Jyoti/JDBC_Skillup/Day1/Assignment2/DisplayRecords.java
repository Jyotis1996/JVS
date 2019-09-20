package com.uks.jvs.Jyoti.Day1.Assignment2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.uks.jvs.Jyoti.Constants;

/**
 * Class Name:DisplayRecords Description: Display record class to display
 * filtered records based on employee_id
 *
 * @author Jyoti [22/07/2019]
 *
 */
public class DisplayRecords {
	Connection objConnection = null;
	Statement objStatement = null;
	ResultSet objResultSet = null;
	String employeeId = null;
	String name = null;
	String title = null;
	String address = null;
	String homePhone = null;
	int counter = 0;

	/**
	 * Method Name:connect Description:connection generation and open with jdbc
	 * driver
	 *
	 * @return objConnection
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public Connection connect() throws ClassNotFoundException, SQLException {

		try {
			// Connection
			System.out.println("Database Connected");
			objConnection = DriverManager.getConnection(Constants.strconnectionStringtype4, Constants.Username,
					Constants.Password);
		} catch (Exception e) {
			System.out.println("Error in connection" + e);
		}
		return objConnection;
	}

	/**
	 * Method Name:displayRecords Description:display the filtered data from
	 * database table
	 *
	 * @param ID
	 * @throws SQLException
	 */
	public void displayRecords() throws SQLException {

		try {
			objStatement = objConnection.createStatement();

			objResultSet = objStatement.executeQuery(Constants.strQuery_Ass2);// Query
																		// //
																		// execution
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
				System.out.format("%-20s %-30s %-30s %-50s %-25s \n", employeeId, name, title, address, homePhone);
			}
			System.out.println(Constants.Seperator);
		} finally {
		}

	}

	public void filterData() throws SQLException {
		objStatement = objConnection.createStatement();
		System.out.println("Enter Employee ID to be filtered");
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		int id = scan.nextInt();
		objResultSet = objStatement.executeQuery(Constants.strQUERY2_Ass2 + id);

		if (!(id == 0)) {
			// is executed until no more rows is there
			display(objResultSet);

			if (counter == 0) {
				System.out.println(Constants.NORecord);
				return;
			}

		}

	}

	public void display(ResultSet objResult) throws SQLException {
		while (objResult.next()) {
			employeeId = objResult.getString(1);
			name = objResult.getString(2);
			title = objResult.getString(3);
			address = objResult.getString(4);
			homePhone = objResult.getString(5);
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
			System.out.println("\n");
			// first displaying headers in data
			System.out.printf("%5s %15s %30s %40s %45s \n", "EmployeeID", "EmployeeName", "Title", "FullAddress",
					"HomePhone");
			System.out.println("\n");
			// Printing data
			System.out.format("%-20s %-30s %-30s %-50s %-25s\n", employeeId, name, title, address, homePhone);
			counter++;
		}
	}

	/**
	 * Method Name:disconnect Description:close open connection
	 *
	 * @throws SQLException
	 */
	public void disconnect() throws SQLException {

		try {
			objConnection.close();
			objResultSet.close();
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
		    objConnection = null;
		    objStatement = null;
            objResultSet = null;
		}
	}

}
