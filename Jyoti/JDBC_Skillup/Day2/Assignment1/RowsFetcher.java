package com.uks.jvs.Jyoti.Day2.Assignment1;

/**
 * Class Name :RowsFetcher
 * Description :this class is used to get and set the results from the database
 *
 */
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.uks.jvs.Jyoti.Constants;

public class RowsFetcher {
	int numCols;
	ArrayList<EmpData> listone = new ArrayList<EmpData>();
	ArrayList<EmpData> listtwo = new ArrayList<EmpData>();
	ArrayList<EmpData> list = new ArrayList<EmpData>();

	String rowsPerPage = "5";
	int NumberOfRowsperPage = 0;
	private ResultSet objResultSet;

	/**
	 * this method is used to execute the query
	 *
	 * @param con
	 * @return
	 * @throws SQLException
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */

	ResultSet executequery(Connection con, int numberofRows) throws SQLException, ClassNotFoundException, IOException {

		Statement objstatement = null;
		try {
			NumberOfRowsperPage = numberofRows;

			objstatement = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

			objResultSet = objstatement.executeQuery(Constants.strQuery_Ass2_1);
			objResultSet.last();
			numCols = objResultSet.getRow();
			objResultSet.beforeFirst();

		} finally {
			if (objstatement != null)
				objstatement = null;
		}
		return objResultSet;
	}

	/**
	 * this method is used to fetch rows and return it by using list
	 *
	 * @param input
	 * @return list
	 * @throws SQLException
	 */
	public ArrayList<EmpData> getRowsPerPage(String input) throws SQLException {

		if (input.equalsIgnoreCase("N")) {

			list = nextpage();
		}
		if (input.equalsIgnoreCase("p")) {
			list = backpage();

		}
		return list;

	}

	/**
	 * this method is used to go next page
	 *
	 * @throws SQLException
	 */
	public ArrayList<EmpData> nextpage() throws SQLException {

		while (objResultSet.next()) {

			listone.add(new EmpData(objResultSet.getString(1), objResultSet.getString(2), objResultSet.getString(3),
					objResultSet.getString(4), objResultSet.getString(5)));

			if (objResultSet.getRow() % NumberOfRowsperPage == 0) {

				break;
			}
			if (objResultSet.getRow() >= numCols) {
				objResultSet.beforeFirst();
				objResultSet.last();
				break;

			}

		}
		return listone;
	}

	/**
	 * this method is used to go previous page
	 *
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<EmpData> backpage() throws SQLException {
		int count = 0;
		try {

			for (count = 14; count >= 1; count--) {
				objResultSet.previous();

			}

			while (objResultSet.next()) {
				listtwo.add(new EmpData(objResultSet.getString(1), objResultSet.getString(2), objResultSet.getString(3),
						objResultSet.getString(4), objResultSet.getString(5)));

				if (objResultSet.getRow() % NumberOfRowsperPage == 0) {

					break;
				}
				if (objResultSet.getRow() >= numCols) {

					objResultSet.beforeFirst();
					break;
				}
			}
			return listtwo;
		} finally {
			count = 0;
		}
	}
}
