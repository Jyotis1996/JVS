package com.uks.Jyoti.core.day1.assignment4;

/*
 * Class Name:Multicommandline
 * Description:get the multiple command line arguments and perform operation
 * Created:Jyoti [19-06-2019]
 */
public class Multicommandline {
	/*
	 * Method Name:doOperation() Description:Arguments in Array Pass as
	 * parameter and Perform Addition & lower case operation
	 * Created:Jyoti[20-06-2019]
	 */
	public void doOperation(String[] s) {
		if (s[0].equals("1")) {
			int result = 0;
			for (int i = 0; i < s.length; i++) {
				//if-else condition to check weather entered value is string or integer
				if (s[i].matches("[0-9]+")) {
					result = result + Integer.parseInt(s[i]);
				} else {
					System.out.println("string can not be added to int ");
				}
			}
			System.out.println("Addition is " + result);
		} else if (s[0].equals("2")) {
			for (int i = 1; i < s.length; i++) {
				//if-else condition to check weather entered value is string or integer
				if (s[i].matches("[0-9]+")) {
					System.out.println("No can Not be converted to Lower Case ");
				} else {
					System.out.println(s[i].toLowerCase());
				}
			}
		}

	}

}
