package com.uks.jvs.jyoti.day6.assignment3;

/**
 * Class Name : InvalidInputException
 * Description : Generate user defined exception when invalid input is given
 * @author Jyoti [01-07-2019]
 *
 */
public class InvalidInputException extends Exception {
	private static final long serialVersionUID = 1L;

	/**
	 * This is userdefined exception
	 *
	 * @param string
	 */
	public InvalidInputException(String string) {
		super(string);
	}
}
