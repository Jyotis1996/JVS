package com.uks.jvs.Jyoti.Day1.Assignment3;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.uks.jvs.Jyoti.Constants;
import com.uks.jvs.Jyoti.Day1.Assignment3.PropertyUtil;

/**
 * Class Name:TableRowPrinter
 * Description:TableRowPrinter contains displayRecords method to display record
 * @author Jyoti [26/07/2019]
 *
 */
public class TableRowPrinter {
	/**
	 * Method Name:displayRecords Description:display the data from database
	 * table
	 *
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public void displayRecords() throws SQLException, ClassNotFoundException {
		PropertyUtil objPropertyUtil = null;
		Connection objConnection = null;
		String employeeId = null;
		String name = null;
		String title = null;
		String address = null;
		String homePhone = null;

		try {
			objPropertyUtil = new PropertyUtil();
			objConnection = objPropertyUtil.connect();
			Statement objStatement = objConnection.createStatement();
			// fire query and store result in resultSet
			ResultSet objResultSet = objStatement.executeQuery(Constants.strQuery_Ass3);
			// for formatting of the Headers
			System.out.printf("%5s %15s %30s %40s %45s \n", "Employee ID", "Name", "Title", "Address", "HomePhone");
			System.out.println(Constants.Seperator);
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
				System.out.format("%-20s %-30s %-30s %-50s %-25s \n", objResultSet.getString(1), objResultSet.getString(2), objResultSet.getString(3),
						objResultSet.getString(4), objResultSet.getString(5));
			}
			System.out.println(Constants.Seperator);
			objPropertyUtil.disconnect();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			objPropertyUtil = null;
			objConnection = null;
		}
	}
}
