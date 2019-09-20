package com.uks.jvs.jyoti.day4.assignment1;

import com.uks.jvs.jyoti.day4.assignment1.Employee.ProjectLeader;

/**
 * Class Name:Employee Details Description : Class with main method to print
 * employee details
 * 
 * @author Jyoti
 *
 */
public class EmployeeDetails {

	public static void main(String[] args) throws NumberFormatException {
		ProjectLeader objProjectLeader = null;
		int mobileNumber;
		try {
			if (args.length != 0 && ((args.length == 3) || (args.length == 4))) {
				Employee objEmployee = new Employee();
				if ("PL".equals(args[2])) {
					mobileNumber = Integer.parseInt(args[3]);
					objProjectLeader = objEmployee.new ProjectLeader(args[0], args[1], args[2], mobileNumber);
				} else {
					objProjectLeader = objEmployee.new ProjectLeader(args[0], args[1], args[2], 0);
				}
				objProjectLeader.printInfo();
			} else {
				System.out.println("Invalid arguments");
			}

		} catch (NumberFormatException ex) {
			System.out.println("Invalid number");
		} finally {
			objProjectLeader = null;
		}

	}

}
