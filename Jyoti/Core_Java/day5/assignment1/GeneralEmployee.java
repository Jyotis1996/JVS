package com.uks.jvs.jyoti.day5.assignment1;

/**
 * Class Name : GeneralEmployee description - class GeneralEmployee has all
 * properties of basic employee
 *
 * @author Jyoti [28-06-2019]
 */
public class GeneralEmployee extends BaseEmployee {
	/**
	 * @param empCode
	 * @param firstName
	 * @param lastName
	 * @param empType
	 * @param basicSalary
	 */
	public GeneralEmployee(String empCode, String firstName, String lastName, String empType, double basicSalary) {
		super(empCode, firstName, lastName, empType, basicSalary);
	}

}
