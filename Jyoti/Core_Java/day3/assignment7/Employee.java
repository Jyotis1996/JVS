package com.uks.jvs.jyoti.day3.assignment7;

/**
 * Class Name:Employee Description:Display details of employee
 *
 * @author Jyoti
 * @Created date [21-06-2019]
 */
class Employee {
	private String EmployeeName = null;

	Employee(String Emp_Name) {
		EmployeeName = Emp_Name;
	}

	/**
	 * Class Name:Salary Description:Inner Class of Employee class
	 *
	 * @author Jyoti
	 *
	 */
	class Salary {
		private double hra;
		private double basicsal;
		double TotalSalary;

		Salary(double Emp_Salary) {
			basicsal = Emp_Salary;
		}

		public void printinfo() {
			hra = (basicsal * 12.5) / 100;
			TotalSalary = basicsal + hra;
			System.out.println("Name: " + EmployeeName);
			System.out.println("Basic Salary:" + basicsal);
			System.out.println("HRA:" + hra);
			System.out.println("Total Salary:" + TotalSalary);
		}

	}

}
