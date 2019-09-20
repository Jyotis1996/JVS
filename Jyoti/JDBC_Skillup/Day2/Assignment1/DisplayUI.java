package com.uks.jvs.Jyoti.Day2.Assignment1;

/**
 * ClassName : DisplayUI
 * Description: this class is used display results from the database in formatted way
 * @author Jyoti [29/07/2019]
 */
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

import com.uks.jvs.Jyoti.Constants;

public class DisplayUI {

	static int numberOfColumns;
	static ResultSet objResultSet = null;
	static ArrayList<EmpData> list = new ArrayList<EmpData>();
	static RowsFetcher objRowsFetcher = null;
	private int rowsPerPage = 5;
	Statement objstatement = null;
	String employeeId = null;
	String name = null;
	String title = null;
	String address = null;
	String homePhone = null;
	int counter = 0;

	/**
	 * Method Name:displayRowsPerPage Description:this methed takes result from
	 * "getRowsPerPage" method of Rowsfetcher and displays it
	 *
	 * @param objRowsFetcher
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws IOException
	 */
	public void displayRowsPerPage(String userInput) throws ClassNotFoundException, SQLException, IOException {
		try {
			if (userInput.equalsIgnoreCase("N")) {
				if (objResultSet.getRow() == 0) { // fetch the records and
													// display if result set
													// pointer is on row = 0
					list = objRowsFetcher.getRowsPerPage(userInput);
					display(list);
					checkinput();
				}

				if ((objResultSet.getRow() % 7) == 0) {// fetch the records and
														// display if result set
														// pointer is on row is
														// divisible by 7
					list = objRowsFetcher.getRowsPerPage(userInput);
					display(list);

					if (objResultSet.getRow() == numberOfColumns || objResultSet.getRow() == (numberOfColumns - 1)) {
						checkinputSecond();
					} else {
						checkinputFirst();
					}
				}
				if (objResultSet.getRow() == numberOfColumns) {

					checkinputSecond();
				}
			}
			if (userInput.equalsIgnoreCase("X")) {
				System.exit(0);
			}

			if (userInput.equalsIgnoreCase("P")) {
				if ((objResultSet.getRow() % 7) == 0) {
					list = objRowsFetcher.getRowsPerPage(userInput);
					display(list);

					if ((objResultSet.getRow() != 0) && objResultSet.getRow() < numberOfColumns) {
						if (objResultSet.getRow() == numberOfColumns
								|| objResultSet.getRow() == (numberOfColumns - 1)) {
							checkinputSecond();
						} else {
							checkinputFirst();
						}

					}
					if (objResultSet.getRow() == 0 || objResultSet.getRow() == 7) {
						checkinput();
					} else {
						checkinputFirst();
					}

				}
				if (objResultSet.getRow() == numberOfColumns) {
					list = objRowsFetcher.getRowsPerPage(userInput);
					display(list);
					checkinput();
				}
			}

		} finally {
		}
	}

	/**
	 *
	 * this method is used to takes object of resultset and object of
	 * RowsFetcher as Parameter
	 *
	 * @param objRowsFetcherOne
	 * @param objResultSet1
	 * @throws SQLException
	 */
	public void pass(RowsFetcher objRowsFetcherOne, ResultSet objResultSet1) throws SQLException {
		objRowsFetcher = objRowsFetcherOne;
		objResultSet = objResultSet1;
		objResultSet.last();
		numberOfColumns = objResultSet.getRow();
		objResultSet.beforeFirst();
	}

