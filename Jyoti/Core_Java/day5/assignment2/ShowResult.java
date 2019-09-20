package com.uks.jvs.jyoti.day5.assignment2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import com.uks.jvs.jyoti.day5.assignment1.BaseEmployee;

/**
 * Class Name : ShowResult description - class is read a file contant and
 * transfer it to another file
 *
 * @author Jyoti [28-06-2019]
 *
 */
public class ShowResult {
	public static void main(String[] ar) throws NumberFormatException, IOException {
		/**
		 * description - read file and trasfer to another file
		 */
		File inputFile = null;
		File inputFile1 = null;
		RowReader objReader = null;
		String inputFilePath = null;
		Scanner sc1 = null;
		;
		ArrayList<BaseEmployee> objBaseEmployees = null;
		RowPrinter objRowPrinter = null;
		try {
			System.out.println("Please Enter Your Input File Path....!!!!");
			sc1 = new Scanner(System.in);
			inputFilePath = sc1.next();
			inputFile1 = new File(inputFilePath);
			System.out.println(inputFile1);
			inputFile = new File(inputFile1.getAbsolutePath());
			// instantiate the objects
			objReader = new RowReader();
			objRowPrinter = new RowPrinter();
			// call showdetails method in order to read data from file and print
			// it on console
			objBaseEmployees = objReader.showDetails(inputFile.toString());
			objRowPrinter.showDetails(objBaseEmployees);
			// call rowTOFileConverter For read file from Source path and then
			// write it into another path file
			RowToFileConverter.rowTOFileConverter(objBaseEmployees, inputFilePath);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			objReader = null;
			objBaseEmployees = null;
		}
	}
}
