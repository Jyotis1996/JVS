package com.uks.jvs.jyoti.day5.assignment3;

import java.io.IOException;

/**
 * Class Name:EmployeeSearch Description:Search the Records with using last name
 * of employee
 *
 * @author Jyoti [27-06-2019]
 */
public class EmployeeSearch {
	public static void main(String[] args) throws IOException, NullPointerException {
		EmployeeDetailsReader objEmployee = null;
		try {
			if (args.length == 1) {
				objEmployee = new EmployeeDetailsReader();
				objEmployee.getLastName(args);// method call
			} else {
				System.out.println("Invalid Argument");// Null
			}

		} catch (IOException ex) {
			System.out.println("File name entered is invalid");
		} catch (NullPointerException e) {
			System.out.println("File does not exist");
		} finally {
			objEmployee = null;
		}
	}
}