	/**
	 * this method is used to take input from user
	 *
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	@SuppressWarnings("resource")
	public static void checkinput() throws SQLException, ClassNotFoundException, IOException {
		Scanner objscanner = null;
		String choiceInput = null;
		DisplayUI objDisplayUI = new DisplayUI();
		try {

			objscanner = new Scanner(System.in);
			System.out.println(Constants.Choice);
			choiceInput = objscanner.next();

			if (choiceInput.equalsIgnoreCase("N") || choiceInput.equalsIgnoreCase("X")) {
				objDisplayUI.displayRowsPerPage(choiceInput);
			} else {
				System.out.println(Constants.InvalidChoice);
				checkinput();
			}

		} finally {
			objscanner = null;
			choiceInput = null;
		}
	}

	/**
	 * this method is used to take input from user to display data using next
	 * and previous commands
	 *
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	@SuppressWarnings("resource")
	public static void checkinputFirst() throws SQLException, ClassNotFoundException, IOException {
		Scanner objscanner = null;
		String choiceInput = null;
		DisplayUI objDisplayUI = new DisplayUI();
		try {
			objscanner = new Scanner(System.in);

			System.out.print(Constants.Choice);
			choiceInput = objscanner.next();

			if (choiceInput.equalsIgnoreCase("N") || choiceInput.equalsIgnoreCase("P")
					|| choiceInput.equalsIgnoreCase("X")) {

				objDisplayUI.displayRowsPerPage(choiceInput);

			} else {
				System.out.println(Constants.InvalidChoice);
				checkinputFirst();
			}

		} finally {
			objscanner = null;
			choiceInput = null;
		}
	}

	/**
	 * this method is used to take input from user
	 *
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	@SuppressWarnings("resource")
	public static void checkinputSecond() throws SQLException, ClassNotFoundException, IOException {
		Scanner objscanner = null;
		String choiceInput = null;
		DisplayUI objDisplayUI = new DisplayUI();

		try {
			objscanner = new Scanner(System.in);

			System.out.print(Constants.Choice);
			choiceInput = objscanner.next();

			if (choiceInput.equalsIgnoreCase("P") || choiceInput.equalsIgnoreCase("X")) {
				objDisplayUI.displayRowsPerPage(choiceInput);
			} else {
				System.out.println(Constants.InvalidChoice);
				checkinputSecond();
			}

		} finally {
			objscanner = null;
			choiceInput = null;
		}
	}

	/**
	 * this method is used to display the results from database by entering page
	 * number
	 *
	 */

	public void dispalysRecords(Connection objConnection, int pageNo) {
		int totalPage = 0;
		int totalRows = 0;

		try {
			objstatement = objConnection.createStatement();
			// fire query and store result in resultSet
			// for formatting of the Headers

			if ((pageNo == 0)) {
				System.out.println(Constants.PageNoZero);
			} else {
				int startPage = 5 * pageNo - 5;

				ResultSet objResultSet = objstatement.executeQuery(Constants.strQuery_Ass2_1);
				objResultSet.last();
				totalRows = objResultSet.getRow();
				// calculating totalPages based on no of rows
				totalPage = totalRows / rowsPerPage;

				System.out.println(Constants.TotalPages + totalPage);

				objResultSet.absolute(startPage);
				if (pageNo <= totalPage) {
					System.out.printf("%5s %15s %30s %40s %45s \n", "EmployeeID", "EmployeeName", "Title",
							"FullAddress", "HomePhone");

					System.out.println(Constants.Seperator);
					// loop will execute when all rows print
					int count = 0;
					while (objResultSet.next()) {
						count++;
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

						// Printing data
						System.out.format("%-20s %-30s %-30s %-50s %-25s \n", employeeId, name, title, address,
								homePhone);
						if (count == 5) {
							break;
						}
						counter++;
					}
					System.out.println(Constants.Seperator);

					if (counter == 0) {
						System.out.println(Constants.NoRecord);
						return;
					}

				} else {
					System.out.println(Constants.NoRecord);
				}
			}

		} catch (SQLException e) {

		}

	}

	/**
	 * this method is used to display the results when pressing next and
	 * previous
	 */

	public void display(List<EmpData> listone) {
		EmpData objEmpData = null;
		ListIterator<EmpData> objListIterator = null;
		try {
			objListIterator = listone.listIterator();
			System.out.printf("%5s %15s %30s %40s %45s \n", "EmployeeID", "EmployeeName", "Title", "FullAddress",
					"HomePhone");
			System.out.println(Constants.Seperator);
			while (objListIterator.hasNext()) {
				objEmpData = objListIterator.next();

				employeeId = objEmpData.getemployeeID();
				name = objEmpData.getname();
				title = objEmpData.gettitle();
				address = objEmpData.getaddress();
				homePhone = objEmpData.gethomephone();
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
				System.out.format("%-20s %-30s %-30s %-50s %-25s \n", employeeId, name, title, address, homePhone);

				objListIterator.remove();
			}

			System.out.println(Constants.Seperator);

		} finally {
			objEmpData = null;
			objListIterator = null;
		}
	}

}