package com.uks.Jyoti.core.day3.assignment6;

/**
 * Class Name:FormattedNumber Description:Number Formatting
 *
 * @author Jyoti
 * @created date [21-06-2019]
 */

public class FormattedNumber {
	/**
	 * Method Name:doNumberFormat Description:Format the entered number
	 *
	 * @param argument
	 * @throws NumberFormatException
	 */
	public void doNumberFormat(String[] argument) throws NumberFormatException {
		float inputnumber;
		try {
			if (argument.length != 0 && argument.length == 2) {
				inputnumber = Float.parseFloat(argument[1]);
				System.out.println("Input Number:" + inputnumber);
				switch (argument[0]) {
				case "integer":
					System.out.println("formatted int number is : " + (int) inputnumber);
					break;

				case "float":
					System.out.println("formatted float number is : " + (float) inputnumber);
					break;

				case "double":
					System.out.println("formatted double number is : " + (double) inputnumber);
					break;

				case "long":
					System.out.println("formatted long number is : " + (long) inputnumber);

				default:
					System.out.println("Entered number is invalid");
				}
			} else {
				System.out.println("Entered argument is inavlid");
			}
		} catch (NumberFormatException ex) {
			ex.printStackTrace();
		}
	}

	public static void main(String[] args) {
		FormattedNumber objNumber = null;
		try {
			objNumber = new FormattedNumber();
			objNumber.doNumberFormat(args);

		} catch (NumberFormatException ex) {
			System.out.println("Enter valid input");
		} finally {
			objNumber = null;
		}
	}

}
