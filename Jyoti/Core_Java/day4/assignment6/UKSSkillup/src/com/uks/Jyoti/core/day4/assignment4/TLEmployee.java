package com.uks.Jyoti.core.day4.assignment4;

/**
 * Class Name:TLEmployee Description: Child class of PLEmployee
 *
 * @author Jyoti [24-06-2019]
 *
 */
public class TLEmployee extends PLEmployee {

	public TLEmployee(String TLFname, String TLLname, long TLSalary, long tlempMobileNo) {
		super(TLFname, TLLname, TLSalary, tlempMobileNo);
		this.firstName = TLFname;
		this.lastName = TLLname;
		this.empType = "TL";
		this.basicSalary = TLSalary;
		this.mobileNumber = tlempMobileNo;
	}

	/**
	 * Method Name:doWork() Description:Body part of abstract method and call
	 * other methods and Interface methods
	 */
	public void doWork() {
		try {
			System.out.println("Portfolios :");
			this.assignTaskToJunior();
			this.collectReportFromJunior();
		} finally {
		}
	}

	/**
	 * Method Name:assignTaskToJunior() Description:Print task of Project Leader
	 */
	void assignTaskToJunior() {
		try {
			System.out.println("Assign tasks to junior [TLEmployee]");
		} finally {
		}
	}

	/**
	 * Method Name:collectReportFromJunior() Description:Print task of Project
	 * Leader
	 */

	void collectReportFromJunior() {
		try {
			System.out.println("Collect Report from junior [TLEmployee]");
		} finally {
		}
	}

	/**
	 * Method Name:reportToSenior() Description:Interface method to Print task
	 */
	public void reportToSenior() {
		try {
			System.out.println("Report to senior [TLEmployee]");
		} finally {
		}
	}

}
