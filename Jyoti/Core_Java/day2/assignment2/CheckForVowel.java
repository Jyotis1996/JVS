package com.uks.jvs.jyoti.day2.assignment2;

/**
 * Class Name:CheckForVowel Description:Create object of VowelConsonant class
 *
 * @author Jyoti
 * @Created date [19-06-2019]
 */

public class CheckForVowel {

	public static void main(String[] args) {
		VowelConsonant objVowelConsonant = null;
		try {
			String s = args[0];
			char ch = s.charAt(0);

			objVowelConsonant = new VowelConsonant(); // Object Initialization
			objVowelConsonant.checkChar(ch); // checkChar method is called
		} catch (ArrayIndexOutOfBoundsException objArrayIndexOutOfBoundsException) {
			// Exception is handled here
			System.out.println("Enter proper input");

		} finally {

			objVowelConsonant = null;

		}

	}

}
