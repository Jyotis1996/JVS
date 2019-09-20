package com.uks.jvs.jyoti.day7.assignment4;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class Name :StoreObject Description - User Can input Employee Details as much
 * As they want
 *
 * @author Jyoti [28-06-2019]
 */
public class StoreObject {

	/**
	 * Method Name : getDetails Description - The Method getDetails take input
	 * how many number of employee details the user want to enter.
	 *
	 * @return objArrayList
	 */
	public ArrayList<EmployeeDetail> getDetails() {
		Scanner objScanner = null;
		ArrayList<EmployeeDetail> objArrayList = null;
		int objVal;
		try {
			objScanner = new Scanner(System.in);
			objArrayList = new ArrayList<>();
			System.out.println("......Serialization and deserialization process started...... \n");
			System.out.println("Enter How many Employee You Want to Add...!!!");
			objVal = objScanner.nextInt();
			for (int i = 1; i <= objVal; i++) {
				System.out.println("Enter Next Employee Detail \n" + "Enter Your First_Name:");
				String empName = objScanner.next();
				System.out.println("Enter Your Age:");
				int age = (objScanner.nextInt());
				System.out.println("Enter Your Basic Salary:");
				int empSalary = (objScanner.nextInt());
				objArrayList.add(new EmployeeDetail(empName, age, empSalary));
				PersistantEmpList objPersistantEmpList = new PersistantEmpList();
				objPersistantEmpList.serializeExec(objArrayList);
			}
		} catch (Exception e) {
			System.out.println("You Enter Wrong Data...! \n You Want to add Employee Detail...??? Y/N ");
			enterInputAgain();
		}
		return objArrayList;
	}

	/**
	 * Method Name - enterInputAgain Description - if Enter Wrong Data the
	 * program will not Stop...!!
	 */
	public void enterInputAgain() {
		@SuppressWarnings("resource")
		Scanner objScanner = new Scanner(System.in);
		String value = objScanner.next();
		System.out.println(value);
		switch (value) {
		case "y":
			getDetails();
			break;
		case "n":
			System.out.println("--------------------Sign Off User!!!-------------");
			break;
		}

	}

}
