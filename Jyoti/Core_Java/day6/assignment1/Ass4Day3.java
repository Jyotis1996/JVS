package com.uks.jvs.jyoti.day6.assignment1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Class Name:DateDifference Description:Find difference between two dates in
 * form of days
 *
 * @author Jyoti [27-06-2019]
 */
public class Ass4Day3 {
	/**
	 * Class Name:DateDifference Description:Find difference between two dates
	 * in form of days
	 *
	 * @author Jyoti [27-06-2019]
	 */

	public void CountDifference(String[] argument) throws ParseException {
		String FirstDate;
		String SecondDate;
		long difference;
		Calendar objCalendar = null;
		SimpleDateFormat objDateFormat = null;
		try {
			objDateFormat = new SimpleDateFormat("dd/mm/yyyy");
			objCalendar = Calendar.getInstance();
			if ((argument.length != 0) && (argument.length == 2)) {
				FirstDate = argument[0];
				SecondDate = argument[1];
				objDateFormat.setLenient(false);
				objDateFormat.parse(FirstDate);
				objDateFormat.parse(SecondDate);

				if (FirstDate.length() == 10 && SecondDate.length() == 10) {
					objCalendar.set(Calendar.DAY_OF_MONTH, (Integer.parseInt(FirstDate.substring(1, 2))));
					objCalendar.set(Calendar.MONTH, (Integer.parseInt(FirstDate.substring(4, 5))));
					objCalendar.set(Calendar.YEAR, (Integer.parseInt(FirstDate.substring(7, 10))));
					Date firstdate = objCalendar.getTime();

					objCalendar.set(Calendar.DAY_OF_MONTH, (Integer.parseInt(SecondDate.substring(1, 2))));
					objCalendar.set(Calendar.MONTH, (Integer.parseInt(SecondDate.substring(4, 5))));
					objCalendar.set(Calendar.YEAR, (Integer.parseInt(SecondDate.substring(7, 10))));
					Date seconddate = objCalendar.getTime();

					if (firstdate.getTime() <= seconddate.getTime()) {
						difference = seconddate.getTime() - firstdate.getTime();
						System.out.println("Duration [in Days]" + difference / 1000 / 60 / 60 / 24);
					} else {
						System.out.println("Enter Second date as future date");
					}
				}
			} else {
				System.out.println("Please Enter Arguments");
			}
		} finally {
			objDateFormat = null;
			objCalendar = null;
		}

	}
}
