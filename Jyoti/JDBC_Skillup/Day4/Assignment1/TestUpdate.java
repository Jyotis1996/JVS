package com.uks.jvs.Jyoti.Day4.Assignment1;

import java.sql.SQLException;
import java.util.Scanner;
import com.uks.jvs.Jyoti.Constants;

/**
 * Class Name :TestUpdate Description :Main class to exceute UpdateInResultSet
 *
 * @author Jyoti [25/07/2019]
 *
 */
public class TestUpdate {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {

		// initializing the object
		UpdateInResultSet objUpdateResultSet = null;
		Scanner objScanner = null;
		try {

			objUpdateResultSet = new UpdateInResultSet();
			objScanner = new Scanner(System.in);
			// connecting to the data source

			objUpdateResultSet.connect();

			// fetching the record
			objUpdateResultSet.fetchRecord();

			// displaying the records
			objUpdateResultSet.display();

			// to update element into ResultSet
			System.out.println(Constants.Update_Choice);

			String choice = objScanner.next();

			if (choice.equalsIgnoreCase("Y")) {

				// inserting element into ResultSet
				objUpdateResultSet.updateRecord();

				// displaying updated ResultSet
				objUpdateResultSet.display();
			}
		} finally {
			objScanner.close();
			objUpdateResultSet.disconnect();
		}
	}

}
