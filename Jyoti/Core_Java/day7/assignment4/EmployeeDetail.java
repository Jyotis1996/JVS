package com.uks.jvs.jyoti.day7.assignment4;

import java.io.Serializable;

/**
 * Class Name : EmployeeDetail Description -"EmployeeDetail contains vairables
 * for employee
 *
 * @author Jyoti [28-06-2019]
 */

public class EmployeeDetail implements Serializable {

	private static final long serialVersionUID = 1L;
	private String empName;
	private int empAge;
	private int empSalary;

	/**
	 * @return the empName
	 */
	public String getempName() {
		return empName;
	}

	/**
	 * @param empName
	 */
	public void setempName(String empName) {
		this.empName = empName;
	}

	/**
	 * @return the empAge
	 */
	public int getempAge() {
		return empAge;
	}

	/**
	 * @param empAge
	 */
	public void setempAge(int empAge) {
		this.empAge = empAge;
	}

	/**
	 * @return the empSalary
	 */
	public int getempSalary() {
		return empSalary;
	}

	/**
	 * @param empSalary
	 */
	public void setempSalary(int empSalary) {
		this.empSalary = empSalary;
	}

	public EmployeeDetail(String empName, int empAge, int empSalary) {
		try {
			setempName(empName);
			setempAge(empAge);
			setempSalary(empSalary);

		} catch (Exception e) {
			System.out.println("You Enter Wrong Info..Please Enter Valid Information...!!!");
			StoreObject objAddObjects = new StoreObject();
			objAddObjects.getDetails();
		}

	}

}
