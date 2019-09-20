package com.uks.jvs.jyoti.day2.assignment4;

/**
 * Class Name:StringOperation Description:String Manipulation operation
 *
 * @author Jyoti
 * @Created date [20-06-19]
 */

public class StringOperation {

	/**
	 * Method Name:doOperation Description:Count UpperCase,LowerCase and Digit
	 *
	 * @param argumentArray
	 * @Created date [20-06-2019]
	 */

	public void doOperation(String[] argumentArray) {
		int i;
		int CountLower = 0;
		int CountUpper = 0;
		int CountDigit = 0;

		try {
			if (argumentArray.length != 0) {
				for (i = 0; i < argumentArray.length; i++) {
					for (char charact : argumentArray[i].toCharArray()) {
						if (Character.isLowerCase(charact)) {
							CountLower = CountLower + 1; // Count LowerCase
						}
						if (Character.isUpperCase(charact)) {
							CountUpper = CountUpper + 1; // Count UpperCase
						}
						if (Character.isDigit(charact)) {
							CountDigit = CountDigit + 1; // Count Digit
						}
					}
				}
				System.out.println(
						"LowerCase = " + CountLower + "\n UpperCase = " + CountUpper + "\n Digit = " + CountDigit);
			} else {
				System.out.println("Please Enter String");
			}
		} catch (Exception obj) {

			obj.printStackTrace();
		}
	}
}
