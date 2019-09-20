package com.uks.jvs.jyoti.day5.assignment4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Class Name:EmployeeDetails Description:Implementation of Comparator
 *
 * @author Jyoti [27-06-2019]
 */
public class EmployeeDetails {
	String[] words;// public variable

	/**
	 * Method:getLastName Description:perform Sorting and Searching on records
	 *
	 */
	public void getLastName(String[] Lastname) throws IOException, NullPointerException {
		String strSortParameter;
		final String DELIMITER = ",";
		EmployeeProperties objProperties = null;
		BufferedReader objReader = null;
		List<EmployeeProperties> objArrayList;

		try {
			objArrayList = new ArrayList<EmployeeProperties>();
			String line = "";
			String filePath = "D:\\JVS_WS\\coreJava\\src\\com\\uks\\jvs\\jyoti\\day5\\assignment4\\Employee.csv";
			objReader = new BufferedReader(new FileReader(filePath));
			System.out.println("EmpCode FirstName LastName EmpType EmpSalary");
			while ((line = objReader.readLine()) != null) {
				objProperties = new EmployeeProperties();
				words = line.split(DELIMITER);
				this.printEmployeeDetails();// print Details in Tabular form
				// Searching
				if (Lastname[0].equals(words[2])) {
					objProperties.setEmpCode(Integer.parseInt(words[0]));
					objProperties.setFirstName(words[1]);
					objProperties.setLastName(words[2]);
					objProperties.setEmpType(words[3]);
					objProperties.setBasicSalary(Long.parseLong(words[4]));
					objArrayList.add(objProperties);
				}
			}
			// Sorting
			System.out.println(
					"Enter last name and sorting type:empCode,empType,firstName,lastName,empSalary in command line \n by default list will be sorted by empCode");
			if (Lastname.length == 1) {
				strSortParameter = " ";
			} else {
				strSortParameter = Lastname[1];
			}
			if (objArrayList.size() != 0) {
				switch (strSortParameter) {
				case "empCode":
					System.out.println("Search By:" + Lastname[0] + "\n" + "Sort By:" + Lastname[1]);
					Collections.sort(objArrayList, new SortEmpCode());// Comparator
					for (EmployeeProperties objemp : objArrayList) {
						System.out.println(objemp.getEmpCode() + " " + objemp.getFirstName() + " "
								+ objemp.getLastName() + " " + objemp.getEmpType() + " "
								+ (objemp.getBasicSalary() + (((objemp.getBasicSalary()) * 12.5) / 100)) + "\n");
					}
					break;
				case "empType":
					System.out.println("Search By:" + Lastname[0] + "\n" + "Sort By:" + Lastname[1]);
					Collections.sort(objArrayList, new SortEmpType());// Comparator
					for (EmployeeProperties objemp : objArrayList) {
						System.out.println(objemp.getEmpCode() + " " + objemp.getFirstName() + " "
								+ objemp.getLastName() + " " + objemp.getEmpType() + " "
								+ (objemp.getBasicSalary() + (((objemp.getBasicSalary()) * 12.5) / 100)) + "\n");
					}
					break;
				case "firstName":
					System.out.println("Search By:" + Lastname[0] + "\n" + "Sort By:" + Lastname[1]);
					Collections.sort(objArrayList, new SortEmpFirstName());// Comparator
					for (EmployeeProperties objemp : objArrayList) {
						System.out.println(objemp.getEmpCode() + " " + objemp.getFirstName() + " "
								+ objemp.getLastName() + " " + objemp.getEmpType() + " "
								+ (objemp.getBasicSalary() + (((objemp.getBasicSalary()) * 12.5) / 100)) + "\n");
					}
					break;
				case "lastName":
					System.out.println("Search By:" + Lastname[0] + "\n" + "Sort By:" + Lastname[1]);
					Collections.sort(objArrayList, new SortEmpLastName());// Comparator
					for (EmployeeProperties objemp : objArrayList) {
						System.out.println(objemp.getEmpCode() + " " + objemp.getFirstName() + " "
								+ objemp.getLastName() + " " + objemp.getEmpType() + " "
								+ (objemp.getBasicSalary() + (((objemp.getBasicSalary()) * 12.5) / 100)) + "\n");
					}
					break;
				case "empSalary":
					System.out.println("Search By:" + Lastname[0] + "\n" + "Sort By:" + Lastname[1]);
					Collections.sort(objArrayList, new SortEmpSalary());// Comparator
					for (EmployeeProperties objemp : objArrayList) {
						System.out.println(objemp.getEmpCode() + " " + objemp.getFirstName() + " "
								+ objemp.getLastName() + " " + objemp.getEmpType() + " "
								+ (objemp.getBasicSalary() + (((objemp.getBasicSalary()) * 12.5) / 100)) + "\n");
					}
					break;
				default:
					System.out.println("Search By:" + Lastname[0] + "\n" + "Sort By: empCode");
					Collections.sort(objArrayList, new SortEmpCode());// Comparator
					for (EmployeeProperties objemp : objArrayList) {
						System.out.println(objemp.getEmpCode() + " " + objemp.getFirstName() + " "
								+ objemp.getLastName() + " " + objemp.getEmpType() + " "
								+ (objemp.getBasicSalary() + (((objemp.getBasicSalary()) * 12.5) / 100)) + "\n");
					}
					break;
				}
			} else {
				System.out.println("Search By:" + Lastname[0]);
				System.out.println("No record ");// No Search Records
			}
		} finally {
			objReader.close();
			objArrayList = null;
			objProperties = null;
		}
	}

