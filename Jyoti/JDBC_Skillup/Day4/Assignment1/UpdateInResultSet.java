package com.uks.jvs.Jyoti.Day4.Assignment1;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.uks.jvs.Jyoti.Day1.Assignment3.PropertyUtil;
import com.uks.jvs.Jyoti.Constants;

/**
 * Class Name : UpdateInResultSet Description :Update data in result set
 *
 * @author Jyoti [25/07/2019]
 *
 */
public class UpdateInResultSet {

	PropertyUtil objPropertyUtil = null;

	ResultSet objResultSet = null;;

	String command = Constants.Command;

	// connecting to the data source
	public void connect() throws ClassNotFoundException, SQLException {
		objPropertyUtil.connect();
	}

	// fetching records
	public void fetchRecord() throws SQLException {
		Connection objConnection = objPropertyUtil.getObjConnection();

		// creating updatable ResultSet
		Statement objStatement = objConnection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
				ResultSet.CONCUR_UPDATABLE);

		// executing teh query
		objResultSet = objStatement.executeQuery(command);
	}

	// Display records
	public void display() throws SQLException {

		// initilizing index at beforeFirst position
		objResultSet.beforeFirst();
		System.out.println(Constants.Title_Head);
		System.out.println(Constants.Seperator);

		while (objResultSet.next()) {
			System.out.println(objResultSet.getInt(1) + " \t | " + objResultSet.getString(3) + " \t | "
					+ objResultSet.getString(2) + " \t | " + objResultSet.getString(4) + "\n");
		}
	}

	// to update element into the resultset
	public void updateRecord() throws SQLException {
		Scanner sc = new Scanner(System.in);
		System.out.println(Constants.Update);
		int id = sc.nextInt();

		// initilizing index at beforeFirst position
		objResultSet.beforeFirst();

		// initializing flag variable
		int flag = 0;

		while (objResultSet.next()) {

			// search element details by EmployeeID
			if (objResultSet.getInt(1) == id) {

				// getting rowNumber for the matched Result
				int rownum = objResultSet.getRow();

				// pointing to the dezzired rowNumber
				objResultSet.absolute(rownum);

				// fetching new record details from user
				System.out.println(Constants.Enter_Name);
				String fname = sc.next();
				System.out.println(Constants.Enter_lastname);
				String lname = sc.next();
				System.out.println(Constants.Enter_designation);
				String desig = sc.next();

				// Updating element to the ResultSet
				objResultSet.updateInt(1, id);
				objResultSet.updateString(2, lname);
				objResultSet.updateString(3, fname);
				objResultSet.updateString(4, desig);
				objResultSet.updateRow();

				System.out.println(Constants.Data_updated);

				// updating flag value
				flag = 1;

				// terminating the loop
				break;
			}
		}

		// when employeeID not matched
		if (flag == 0) {
			System.out.println(Constants.No_Record);
			System.out.println();
		}

		// closing the Scanner object
		sc.close();
	}

	// Disconnecting the data source
	public void disconnect() throws SQLException {
		objResultSet.close();
	}
}
