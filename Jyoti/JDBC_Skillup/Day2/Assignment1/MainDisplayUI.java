package com.uks.jvs.Jyoti.Day2.Assignment1;

/**
 * ClassName:MainDisplayUI
 * Description:Main Class to get input from user and display data
 * @author Jyoti [29/07/2019]
 */
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.uks.jvs.Jyoti.Constants;
import com.uks.jvs.Jyoti.Day1.Assignment3.PropertyUtil;

public class MainDisplayUI {

	/**
	 * Main method to call method from the related class
	 *
	 * @param args
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws IOException
	 */
	public static void main(String args[]) throws ClassNotFoundException, SQLException, IOException {
		Connection objConnection = null;
		PropertyUtil objPropertyUtil = null;
		RowsFetcher objRowsFetcher = null;
		DisplayUI objDisplayUI = null;
		Scanner objScanner = null;
		int pageNo = 0;

		try {
			objPropertyUtil = new PropertyUtil();
			objRowsFetcher = new RowsFetcher();
			objDisplayUI = new DisplayUI();
			objConnection = objPropertyUtil.connect();

			objScanner = new Scanner(System.in);
			System.out.println(Constants.Coice_PageNo);
			int input = objScanner.nextInt();
			switch (input) {
			case 1:
				do {
					System.out.println(Constants.EnterPageNo);
					pageNo = objScanner.nextInt();
					objDisplayUI.dispalysRecords(objConnection, pageNo);
				} while (true);
			case 2:
				// It is used to get connection object
				// "execute query" method is called to execute query
				ResultSet rs = objRowsFetcher.executequery(objConnection, 7);
				// it is called to set the result set
				objDisplayUI.pass(objRowsFetcher, rs);
				// "displayRowsPerPage" this method is called to display result
				objDisplayUI.displayRowsPerPage("N");
				// "disconnect" method is called to disconnect connection
				objPropertyUtil.disconnect();

				break;
			default:
				System.out.println(Constants.InvalidChoice);
			}

		} catch (ClassNotFoundException e) {
			System.out.println("Class Not Found");
		} catch (SQLException e) {
			System.out.println("SQL Exception");
		} catch (Exception e) {

			System.out.println("Some error occurred");

		} finally {
			objConnection = null;

			objRowsFetcher = null;
			objPropertyUtil = null;
			objDisplayUI = null;

		}
	}

}
