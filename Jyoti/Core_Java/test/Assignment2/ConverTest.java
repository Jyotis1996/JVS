package com.uks.jvs.jyoti.test.Assignment2;

import java.util.Scanner;

/**
 * Class Name :ConvertTest Description : Main class to implement integer to
 * binary conversion
 *
 * @author Jyoti [04-07-2019]
 *
 */
public class ConverTest {

	public static void main(String[] args) {
		Convert objConvert = null;
		Scanner objScanner = null;
		int num;
		try {
			objConvert = new Convert();
			objScanner = new Scanner(System.in);
			// get input from user to convert number
			System.out.println("Enter number to be converted to binary");
			num = objScanner.nextInt();

			// to check whether number is three digit or not
			if (num > 0 && num <= 999) {
				System.out.println("Binary converted : ");
				objConvert.binary(num);
			} else {
				System.out.println("Please enter number upto three digit only");
			}
		} catch (Exception e) {
			System.out.println("Please enter integer number only"); // exception
																	// occurs if
																	// any other
																	// input is
																	// given
		} finally {
			objConvert = null;
			objScanner = null;
		}

	}

}
