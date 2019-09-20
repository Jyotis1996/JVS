package com.uks.Jyoti.core.day2.assignment3;

/**
 * Class Name:StringOperation Description:Apply string manipulation and Regular
 * expression on single word or multiple
 *
 * @author Jyoti
 * @Created date [19-06-2019]
 */

public class StringOperation {

	/**
	 * Method Name:doOperationWithRegEx Description:String Manipulation with
	 * regex
	 *
	 * @param args
	 */

	public void doOperationWithRegEx(String[] args) {
		int upperCase = 0, lowerCase = 0, digit = 0; // integer variable
														// declared
		char ch = 0;
		if (args[0].equals("1")) // pass 1 from command line
		{

			String string = args[1];

			for (int i = string.length() - 1; i >= 0; i--) {
				System.out.print(string.charAt(i)); // here print the reverse
													// string
			}

		} else if (args[0].equals("2")) // pass 2 from command line
		{
			for (int i = 1; i < args.length; i++) {
				String str = args[i];
				for (int j = 0; j < str.length(); j++) {
					ch = str.charAt(j);
					if (Character.toString(ch).matches("[a-z]+")) {
						// if lower case letter found increment
						// the lowerCas pointer
						lowerCase++;
					} else if (Character.toString(ch).matches("[A-Z]+")) {
						// if upper case letter found increment
						// the upperCase pointer
						upperCase++;
					} else if (Character.toString(ch).matches("[0-9]+")) {
						// If digit is found increment the digit
						// counter
						digit++;
					}
				}

			}
			System.out.println("--------------------OUTPUT----------------");

			// here displays the actual count of upperCase,lowerCase and digits

			System.out.println("Upper cases=" + upperCase);
			System.out.println("Lower case =" + lowerCase);
			System.out.println("Digits=" + digit);
		}
	}

}
