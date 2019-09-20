package com.uks.Jyoti.core.day3.assignment5;

import java.text.ParseException;

/**
 * Class Name:TestDateAdd DFescription:Main method to invoke DateAdd class
 *
 * @author Jyoti [21-06-2019]
 *
 */
public abstract class TestDateAdd {

	public static void main(String[] args) {
		DateAdd objDateAdd = null;
		try {
			objDateAdd = new DateAdd();
			objDateAdd.doAddition(args);
		} catch (ParseException ex) {
			System.out.println("Date entered is not in [yyyy/mm/dd] format");
		} finally {
			objDateAdd = null;
		}

	}

}
