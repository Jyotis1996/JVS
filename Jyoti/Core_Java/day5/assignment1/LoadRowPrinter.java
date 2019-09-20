package com.uks.jvs.jyoti.day5.assignment1;

import java.util.ArrayList;

/**
 * Class Name : LoadRowPrinter description : class contains main method to read
 * and print file data
 *
 * @author Jyoti [28-06-2019]
 *
 */
public class LoadRowPrinter {
	public static void main(String[] ar) {
		/**
		 * Main method description - read and print file data
		 */
		ArrayList<BaseEmployee> objArrayList = null;
		RowReader objRowReader = null;
		RowPrinter objRowPrinter = null;
		try {
			// instantiate ArrayList
			objArrayList = new ArrayList<>();
			// instantiate RowReader
			objRowReader = new RowReader();
			// instantiate RowPrinter
			objRowPrinter = new RowPrinter();
			// Call method showDetails for Print the data from source file
			objArrayList = objRowReader.showDetails(ar[0]);
			objRowPrinter.printDetails(objArrayList);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			objArrayList.clear();
			objRowReader = null;
			objRowPrinter = null;
		}
	}

}
