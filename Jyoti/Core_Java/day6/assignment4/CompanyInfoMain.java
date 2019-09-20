package com.uks.jvs.jyoti.day6.assignment4;

import java.util.Scanner;

/**
 * Class Name:ComapanyInfoMain Description:Main Method Class To read from
 * Properties File
 *
 * @author Jyoti [27-06-2019]
 */
public class CompanyInfoMain {
	public static void main(String[] args) {
		Scanner objScanner;
		CompanyInfo objCompanyInfo;
		try {
			objCompanyInfo = new CompanyInfo();
			objScanner = new Scanner(System.in);
			System.out.println("Please choose Between Following:");
			System.out.println("1.Details in Japanese");
			System.out.println("2.Details in English");
			objCompanyInfo.printDetails(objScanner.next());
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			objCompanyInfo = null;
			objScanner = null;
		}
	}
}
