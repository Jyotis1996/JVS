package com.uks.Jyoti.core.day4.assignment3;

/**
 * Class Name : BaseEmployee Description: Abstract for Employee details
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
	 * Abstract method doWork()
	 */
	abstract void doWork();

	public static void main(String[] args) {
		PLEmployee objEmployee = null;
		try {
			objEmployee = new PLEmployee("Alex", "Richard", 60000, 123456789);
			objEmployee.printDetails();
			objEmployee.doWork();

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			objEmployee = null;
		}
	}
}