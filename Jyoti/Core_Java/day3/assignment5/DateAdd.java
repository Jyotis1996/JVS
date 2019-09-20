package com.uks.jvs.jyoti.day3.assignment5;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class Name:DateAdd Description:Add date to the date given as input
 *
 * @author Jyoti
 * @Created date: [21-06-2019]
 */
public class DateAdd {

	/**
	 * Method Name:doAddition Description:Addition in day,month or year
	 *
	 * @param argument
	 * @throws ParseException
	 */
	public void doAddition(String[] argument) throws ParseException {
		SimpleDateFormat objFormat = null;
		try {
			objFormat = new SimpleDateFormat("yyyy/MM/dd");
			if (argument.length != 0 && argument.length == 3) {
				// if statement to check length of argument is 3 or not
				objFormat.setLenient(false);
				objFormat.parse(argument[0]);
				Calendar objCalendar = Calendar.getInstance();
				System.out.println("Input date:" + objFormat.format(objCalendar.getTime()));
				Pattern objPattern = Pattern.compile("[0-9]");
				Matcher objMatcher = objPattern.matcher(argument[2]);

				if (objMatcher.find()) {
					switch (argument[1]) {
					// Switch case to increment date
					case "Year":
						objCalendar.add(Calendar.YEAR, Integer.parseInt(argument[2]));
						System.out.println("+" + argument[2] + "Year");
						System.out.println("Formatted date:" + objFormat.format(objCalendar.getTime()));
						break;

					case "Month":
						objCalendar.add(Calendar.MONTH, Integer.parseInt(argument[2]));
						System.out.println("+" + argument[2] + "Month");
						System.out.println("Formatted date:" + objFormat.format(objCalendar.getTime()));
						break;

					case "Date":
						objCalendar.add(Calendar.DAY_OF_MONTH, Integer.parseInt(argument[2]));
						System.out.println("+" + argument[2] + "Day");
						System.out.println("Formatted date:" + objFormat.format(objCalendar.getTime()));
						break;

					default:
						System.out.println("Entered date is inavlid it should be in [yyyy/mm/dd] format");
						break;
					}

				} else {
					System.out.println("Invalid Argument");
				}
			}
		} catch (ParseException ex) {
			ex.printStackTrace();
		} finally {
			objFormat = null;
		}

	}
}
