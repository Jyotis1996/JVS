package com.uks.jvs.jyoti.day1.assignment2;

/*
 * Class Name: AccessMod
 * Description: Contains Main Method
 * Created By: Jyoti [19-06-2019]
 */

public class AccessMod {

	// Declaration of variables with different access modifiers in java
	public int intVariable = 15;
	char charVariable = 'A';
	public boolean flag = true;
	private String strvariable = "Access Modifiers";
	protected float floatNumber = 6.1f;
	protected double doubleNumber = 10.10;
	public long longNumber = 111111111;

	/*
	 * Method Name:printProperties
	 * Description:Print all the Variables of AccessMod Class
	 * Created by :Jyoti [20-06-2019]
	 */
	void printProperties() {
		try {
			System.out.println("Value of integer variable:" + intVariable);
			System.out.println("Value of character variable:" + charVariable);
			System.out.println("Value of boolean variable:" + flag);
			System.out.println("Value of string variable:" + strvariable);
			System.out.println("Value of float variable:" + floatNumber);
			System.out.println("Value of double variable:" + doubleNumber);
			System.out.println("Value of long variable:" + longNumber);
		} finally {
			System.out.println("Null");
		}
	}

}
