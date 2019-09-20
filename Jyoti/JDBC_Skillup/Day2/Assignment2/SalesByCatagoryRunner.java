package com.uks.jvs.Jyoti.Day2.Assignment2;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.util.ArrayList;

import com.uks.jvs.Jyoti.Constants;

/**
 * Class Name:SalesByCategoryRunner Description: this class calls stored
 * procedure SalesByCategory and displays data
 *
 * @author Jyoti [23/07/2019]
 *
 */
public class SalesByCatagoryRunner {
	// class properties
	public int rowsPerPage = 5;
	Connection objConnection;
	public int nextPage = 1;
	public int previousPage = 0;
	// here we just passing parameter to the RowFetcher class so we can call the
	// methods of that class

	// class constructor
	public SalesByCatagoryRunner(Connection connection, int rows) {
		this.objConnection = connection;
		this.rowsPerPage = rows;
	}

	/**
	 * method can return array list which fetch data.
	 *
	 * @param catagoryName
	 * @param orderYear
	 * @param choice
	 * @return
	 * @throws Exception
	 */
	public ArrayList<SalesByCatData> fetchRecords(String catagoryName, String orderYear, String choice)
			throws Exception {
		// array list object
		ArrayList<SalesByCatData> objArrayList = null;
		// result set object
		ResultSet objResultSet = null;
		// object of callableStatement
		CallableStatement objCallableStatement = null;
		// salesByCatData object
		SalesByCatData objSalesByCatData = null;

		int currentPage = 1;
		int totalPage = 0;
		int totalRows = 0;

		try {
			// here we call the stored procedure which is created in the
			// database
			objCallableStatement = objConnection.prepareCall(Constants.Procedure_call, ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			objCallableStatement.setString(1, catagoryName);
			objCallableStatement.setString(2, orderYear);
			objCallableStatement.execute();
			// result set contains the data fetch from the database
			objResultSet = objCallableStatement.getResultSet();

			objArrayList = new ArrayList<>();
			// here pointer goes to the end of the result class
			objResultSet.last();
			// here we get total rows in resultSet
			totalRows = objResultSet.getRow();
			// calculate the total page
			totalPage = totalRows / rowsPerPage;

			if (totalRows % rowsPerPage == 0) {
				totalPage--;
			}
			// here we call the countPage method of the RowFetcher class for
			// next,previous and exit command
			currentPage = displayCount(choice, currentPage, totalPage);
			objResultSet.absolute(((currentPage - 1) * rowsPerPage) + 1);
			do {
				if (objArrayList.size() < rowsPerPage) {
					objSalesByCatData = new SalesByCatData();
					// fetch data from database
					objSalesByCatData.setProductName(objResultSet.getString(1));
					objSalesByCatData.setTotalPurchase(objResultSet.getDouble(2));
					// add the elements to array list
					objArrayList.add(objSalesByCatData);

				}
				// condition check until records found
			} while (objResultSet.next());
		} finally {

		}
		// return object array
		return objArrayList;
	}

	private int displayCount(String choice, int currentPage, int totalPage) {

		// if next page choice then go to next page
		if (choice.equals("n")) {

			// current page
			currentPage = nextPage + 1;

			if (currentPage == totalPage + 2) {

				System.out.println(Constants.no_data);
				currentPage = nextPage;
				// else
			} else {

				nextPage++;
				previousPage = nextPage - 1;
			}
		}
		// if choice is previousPage
		if (choice.equals("p")) {

			// current page
			currentPage = previousPage;
			// if currentPage is = 0
			if (currentPage == 0) {

				System.out.println(Constants.no_data);
				currentPage = nextPage;
			} else {
				previousPage--;
				nextPage = previousPage + 1;
			}
		}
		// if choice equals nothing matches then at first place
		if (choice.equals("n")) {
			currentPage = nextPage;
		}
		// return currentPage
		return currentPage;
	}

}
