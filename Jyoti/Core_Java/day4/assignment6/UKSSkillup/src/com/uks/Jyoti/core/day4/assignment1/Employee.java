package com.uks.Jyoti.core.day4.assignment1;

/**
 * Class Name: Employee Description: Use concept of inheritance and Employee is
 * super class
 *
 * @author Jyoti [24-06-2019]
 *
 */
public class Employee { // Super Class

	protected String FirstName; // Super class variables
	protected String LastName;
	protected String empType;

	Employee() {
		// Default constructor
	}

	Employee(String Empfirstname, String Emplastname, String Emptype) {
		this.FirstName = Empfirstname;
		this.LastName = Emplastname;
		this.empType = Emptype;
	}

	/**
	 * Class Name: ProjectLeader Description: Subclass of Employee class
	 *
	 * @author Jyoti
	 *
	 */
	public class ProjectLeader extends Employee { // Sub class or Extended class
		private int MobileNumber;

		ProjectLeader(String plfname, String pllname, String emp_type, int empType_MobileNo) {
			super(plfname, pllname, emp_type); // super keyword to refer parent
												// class objects
			this.FirstName = plfname;
			this.LastName = pllname;
			this.empType = emp_type;
			this.MobileNumber = empType_MobileNo;

		}

		/**
		 * Method Name : printInfo() Description : Print the details of both
		 * super and sub class
		 */
		public void printInfo() {
			try {
				if ("PL".equals(empType)) {
					System.out.println("ProjectLeader Details");
					System.out.println("FirstName:" + FirstName);
					System.out.println("LastName:" + LastName);
					System.out.println("Employee Type:" + empType);
					System.out.println("Mobile Number:" + MobileNumber);
				} else {
					System.out.println("Employee Details");
					System.out.println("FirstName:" + FirstName);
					System.out.println("LastName:" + LastName);
					System.out.println("Employee Type:" + empType);
				}
			} finally {

			}
		}
	}
}
