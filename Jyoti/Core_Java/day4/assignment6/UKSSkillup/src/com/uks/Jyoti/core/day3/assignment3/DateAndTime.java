package com.uks.Jyoti.core.day3.assignment3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Class name: DateAndTime Description: Formatting date & Time
 *
 * @author Jyoti
 * @Created date [21-06-2019]
 */
public class DateAndTime {

	/**
	 * Method Name: ValidateDate Description: Validate and Convert the date
	 * according to given format
	 *
	 * @param argument
	 * @throws ParseException
	 */

	public void ValidateDate(String[] argument) throws ParseException {
		SimpleDateFormat objDateFormat = null;
		SimpleDateFormat objSimpleDateFormat = null;
		Date formateddate = null;
		try {
			objDateFormat = new SimpleDateFormat(argument[0]);
			Date today = Calendar.getInstance().getTime();
			switch (argument.length) {
			case 0:
				System.out.println("Please Enter Input");
				break;

			case 1:
				System.out.println("Date Format" + argument[0]);
				System.out.println("Date:" + objDateFormat.format(today));
				break;

			case 2:
				objSimpleDateFormat = new SimpleDateFormat("YYYY/MM/DD");
				objSimpleDateFormat.setLenient(false);
				objSimpleDateFormat.parse(argument[1]);
				System.out.println("Date Format" + argument[0]);
				System.out.println("Date:" + objDateFormat.format(formateddate));
				break;

			default:
				System.out.println("Invalid Argument");
			}
		} catch (Exception obj) {

			System.out.println("Please Enter arguments");
		} finally {
			objDateFormat = null;
			objSimpleDateFormat = null;
			formateddate = null;
		}
	}
}
