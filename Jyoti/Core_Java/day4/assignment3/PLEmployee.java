package com.uks.jvs.jyoti.day4.assignment3;

/**
 * Class Name: PLEmployee Description: Child class of BaseEmployee class
 *
 * @author Jyoti [24-06-2019]
 *
 */
public class PLEmployee extends BaseEmployee {
	private long mobileNumber;

	public PLEmployee(String PLFname, String PLLname, long PLSalary, long empMobileNo) {
		super(PLFname, PLLname, "PL", PLSalary);
		this.firstName = PLFname;
		this.lastName = PLLname;
		this.empType = "PL";
		this.basicSalary = PLSalary;
		this.mobileNumber = empMobileNo;
	}

	/**
	 * Method Name:printDetails() Description:Print the details of employee
	 */
	public void printDetails() {
		try {
			System.out.println("ProjectLeader Details:");
			System.out.println("Name : " + firstName + " " + lastName);
			System.out.println("Employee Type: " + empType);
			System.out.println("Salary: " + basicSalary);
			System.out.println("Mobile Number: " + mobileNumber);
		} finally {
		}
	}

	/**
	 * Method Name:doWork() Description:Body part of abstract method and call
	 * other methods
	 */
	void doWork() {
		try {
			System.out.println("Portfolios :");
			this.assignTaskToJunior();
			this.collectReportFromJunior();
			this.reportToSenior();
		} finally {
		}
	}

	/**
	 * Method Name:assignTaskToJunior() Description:Print task of Project Leader
	 */
	void assignTaskToJunior() {
		try {
			System.out.println("Assign tasks to junior");
		} finally {
		}
	}

	/**
	 * Method Name:collectReportFromJunior() Description:Print task of Project
	 * Leader
	 */

	void collectReportFromJunior() {
		try {
			System.out.println("Collect Report from junior");
		} finally {
		}
	}

	/**
	 * Method Name:reportToSenior() Description:Print task of Project Leader
	 */
	void reportToSenior() {
		try {
			System.out.println("Report to senior");
		} finally {
		}
	}

}
