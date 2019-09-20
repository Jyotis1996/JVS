
package com.uks.jvs.Jyoti.Day1.Assignment3;

/**
 * Class Name:TableRowPrinterMain Description:Main method class to call
 * displayRecords method of TableRowPrinter class
 *
 * @author Jyoti [25/07/2019]
 *
 */
public class TableRowPrinterMain {

	public static void main(String[] args) throws Exception {
		TableRowPrinter objTable = null;
		try {
			objTable = new TableRowPrinter();
			// displayRecords() method is called from TableRowPrinter Class
			objTable.displayRecords();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			objTable = null;
		}

	}
}
