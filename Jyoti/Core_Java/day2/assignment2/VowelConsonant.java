package com.uks.jvs.jyoti.day2.assignment2;

/**
 * Class Name:VowelConsonant Description:Character Manipulation
 *
 * @author Jyoti
 * @Created date [19-06-2019]
 */

public class VowelConsonant {

	/**
	 * Method Name:checkChar Description:To check vowel/consonant and print the
	 * result
	 *
	 * @param ch
	 */

	public void checkChar(char ch) {

		switch (ch) {
		// Used Switch case instead of if-else to check vowel or consonant

		case 'a':
		case 'A':
			System.out.println("Entered Character is Vowel");
			break;

		case 'e':
		case 'E':
			System.out.println("Entered Character is Vowel");
			break;

		case 'i':
		case 'I':
			System.out.println("Entered Character is vowel");
			break;

		case 'o':
		case 'O':
			System.out.println("Entered Character is vowel");
			break;

		case 'u':
		case 'U':
			System.out.println("Entered Character is vowel");
			break;

		default:
			System.out.println("Entered Character is Consonant");

		}
	}
}
