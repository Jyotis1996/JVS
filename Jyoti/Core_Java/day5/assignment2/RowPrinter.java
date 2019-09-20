package com.uks.jvs.jyoti.day5.assignment2;

import java.io.IOException;
import java.util.ArrayList;

import com.uks.jvs.jyoti.day5.assignment1.BaseEmployee;
import com.uks.jvs.jyoti.day5.assignment1.GeneralEmployee;

/**
 * Class Name : RowPrinter description - class get all employee file and print
 * details
 *
 * @author Jyoti [28-06-2019]
 */
public class RowPrinter {

	/**
	 * Method Name : showDetails description - print all employee details in
	 * normal form
	 *
	 * @param arraylist
	 * @throws NumberFormatException
	 * @throws IOException
	 */

	public void showDetails(ArrayList<BaseEmployee> arraylist) throws NumberFormatException, IOException {
		int count = 1;
		GeneralEmployee generalEmployee = null;
		try {
			if (arraylist.size() == 0) {
				System.out.println("Data Not Found...!!!");
			} else {
				System.out.println("File Contents");
				// read data from arraylist and display on console
				for (int i = 0; i < arraylist.size(); i++) {
					generalEmployee = (GeneralEmployee) arraylist.get(i);
					System.out.println("Employee [" + count + "] " + generalEmployee.getEmpCode());
					count++;
					System.out.println("Name " + generalEmployee.getFirstName() + " " + generalEmployee.getLastName());
					System.out.println("Employee type " + generalEmployee.getEmpType());
					System.out.println("Salary "
							+ (generalEmployee.getBasicSalary() + (generalEmployee.getBasicSalary() * 125) / 1000));
					System.out.println("--------------------------------------------");
				}
			}
		}
		// free the memory of object
		finally {
			generalEmployee = null;
		}
	}
}
