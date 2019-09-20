package com.uks.Jyoti.core.day4.assignment4;

/*
 * Interface IWork
 */
interface IWork {
	abstract void doWork();
}

/**
 * Class Name : BaseEmployee Description: Class for employee details
 *
 * @author Jyoti [24-06-2019]
 *
 */
abstract class BaseEmployee {
	protected String firstName;
	protected String lastName;
	protected String empType;
	protected long basicSalary;

	BaseEmployee(String empfirstName, String emplastName, String emp_Type, long empbasicSalary) {
		this.firstName = empfirstName;
		this.lastName = emplastName;
		this.empType = emp_Type;
		this.basicSalary = empbasicSalary;
	}

	/*
	 * Main Method
	 */

	public static void main(String[] args) {
		PLEmployee objPLEmployee = null;
		TLEmployee objTLEmployee = null;
		try {
			objPLEmployee = new PLEmployee("Alex", "Richard", 60000, 1234567890);
			objTLEmployee = new TLEmployee("Demo", "User", 40000, 987654321);
			objPLEmployee.printDetails();
			objPLEmployee.doWork();
			objPLEmployee.reportToSenior();
			System.out.println("************************************************");
			objTLEmployee.printDetails();
			objTLEmployee.doWork();
			objTLEmployee.reportToSenior();

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			objPLEmployee = null;
			objTLEmployee = null;

		}
	}
}