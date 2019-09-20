
package com.uks.jvs.Jyoti.Day3.Assignment2;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.uks.jvs.Jyoti.Day1.Assignment3.PropertyUtil;
import com.uks.jvs.Jyoti.Constants;

/**
 * Class Name : InsertIntoResultSet Description :Inserting data in database
 * usding resultset
 *
 * @author Jyoti [24/07/2019]
 */
public class InsertIntoResultSet {
	Connection con;
	PropertyUtil objPropertyUtil = new PropertyUtil();
	Scanner objScanner = null;

	String employeeId = null;
	String name = null;
	String title = null;
	String address = null;
	String homePhone = null;

	// For connecting to the DB
	void connect() throws ClassNotFoundException, SQLException {
		con = objPropertyUtil.connect();
	}

	// For insertion of the Row
	void inserInto() {
		try {
			// Firing query to DB;
			PreparedStatement prepStmt = con.prepareStatement(Constants.Query_ResultSet,
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			objScanner = new Scanner(System.in);
			ResultSet objResultSet = prepStmt.executeQuery();
			System.out.println(Constants.Before_Inserting);
			showRecords(objResultSet);
			objResultSet.first();

			System.out.println(Constants.EmployeeDetails);
			System.out.println(Constants.EmployeeID);
			System.out.println(Constants.FirstName);
			String fname = objScanner.next();
			System.out.println(Constants.LastName);
			String lname = objScanner.next();
			System.out.println(Constants.BirthDate);
			String date = objScanner.next();
			System.out.println(Constants.Title);
			String title = objScanner.next();
			// Inserting Operation start
			System.out.println(Constants.Inserting);
			objResultSet.moveToInsertRow();
			objResultSet.updateString("FirstName", fname);
			objResultSet.updateString("LastName", lname);
			objResultSet.updateString("Title", title);
			objResultSet.updateDate("BirthDate", Date.valueOf(date));
			objResultSet.updateString("Notes", "");
			objResultSet.insertRow();
			System.out.println(Constants.New_Record);
			System.out.println(Constants.After_Inserting);
			// Display the records
			showRecords(objResultSet);
			objResultSet.first();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// For disconnecting to the DB
	void disconnect() throws Exception {
		objPropertyUtil.disconnect();
	}

	// For Display the data
	void showRecords(ResultSet rs) {
		System.out.printf("%5s %15s %30s %40s %45s \n", "Employee ID", "Name", "Title", "Address", "HomePhone");
		System.out.println(Constants.Seperator);
		try {
			while (rs.next()) {
				employeeId = rs.getString(1);
				name = rs.getString(2);
				title = rs.getString(3);
				address = rs.getString(4);
				homePhone = rs.getString(5);
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
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Constants.Seperator);
	}
}
