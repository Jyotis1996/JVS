package com.uks.jvs.jyoti.day7.assignment1;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Class Name:FindInFilesMain Description:Main Method Class for Find String in
 * files
 *
 * @author Jyoti [28-06-2019]
 */
public class FindInFilesMain {
	public static void main(String[] args) throws IOException, NoSuchElementException {
		Scanner objScanner;
		String SearchString;
		String pathFile;
		FindInFiles objFindInFiles;
		try {
			objFindInFiles = new FindInFiles();
			objScanner = new Scanner(System.in);
			System.out.println("Enter what to search ");
			SearchString = objScanner.next();
			System.out.println("Enter directory/file path");
			pathFile = objScanner.next();
			objFindInFiles.getInputs(SearchString, pathFile);
			objScanner.close();
		} catch (IOException ex) {
			ex.printStackTrace();

		} catch (NoSuchElementException ex) {
			System.out.println("Invalid Argument");
		} 
	}
}
