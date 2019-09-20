package com.uks.jvs.jyoti.day5.assignment1;

/**
 * Class Name : BaseEmployee description - class BaseEmployee has some
 * properties of basic employee and methods to get and set values
 *
 * @author Jyoti [ 28-06-2019 ]
 */
public class BaseEmployee {
	private String empCode;
	private String firstName;
	private String lastName;
	private String empType;
	private double basicSalary;

	/**
	 * description - constructor
	 *
	 * @param empCode
	 * @param firstName
	 * @param lastName
	 * @param empType
	 * @param basicSalary
	 */
	public BaseEmployee(String empCode, String firstName, String lastName, String empType, double basicSalary) {
		this.empCode = empCode;
		this.firstName = firstName;
		this.lastName = lastName;
		this.empType = empType;
		this.basicSalary = basicSalary;

	}

	/**
	 * description - get empCode
	 *
	 * @return empCode
	 */
	public String getEmpCode() {
		return empCode;
	}

	/**
	 * description - set empCode
	 */
	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}

	/**
	 * description - get empFirstName
	 *
	 * @return firstName
	 */

	public String getFirstName() {
		return firstName;
	}

	/**
	 * description - set empFirstName
	 */

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * description - set empLastName
	 *
	 * @return lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * description - get empLastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * description - get empType
	 *
	 * @return empType
	 */
	public String getEmpType() {
		return empType;
	}

	/**
	 * description - set empType
	 */
	public void setEmpType(String empType) {
		this.empType = empType;
	}

	/**
	 * description - get empBasicSalary
	 *
	 * @return basicSalary
	 */
	public double getBasicSalary() {
		return basicSalary;
	}

	/**
	 * description - set empBasicSalary
	 */
	public void setBasicSalary(int basicSalary) {
		this.basicSalary = basicSalary;
	}
}
