package com.uks.jvs.jyoti.test.Assignment1;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import java.util.Scanner;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

/**
 * Class Name : ReadExcelDemo Description : Read the contents of excel file and
 * print on terminal
 *
 * @author Jyoti [04-07-2019]
 *
 */
public class ReadExcelDemo {
	/**
	 * Method Name:readExcel Description : method to read the contents of excel
	 * file
	 */
	public void readExcel() {

		try {
			@SuppressWarnings("resource")
			Scanner objScanner = new Scanner(System.in);
			System.out.println("Enter path of excel file");
			String excelPath = objScanner.nextLine();
			FileInputStream fileInputStream = new FileInputStream(new File(excelPath));

			// Create Workbook instance holding .xls file
			HSSFWorkbook workbook = new HSSFWorkbook(fileInputStream);

			// Get the first worksheet
			HSSFSheet sheet = workbook.getSheetAt(0);

			// Iterate through each rows
			Iterator<Row> rowIterator = sheet.iterator();

			while (rowIterator.hasNext()) {
				// Get Each Row
				Row row = rowIterator.next();

				// Iterating through Each column of Each Row
				Iterator<Cell> cellIterator = row.cellIterator();

				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();

					// Checking the cell format
					switch (cell.getCellType()) {
					case Cell.CELL_TYPE_NUMERIC:
						System.out.print(cell.getNumericCellValue() + "\t");
						break;
					case Cell.CELL_TYPE_STRING:
						System.out.print(cell.getStringCellValue() + "\t");
						break;
					case Cell.CELL_TYPE_BOOLEAN:
						System.out.print(cell.getBooleanCellValue() + "\t");
						break;
					}
				}
				System.out.println("");
			}

		} catch (Exception ie) {
			System.out.println("File not found please enter correct path");
		}
	}
}
