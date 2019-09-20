package com.uks.Jyoti.core.day3.assignment1;

/**
 * Class Name:ShowSystemProperties Description:Main method class to print system
 * properties
 *
 * @author Jyoti
 * @Created date [20-06-2019]
 */

public class ShowSystemProperties {

	public static void main(String[] args) {

		SystemProperties objSystemProperties = null;
		try {
			objSystemProperties = new SystemProperties();
			System.out.println("Print Details:");
			objSystemProperties.printDetails(args);

		} catch (Exception obj) {
			obj.printStackTrace();
		} finally {
			objSystemProperties = null;
		}
	}

}
