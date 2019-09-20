package com.uks.Jyoti.core.day2.assignment4;

/**
 * Class Name:StringManipulation Description:Main class method to pass command
 * line arguments.
 *
 * @author Jyoti
 * @Created date [20-06-2019]
 */

public class StringManipulation {

	public static void main(String[] args) {
		StringOperation objStringOperation = null;
		try {
			objStringOperation = new StringOperation(); // Object Initialization
			objStringOperation.doOperation(args); // Call Method
		} catch (Exception obj) {
			obj.printStackTrace();
		} finally {
			objStringOperation = null;
		}

	}

}
