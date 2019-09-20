
package com.uks.jvs.Jyoti.Day3.Assignment1;

import java.sql.SQLException;
import java.util.Scanner;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.WebRowSet;

import com.uks.jvs.Jyoti.Constants;

/**
 * Class Name:RowSetDisplayer Description:Main method to display the data by
 * understanding cached and xml rowset
 *
 * @author Jyoti [24/07/2019]
 *
 */
public class RowSetDisplayer {

	/**
	 * Method Name : Main method
	 * Description : main method to display data either in cached or xml format
	 */

	// Creating object of DataFetcher class
	DataFetcher objDataFetcher = new DataFetcher();

	public static void main(String[] args) {
		try {
			// Getting the input from user
			System.out.println(Constants.Choice_Ass1);
			Scanner scan = new Scanner(System.in);
			int input = scan.nextInt();
			// Creating object and calling the DisplayEmpData method
			RowSetDisplayer objRowSetDisplayer = new RowSetDisplayer();
			objRowSetDisplayer.DisplayEmpData(input);
			scan.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Method Name : DisplayEmpData
	 * Description : Method to get choice and display data either in cached format or xml format
	 */
   private void DisplayEmpData(int num) throws Exception {
		// Establishing the connection
		objDataFetcher.connect();
		// user enters 1 then Cached function is called
		if (num == 1) {
			CachedRowSet rowset = objDataFetcher.executeInCached();
			displayCached(rowset);

		}
		// user enters 2 then XML function is called
		else if (num == 2) {
			WebRowSet rowset = objDataFetcher.executeInXML();
			displayXML(rowset);

		}
		// Enter other than 1 or 2
		else {
			System.out.println(Constants.Wrong_Input);

		}
		objDataFetcher.disconnect();
	}

   /**
    * Method Name : displayCached
    * Description : Method to display data in cached format
    * @param rowset
    * @throws SQLException
    */
	private void displayCached(CachedRowSet rowset) throws SQLException {
		// Default header is printing
		System.out.printf("%10s %20s %20s %30s %20s \n", "Employee ID", "Last Name", "First Name", "Title",
				"Birth Date");
		System.out.println(Constants.Seperator);

		while (rowset.next()) {
			System.out.printf("%10s %20s %20s %30s %20s \n", rowset.getString(1), rowset.getString(2),
					rowset.getString(3), rowset.getString(4), rowset.getString(5));
		}
	}

	/**
	 * Method Name : displayXML
	 * Description : Method to display data in XML format
	 * @param rowset
	 * @throws SQLException
	 */
	private void displayXML(WebRowSet rowset) throws SQLException {
		// Default header is printing
		System.out.printf("%10s %20s %20s %30s %20s \n", "Employee ID", "Last Name", "First Name", "Title",
				"Birth Date");
		System.out.println(Constants.Seperator);
		while (rowset.next()) {
			System.out.printf("%10s %20s %20s %30s %20s \n", rowset.getString(1), rowset.getString(2),
					rowset.getString(3), rowset.getString(4), rowset.getString(5));
		}
	}
}
