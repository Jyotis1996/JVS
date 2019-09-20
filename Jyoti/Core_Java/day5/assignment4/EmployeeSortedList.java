package com.uks.jvs.jyoti.day5.assignment4;

import java.io.IOException;

/**
 * Class Name:EmployeeSortedList Description:Main Method Class for
 * EmployeeDetails
 *
 * @author Jyoti [27-06-2019]
 */
public class EmployeeSortedList {
	public static void main(String[] args) throws IOException, NullPointerException {
		EmployeeDetails objEmployee = null;

		try {
			if (args.length <= 2 && args.length != 0) {
				objEmployee = new EmployeeDetails();
				objEmployee.getLastName(args);// method call
			} else {
				System.out.println("Invalid Argument");// Null
			}
		} catch (IOException ex) {
			System.out.println("Invalid File name");
		} catch (NullPointerException e) {
			System.out.println("File doesnt exist");
		} finally {
			objEmployee = null;
		}
	}
}
