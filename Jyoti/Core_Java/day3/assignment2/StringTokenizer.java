package com.uks.jvs.jyoti.day3.assignment2;

/**
 * Class Name: StringTokenizer Description: Print comma separated tokens
 *
 * @author Jyoti
 * @created date [20-06-2019]
 */
public class StringTokenizer {

	public static void main(String[] args) {
		TestStringTokenizer objTokenizer = null;
		try {
			objTokenizer = new TestStringTokenizer();
			objTokenizer.StringTokens(args);
		} catch (Exception obj) {
			obj.printStackTrace();
		} finally {
			objTokenizer = null;
		}

	}

}
