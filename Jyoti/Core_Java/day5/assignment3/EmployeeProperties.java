package com.uks.jvs.jyoti.day5.assignment3;

/**
 * Class Name:EmployeeProperties_i Description:Class with Properties
 *
 * @author Jyoti [27-06-2019]
 */
public class EmployeeProperties {
	/*
	 * Various Properties of EmployeeProperties Class
	 */
	private int empCode;
	private String firstName;
	private String lastName;
	private String empType;
	private long basicSalary;

	public int getEmpCode() {
		return empCode;
	}

	public void setEmpCode(int empCode) {
		this.empCode = empCode;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmpType() {
		return empType;
	}

	public void setEmpType(String empType) {
		this.empType = empType;
	}

	public long getBasicSalary() {
		return basicSalary;
	}

	public void setBasicSalary(long basicSalary) {
		this.basicSalary = basicSalary;
	}
}
