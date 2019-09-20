package com.uks.jvs.jyoti.day6.assignment4;

import java.util.ResourceBundle;

/**
 * Class name:CompanyInfo Description:Use of ResourceBundle
 *
 * @author Jyoti [01-07-2019]
 */
public class CompanyInfo {
	/**
	 * Method Name:printDetails Description:fetch the details from property file
	 * & print
	 */
	public void printDetails(String argument) {

		ResourceBundle objResourceBundle;
		try {
			switch (argument) {


			case "1":
				objResourceBundle = ResourceBundle.getBundle("com.uks.jvs.jyoti.day6.assignment4.Message_jp");
				for (String key : objResourceBundle.keySet()) {
					System.out.println(objResourceBundle.getString(key));
				}
				break;
			case "2":
				objResourceBundle = ResourceBundle.getBundle("com.uks.jvs.jyoti.day6.assignment4.Message_en");
				for (String key : objResourceBundle.keySet()) {
					System.out.println(objResourceBundle.getString(key));
				}
				break;
			default:
				System.out.println("Invalid Argument");
				break;
			}
		} finally {
			objResourceBundle = null;
		}
	}
}
