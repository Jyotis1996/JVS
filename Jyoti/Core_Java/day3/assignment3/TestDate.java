package com.uks.jvs.jyoti.day3.assignment3;

import java.text.ParseException;

/**
 * Class Name:TestDate Description:Main method class to get date as argument
 *
 * @author Jyoti [21-06-2019]
 *
 */
public class TestDate {

	public static void main(String[] args) {
		DateAndTime objDateAndTime = null;
		try {
			objDateAndTime = new DateAndTime();
			objDateAndTime.ValidateDate(args);
		} catch (ParseException ex) {
			System.out.println("Enter date in valid format");
		} finally {
			objDateAndTime = null;
		}

	}

}
