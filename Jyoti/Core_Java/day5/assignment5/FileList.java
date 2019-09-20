package com.uks.jvs.jyoti.day5.assignment5;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Class Name:FileList Description:Main Method Class to get the parameters using
 * Scanner and Filter Files
 *
 * @author Jyoti [26-06-2019]
 */
public class FileList {
	public static void main(String[] args) throws IOException, NullPointerException, InputMismatchException {
		String Path;
		String extension;
		int recursion;
		DirectoryListing objListing;
		Scanner objScanner;
		objScanner = new Scanner(System.in);
		try {
			objListing = new DirectoryListing();
			System.out.println("Enter file/directory path");
			Path = objScanner.next();
			System.out.println("Enter file extension");
			extension = objScanner.next();
			System.out.println("Enter option (1/0) ");
			recursion = objScanner.nextInt();
			switch (recursion) {
			case 1:
				objListing.getFilePath(Path, extension, recursion);
				objListing.recursiveMethod(Path, extension, recursion);
				break;
			case 0:
				objListing.getFilePath(Path, extension, recursion);
				break;
			default:
				System.out.println("Invalid Arument");
				break;
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (NullPointerException ex) {
			System.out.println("Cannot read system folders");
		} catch (InputMismatchException ex) {
			System.out.println("Invalid argument");
		} finally {
			objScanner.close();
			objListing = null;
			objScanner = null;
		}
	}
}
