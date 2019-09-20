package com.uks.jvs.Jyoti.Day2.Assignment2;

import java.sql.Connection;
import java.util.Scanner;
import java.util.ArrayList;
import com.uks.jvs.Jyoti.Constants;

//propertyutil class for database connection
import com.uks.jvs.Jyoti.Day1.Assignment3.PropertyUtil;

/**
 * Class Name:DataDisplayer Description:class contains two main method
 * displayRowPerPage method and print method
 *
 * @author Jyoti [23/07/2019]
 *
 */

public class DataDisplayer {
	/**
	 * In displayrowPerPage method can accept product catagory and year from
	 * user which here want to display.
	 *
	 * @throws Exception
	 */
	public static void displayRowPerPage() throws Exception {
		// create object of the SalesByCatagoryRunner
		SalesByCatagoryRunner objRowFetcher = null;
		// here object of the array list is created
		ArrayList<SalesByCatData> objArrayList = null;
		// connection class object
		Connection objConnection;
		// scanner class object
		Scanner objScanner = null;

		// string is used to getting connection parameter
		// object of PropertyUtil class
		PropertyUtil objPropertyUtil = null;
		// here we create the object of the DisplayUI class

		String choice = "";
		String CatName = "";
		String year = "";

		try {
			objPropertyUtil = new PropertyUtil();
			objConnection = objPropertyUtil.connect();
			objRowFetcher = new SalesByCatagoryRunner(objConnection, 7);
			// here it fetch records who is matching requirements
			try {
				objScanner = new Scanner(System.in);
				System.out.println(Constants.Category);
				CatName = objScanner.next();
				System.out.println(Constants.Year);
				year = objScanner.next();
				objArrayList = objRowFetcher.fetchRecords(CatName, year, "f");

				// objScanner=new Scanner(System.in);
				// call the print method
				dataPrint(objArrayList);
			} catch (Exception e) {
				System.out.println(Constants.Proper_Input);
				displayRowPerPage();
				System.exit(0);
			}

			System.out.println(Constants.Choice);
			while (!choice.equalsIgnoreCase("x")) {
				choice = objScanner.next();
				// choice made available for user
				switch (choice) {
				case "n":
				case "N":
					objArrayList = objRowFetcher.fetchRecords(CatName, year, "n");
					// here call the print method
					dataPrint(objArrayList);
					break;

				case "p":
				case "P":
					objArrayList = objRowFetcher.fetchRecords(CatName, year, "p");
					// here also called the print method
					dataPrint(objArrayList);
					break;

				case "x":
				case "X":
					objScanner.close();
					System.out.println(Constants.Exit);
					// system exited
					System.exit(0);
					break;
				default:
					System.out.println(Constants.Proper_Option);
					break;
				}

			}
		} finally {
			objPropertyUtil = null;
			objRowFetcher = null;
			objConnection = null;
		}

	}

	/**
	 * this method can print the details
	 *
	 * @param objArrayList
	 */
	public static void dataPrint(ArrayList<SalesByCatData> objArrayList) {
		System.out.printf("%5s %30s \n", "ProductName", "TotalPrice\n\n");
		System.out.println(Constants.Seperator);
		for (SalesByCatData objCatData : objArrayList) {
			System.out.printf("%-20s %15s \n", objCatData.getProductName(), objCatData.getTotalPurchase(), "\n");
		}
		System.out.println(Constants.Seperator);
	}

}
