package com.uks.jvs.jyoti.day3.assignment1;

/**
 * Class Name:SystemProperties Description:Display the System Details
 *
 * @author Jyoti
 * @Created date [20-06-2019]
 */

public class SystemProperties {

	/**
	 * Method Name:printDetails Description:Print System Properties
	 *
	 * @param argument
	 */

	public void printDetails(String[] argument) {
		SystemProperties objProperties = null;
		try {
			objProperties = new SystemProperties();
			if (argument.length != 0) {
				if (argument.length == 1) {
					switch (argument[0]) {
					case "uname":
						objProperties.getUsername();
						break;

					case "osname":
						objProperties.getOsname();
						break;

					case "udir":
						objProperties.getDirectory();
						break;

					case "all":
						objProperties.getUsername();
						objProperties.getOsname();
						objProperties.getDirectory();
						break;

					default:
						System.out.println("Invalid Argument");
						break;
					}
				} else {
					System.out.println("Enter any one command");
				}
			} else {
				System.out.println("Enter input");
			}
		} catch (Exception obj) {
			obj.printStackTrace();
		} finally {
			objProperties = null;
		}
	}

	/**
	 * Method Name:getUsername Description:Get System property User name
	 */

	public void getUsername() {
		System.out.println("Username :" + System.getProperty("user.name"));
	}

	/**
	 * Method Name:getOsname Description:Get System property OS name
	 */

	public void getOsname() {
		System.out.println("OS name :" + System.getProperty("os.name"));
	}

	/**
	 * Method Name:getDirectory Description:Get System property Current user
	 * directory
	 */

	public void getDirectory() {
		System.out.println("Directory name :" + System.getProperty("user.dir"));
	}

}
