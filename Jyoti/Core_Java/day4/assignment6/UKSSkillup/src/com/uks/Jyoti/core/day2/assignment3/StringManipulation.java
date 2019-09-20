package com.uks.Jyoti.core.day2.assignment3;

/**
 * Class Name:StringManipulation Description:Main method to call method of
 * StringOperation
 *
 * @author Jyoti
 * @Created date [19-06-2019]
 */

public class StringManipulation {

	public static void main(String[] args) {
		StringOperation objStringOperation = null;
		try {

			objStringOperation = new StringOperation(); // object is created
			objStringOperation.doOperationWithRegEx(args); // function called

		} catch (ArrayIndexOutOfBoundsException objArrayIndexOutOfBoundException) {
			// Exception is catch here

			System.out.println("Enter proper input");
		} finally {
			objStringOperation = null;
		}
	}
}
