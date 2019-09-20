package com.uks.jvs.jyoti.day5.assignment2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import com.uks.jvs.jyoti.day5.assignment1.BaseEmployee;

/**
 * Class Name - RowToFileConverter description - class read file and store data
 * in arraylist all print data on console as well as another file
 *
 * @author Jyoti [28-06-2019]
 *
 */
public class RowToFileConverter {

	/**
	 * Method Name : rowTOFileConverter
	 *
	 * @param objArrayList
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	@SuppressWarnings("resource")
	public static void rowTOFileConverter(ArrayList<BaseEmployee> objArrayList, String inputFilePath)
			throws IOException {
		// define all variables
		int count1 = 0;
		String outputFilePath = null;
		File outputFile = null;
		FileOutputStream fos = null;
		FileInputStream fis = null;
		File inputFile = null;
		Scanner sc1 = null;
		try {
			inputFile = new File(inputFilePath);
			System.out.println(" Please Enter Your Output File Path....!!!");
			sc1 = new Scanner(System.in);
			outputFilePath = sc1.next();
			// take input from user for a file path
			outputFile = new File(outputFilePath);
			// if file not exist then create a new file
			if (!outputFile.isFile()) {

				outputFile.createNewFile();
			}
			// hard coded file path
			fis = new FileInputStream(inputFile);
			fos = new FileOutputStream(outputFile);
			// read file from source file and store it into destination
			while ((count1 = fis.read()) != -1) {
				fos.write(count1);
			}
			System.out.println("Your File is Successfully Saved...!");
		} finally {
			count1 = 0;
			outputFilePath = null;
			inputFilePath = null;
			outputFile = null;
			fis = null;
			fos = null;
			sc1.close();
		}
	}
}
