package com.uks.Jyoti.core.day3.assignment2;

import java.util.StringTokenizer;

/**
 * Class Name:TestStringTokenizer Description: Create tokens for input string
 *
 * @author Jyoti
 * @Created date [20-06-2019]
 *
 */
public class TestStringTokenizer {

	/**
	 * Method: StringTokens Description: Print the string tokens separately
	 * split by comma
	 *
	 * @param arguments
	 */
	public void StringTokens(String[] arguments) {
		String delims = ",";
		int i;
		StringTokenizer objTokenizer = null;
		try {
			System.out.println("Comma Seperated tokens");
			if (arguments.length != 0) {
				for (i = 0; i < arguments.length; i++) {
					objTokenizer = new StringTokenizer(arguments[i], delims);

					while (objTokenizer.hasMoreElements()) {
						System.out.println(objTokenizer.nextElement());
					}

				}
			} else {
				System.out.println("Please enter string");
			}
		} catch (Exception obj) {
			obj.printStackTrace();
		} finally {
			objTokenizer = null;
		}
	}

}
