package com.uks.Jyoti.core.day3.assignment7;

/**
 * Class Name:Employee Info Description:Use of inner class and outer class
 *
 * @author Jyoti
 * @created date:[21-06-2019]
 */
public class EmployeeInfo {

	public static void main(String[] args) {

		Employee objEmployee = null;
		try {
			objEmployee = new Employee(args[0]);
			Employee.Salary objEmpSalary = objEmployee.new Salary(Double.parseDouble(args[1]));
			objEmpSalary.printinfo();
		} catch (NumberFormatException ex) {
			System.out.println("Enter Valid input");
		} finally {
			objEmployee = null;
		}
	}

}
