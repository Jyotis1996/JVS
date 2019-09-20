package com.uks.jvs.jyoti.day7.assignment3;

import java.util.Scanner;

/**
 * Class Name:ArrayShuffling
 * Description:Shuffling Array Elements
 * @author Jyoti [28-06-2019]
 */
public class ArrayShuffling {
	/**
	 * Main Method:get the Array Elements and pass to other method
	 */
	public static void main(String[] args) {
		String[] InputArray;
		Scanner objScanner;
		ArrayShufflingOperation objOperation;
		try {
			objOperation = new ArrayShufflingOperation();
			objScanner = new Scanner(System.in);
			System.out.println("Enter 20 string elements :");
			InputArray = new String[20];
			for (int i = 0; i < 20; i++) {// for reading array
				InputArray[i] = objScanner.next();
			}
			objOperation.getUserArray(InputArray);// Call Method
			objScanner.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			objOperation = null;
			objScanner = null;
		}
	}
}