	/**
	 * Method Name:printEmployeeDetails Description:Print all the Records in
	 * Tabular Form
	 */

	public void printEmployeeDetails() {
		EmployeeProperties objProperties = null;
		ArrayList<EmployeeProperties> objArrayList;
		try {
			objArrayList = new ArrayList<EmployeeProperties>();
			objProperties = new EmployeeProperties();
			objProperties.setEmpCode(Integer.parseInt(words[0]));
			objProperties.setFirstName(words[1]);
			objProperties.setLastName(words[2]);
			objProperties.setEmpType(words[3]);
			objProperties.setBasicSalary(Long.parseLong(words[4]));
			objArrayList.add(objProperties);
			for (int i = 0; i < (objArrayList.size()); i++) {
				System.out.println(objArrayList.get(i).getEmpCode() + "\t" + objArrayList.get(i).getFirstName() + "\t"
						+ objArrayList.get(i).getLastName() + "\t" + objArrayList.get(i).getEmpType() + "\t"
						+ (objArrayList.get(i).getBasicSalary()
								+ (((objArrayList.get(i).getBasicSalary()) * 12.5) / 100)));
			}
		} finally {
			objArrayList = null;
			objProperties = null;
		}
	}
}

/**
 * Class Name:SortEmpCode Description:Comparator class for Sorted By empCode
 */
class SortEmpCode implements Comparator<EmployeeProperties> {
	@Override
	/**
	 * compare method of Comparator Interface
	 */
	public int compare(EmployeeProperties arg0, EmployeeProperties arg1) {
		if (arg0.getEmpCode() > arg1.getEmpCode()) {
			return 1;
		} else {
			return -1;
		}
	}
}

/**
 * Class Name:SortEmpFirstName Description:Comparator class for Sorted By
 * firstName
 */
class SortEmpFirstName implements Comparator<EmployeeProperties> {
	@Override
	/**
	 * compare method of Comparator Interface
	 */
	public int compare(EmployeeProperties arg0, EmployeeProperties arg1) {
		return arg0.getFirstName().compareToIgnoreCase(arg1.getFirstName());
	}
}

/**
 * Class Name: SortEmpLastName Description:Comparator class for Sorted By
 * lastName
 */
class SortEmpLastName implements Comparator<EmployeeProperties> {
	@Override
	/**
	 * compare method of Comparator Interface
	 */
	public int compare(EmployeeProperties arg0, EmployeeProperties arg1) {
		return arg0.getLastName().compareToIgnoreCase(arg1.getLastName());
	}
}

/**
 * Class Name: SortEmpType Description:Comparator class for Sorted By empType
 */
class SortEmpType implements Comparator<EmployeeProperties> {
	@Override
	/**
	 * compare method of Comparator Interface
	 */
	public int compare(EmployeeProperties arg0, EmployeeProperties arg1) {
		return arg0.getEmpType().compareToIgnoreCase(arg1.getEmpType());
	}
}

/**
 * Class Name: SortEmpSalary Description:Comparator class for Sorted By
 * empSalary
 */
class SortEmpSalary implements Comparator<EmployeeProperties> {

	@Override
	/**
	 * compare method of Comparator Interface
	 */
	public int compare(EmployeeProperties arg0, EmployeeProperties arg1) {
		if (arg0.getBasicSalary() > arg1.getBasicSalary()) {
			return 1;
		} else {
			return -1;
		}
	}
}
