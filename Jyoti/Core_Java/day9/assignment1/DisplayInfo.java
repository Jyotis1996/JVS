package com.uks.jvs.jyoti.day9.assignment1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Map.Entry;
import java.util.StringTokenizer;

/**
 * Class Name :DisplayInfo Description : Display Information as per the position
 * of user for eg if user is Employee the he/she can see only own details
 *
 * @author Jyoti [03-07-2019]
 *
 */

public class DisplayInfo extends Thread {
	Scanner objScanner = null;
	String filePath = null;
	String mode = null;
	ThreadGroup objGroup = new ThreadGroup("");

	private static ArrayList<UserInfo> objUserInfoList = new ArrayList<>();
	private static ArrayList<UserLoginInfo> objUserLoginInfoList = new ArrayList<>();
	private static HashMap<Integer, Merged> objHashMap = new HashMap<>();
	private Iterator<Entry<Integer, Merged>> objIterator = null;

	FileInputStream objFileInputStream = null;
	BufferedReader objBufferedReader = null;
	StringTokenizer objStringTokenizer = null;
	Merged objMerged = null;
	UserInfo objInfo = null;

	/**
	 * @description : this constructor gets path and mode from main class and
	 *              assign task according that
	 * @param path
	 * @param nameThreadGroup
	 * @param mode2
	 */
	public DisplayInfo(String path, ThreadGroup nameThreadGroup, String mode2) {

		// setting values
		this.objGroup = nameThreadGroup;
		this.filePath = path;
		this.mode = mode2;

	}

	/**
	 * @description : this method takes userInfo file and set into list
	 * @throws NumberFormatException
	 * @throws IOException
	 * @throws InterruptedException
	 */
	private void userInfo() throws NumberFormatException, IOException, InterruptedException {
		String read = null;
		long number = 0;
		long salary = 0;
		int id = 0;
		String name = null;
		String role = null;
		String address = null;

		try {
			// reading file
			objFileInputStream = new FileInputStream(filePath);
			// reading file using reader
			objBufferedReader = new BufferedReader(new InputStreamReader(objFileInputStream));
			// getting line by line data
			while ((read = objBufferedReader.readLine()) != null) {
				// separating every line by comma
				objStringTokenizer = new StringTokenizer(read, ",");
				// until it has elements
				while (objStringTokenizer.hasMoreElements()) {
					// getting user id
					id = Integer.parseInt(objStringTokenizer.nextToken());
					// getting name
					name = objStringTokenizer.nextToken();
					// getting role
					role = objStringTokenizer.nextToken();
					// getting address
					address = objStringTokenizer.nextToken();
					// getting salary
					salary = Long.parseLong(objStringTokenizer.nextToken());
					salary = salary + (salary * 12) / 100;
					try {
						// getting tel number
						number = Long.parseLong(objStringTokenizer.nextToken());
					} catch (Exception objException) {
						number = 0;
					}
					// / adding into list
					objUserInfoList.add(new UserInfo(id, name, role, address, salary, number));
				}
				// sleeping thread for 30 ms
				Thread.sleep(30);
			}
		} catch (Exception e) {
		} finally {
			read = null;
			objBufferedReader = null;
			objFileInputStream = null;
			objStringTokenizer = null;
			id = 0;
			name = null;
			role = null;
			address = null;
			number = 0;
			salary = 0;
		}
	}

	/**
	 * @description : this method is used to read userLoginInfo file data
	 */
	private void userLoginInfo() {
		String read = null;

		try {
			// reading file using input stream
			objFileInputStream = new FileInputStream(filePath);
			// reading input stream using reader
			objBufferedReader = new BufferedReader(new InputStreamReader(objFileInputStream));
			// reading line by line data
			while ((read = objBufferedReader.readLine()) != null) {
				// separating everyline data by comma
				objStringTokenizer = new StringTokenizer(read, ",");
				// until it has data
				while (objStringTokenizer.hasMoreElements()) {
					// adding all info to list
					objUserLoginInfoList.add(new UserLoginInfo(Integer.parseInt(objStringTokenizer.nextToken()),
							objStringTokenizer.nextToken(), objStringTokenizer.nextToken(),
							objStringTokenizer.nextToken()));

				}
			}
		} catch (Exception e) {
		} finally {
			objBufferedReader = null;
			objFileInputStream = null;
			objStringTokenizer = null;
			read = null;
		}
	}

	/**
	 * @throws InterruptedException
	 * @description : this method is used to perform authentication based on
	 *              role
	 */
	private void authenticate() throws InterruptedException {
		int tempVariable = 0;
		int tempVariable2 = 0;
		String userName = null;
		String password = null;

		try {
			tempVariable2 = 1;
			System.out.println("\n----Enter user name password to login----");
			objScanner = new Scanner(System.in);
			System.out.println("You have only three chance\n");
			// it will loop 3 times
			while (tempVariable2 != 4) {
				// sleeping thread
				Thread.sleep(10);
				System.out.print("username: ");
				// getting username
				userName = objScanner.next();
				System.out.print("password: ");
				// getting password
				password = objScanner.next();

				// loopint til it has data
				for (int i = 0; i < objUserLoginInfoList.size(); i++) {
					// if username and password matches
					if (objUserLoginInfoList.get(i).getUserName().equals(userName)
							&& objUserLoginInfoList.get(i).getPassword().equals(password)) {

						System.out.println("\n ---Yor are logged in---\n your information is: \n");
						printCase(objUserInfoList.get(i).getUserId());

						// calling userRole method
						userRole(objUserLoginInfoList.get(i).getUserRole(), objUserInfoList.get(i).getUserId());

						subMenuChoice(objUserLoginInfoList.get(i).getUserRole(), objUserInfoList.get(i).getUserId());

						tempVariable = 1;
						// exiting system
						System.exit(i);
					}
				}
				tempVariable2++;
				// it tempvariable is 1 then error
				if (tempVariable != 1) {
					Thread.sleep(30);
					System.err.println("Either username or password is wrong. Please try again.");
					// if tempvariable2 is 4 then exit
					if (tempVariable2 == 4) {
						Thread.sleep(10);
						System.out.println("System closed due to invalid details");
					}
				}
			}
		} finally {
			tempVariable = 0;
			tempVariable2 = 0;
			userName = null;
			password = null;
		}
	}

	/**
	 * @description : this method works for submenues of employee info
	 * @param role
	 * @param userID
	 * @throws InterruptedException
	 */
	private void subMenuChoice(String role, int userID) throws InterruptedException {
		String choice = null;

		try {
			// get the choice from user
			System.out.println(
					"1. Press 'B' to go back\n2. Press 'O' to log off from this window\n3. Perss 'X' to exit from this window");
			choice = objScanner.next();
			switch (choice) {
			// if x then exit
			case "x":
			case "X":
				System.out.println("you have exited from this window");
				System.exit(0);
				break;
			// if O then logg off
			case "O":
			case "o":
				System.out.println("logged off successfully...");
				authenticate();
				break;
			// if b then back
			case "b":
			case "B":
				System.out.println("sorry..no options available for you..you will be logged off");
				authenticate();
				break;
			default:
				// calling method again
				System.out.println("Wrong choice please select from above given option \n");
				subMenuChoice(role, userID);
				break;
			}
		} finally {
			choice = null;
		}
	}

	/**
	 * @description : this method performs searching and display operation based
	 *              on roles
	 * @param userRole
	 * @param userID
	 * @throws InterruptedException
	 */
	private void userRole(String userRole, int userID) throws InterruptedException {

		String subMenuChoice = null;

		try {
			objScanner = new Scanner(System.in);
			// giving role of authenticated user
			switch (userRole) {
			// if admin then
			case "Admin":
				System.out.println("\n ========MAIN MENU===\n PLEASE FOLLOW INSTRUCTIONS CAREFULLY: \n\n ");
				System.out.println(
						"1. press 'L' to see list:\n2. press 'S' to search employee info:\n3. press 'O' to logOff:\n4. press 'x' to exit");
				// getting choice
				subMenuChoice = objScanner.next();
				switch (subMenuChoice) {
				case "l":
				case "L":
					// calling display method
					displayListAdmin(userID);
					break;
				case "s":
				case "S":
					// calling search method
					searchingByAdmin(userID);
					break;
				case "O":
				case "o":
					// logging off
					System.out.println("Admin logged off successfully\n\n");
					authenticate();
					break;
				case "x":
				case "X":
					// exiting system
					System.out.println("you have exited from this window");
					System.exit(0);
					break;
				default:
					// calling method again
					System.out.println("Wrong choice please select from above given option \n");
					userRole("Admin", userID);
					break;
				}
				break;
			// if manager
			case "Manager":
				System.out.println("\n ========MAIN MENU===\n PLEASE FOLLOW INSTRUCTIONS CAREFULLY: \n\n ");
				System.out.println(
						"1. press 'L' to see list:\n2. press 'S' to search employee info:\n3. press 'O' to logOff:\n4. press 'x' to exit");
				// getting choice
				subMenuChoice = objScanner.next();
				switch (subMenuChoice) {
				case "l":
				case "L":
					// calling display method
					displayListManager(userID);
					break;
				case "s":
				case "S":
					// calling search method
					searchingByManager(userID);
					break;
				case "O":
				case "o":
					System.out.println("Manager logged_off \n\n");
					// logging off
					authenticate();
					break;
				case "x":
				case "X":
					// exiting
					System.out.println("you have exited from this window");
					System.exit(0);
					break;
				default:
					System.out.println("Wrong choice please select from above given option \n");
					// calling method again
					userRole("Manager", userID);
					break;
				}
				break;
			default:
				break;
			}
		} finally {
			subMenuChoice = null;
		}
	}

	/**
	 * @description : this method is used to search data by admin role
	 * @param userID
	 * @throws InterruptedException
	 */
	private void searchingByAdmin(int userID) throws InterruptedException {
		int search = 0;
		int tempVariable = 0;
		String choice = null;
		int key = 0;

		try {
			System.out.println("\n----submenus---\n 1. press 'B' to back to Main Menu,\n"
					+ " 2. Press 'E' for Employees,\n" + " 3. press 'M' for Manager,\n"
					+ " 4. press 'A' for Admin and \n" + " 5. press 'All' for all");
			objScanner = new Scanner(System.in);
			// getting choice
			choice = objScanner.next();

			switch (choice) {
			case "E":
			case "e":
				System.out.println("enter Employee's userID to search the information");
				// getting choice
				search = objScanner.nextInt();
				// iterating hashmap
				objIterator = objHashMap.entrySet().iterator();
				// until it has data
				while (objIterator.hasNext()) {
					// getting key of values
					key = objIterator.next().getKey();
					// if key matches from employee
					if (objHashMap.get(key).getUserId() == search
							&& objHashMap.get(key).getUserRole().equalsIgnoreCase("employee")) {

						System.out.println("searched employee information is: \n");
						// print info
						printCase(key);
						tempVariable = 1;
					}
				}
				// if no info exist
				if (tempVariable != 1) {
					System.out.println("employee information doesn't exist");
				}
				searchingByAdmin(userID);
				break;
			case "M":
			case "m":
				System.out.println("please enter manager's userID to search the information");
				// getting choice
				search = objScanner.nextInt();
				// iterating hashmap
				objIterator = objHashMap.entrySet().iterator();
				// until it has data
				while (objIterator.hasNext()) {
					// getting key of values
					key = objIterator.next().getKey();
					// if key matches from manager
					if (objHashMap.get(key).getUserId() == search
							&& objHashMap.get(key).getUserRole().equalsIgnoreCase("Manager")) {
						System.out.println("\n searched manager information is: \n");
						// print info
						printCase(key);
						tempVariable = 1;
					}
				}
				// if no info exist
				if (tempVariable != 1) {
					System.out.println("Manager information doesn't exist");
				}
				searchingByAdmin(userID);
				break;
			case "A":
			case "a":
				System.out.println("please enter Admin's userID to search the information");
				// getting choice
				search = objScanner.nextInt();
				// iterating hashmap
				objIterator = objHashMap.entrySet().iterator();
				// until it has data
				while (objIterator.hasNext()) {
					// getting key of values
					key = objIterator.next().getKey();
					// if key matches from admin
					if (objHashMap.get(key).getUserId() == search
							&& objHashMap.get(key).getUserRole().equalsIgnoreCase("Admin")) {

						System.out.println("\n searched Admin information is: \n");
						// print info
						printCase(key);
						tempVariable = 1;
					}
				}
				// if no info exist
				if (tempVariable != 1) {
					System.out.println("Admin information doesn't exist");
				}
				searchingByAdmin(userID);
				break;
			case "B":
			case "b":
				// get back to main window
				userRole("Admin", userID);
				break;
			case "All":
			case "all":
				System.out.println("Enter UserID to search");
				// getting choice
				search = objScanner.nextInt();
				// iterating hashmap
				objIterator = objHashMap.entrySet().iterator();
				// until it has data
				while (objIterator.hasNext()) {
					// getting key of values
					key = objIterator.next().getKey();
					// if key matches from admin
					if (objHashMap.get(key).getUserId() == search
							&& objHashMap.get(key).getUserRole().equalsIgnoreCase("Admin")
							|| objHashMap.get(key).getUserId() == search
									&& objHashMap.get(key).getUserRole().equalsIgnoreCase("Manager")
							|| objHashMap.get(key).getUserId() == search
									&& objHashMap.get(key).getUserRole().equalsIgnoreCase("employee")) {

						System.out.println("\n Searched Information is\n");
						// print info
						printCase(key);
						tempVariable = 1;
					}
				}
				// if no info exist
				if (tempVariable != 1) {
					System.out.println("Search not found");
				}
				searchingByAdmin(userID);
				break;
			default:
				System.out.println("match not found..do you wish to continue? press Y/N ");
				// getting choice after printing wrong input
				String yourChoice = objScanner.next();
				// if yes then again search
				if (yourChoice.equalsIgnoreCase("y")) {
					searchingByAdmin(userID);
					// else exit system
				} else {
					System.out.println("You have exited this window");
					System.exit(0);
				}
				break;
			}
		} catch (Exception e) {
			System.out.println("Please enter user id in number format only");
			System.exit(0);
		} finally {
			search = 0;
			tempVariable = 0;
			choice = null;
			key = 0;
		}
	}

	/**
	 * @description : this method searches data by manager
	 * @param userID
	 * @throws InterruptedException
	 */
	private void searchingByManager(int userID) throws InterruptedException {
		int search = 0;
		int tempVariable = 0;
		int key = 0;
		String choice = null;

		try {
			System.out.println("\n----submenus---\n 1. press 'B' to back to Main Menu,\n"
					+ " 2. Press 'E' for Employees,\n" + " 3. press 'All' for all ");
			objScanner = new Scanner(System.in);
			// getting choice
			choice = objScanner.next();

			switch (choice) {
			case "E":
			case "e":

				System.out.println("enter Employee's userID to search the information");
				// getting key to search
				search = objScanner.nextInt();
				// iterating hashmap
				objIterator = objHashMap.entrySet().iterator();
				// until it has data
				while (objIterator.hasNext()) {
					// getting key
					key = objIterator.next().getKey();
					// if id and role matches
					if (objHashMap.get(key).getUserId() == search
							&& objHashMap.get(key).getUserRole().equalsIgnoreCase("employee")) {

						System.out.println("\n searched employee information is: ");

						// printing info
						printCase(key);
						tempVariable = 1;
					}
				}
				// if doesn't exist info
				if (tempVariable != 1) {
					System.out.println("employee information doesn't exist");
				}
				searchingByManager(userID);
				break;
			case "B":
			case "b":
				// getting back to main menu
				userRole("Manager", userID);
				break;
			case "ALL":
			case "all":
				System.out.println("Enter UserID to search");
				// getting choice
				search = objScanner.nextInt();
				// iterating hashmap
				objIterator = objHashMap.entrySet().iterator();
				// until it has data
				while (objIterator.hasNext()) {
					// getting key of values
					key = objIterator.next().getKey();
					// if key matches from admin
					if (objHashMap.get(key).getUserId() == search
							&& objHashMap.get(key).getUserRole().equalsIgnoreCase("Admin")
							|| objHashMap.get(key).getUserId() == search
									&& objHashMap.get(key).getUserRole().equalsIgnoreCase("Manager")
							|| objHashMap.get(key).getUserId() == search
									&& objHashMap.get(key).getUserRole().equalsIgnoreCase("employee")) {

						System.out.println("\n Searched Information is\n");
						// print info
						printCase(key);
						tempVariable = 1;
					}
				}
				// if no info exist
				if (tempVariable != 1) {
					System.out.println("Search not found");
				}
				// searchingByAdmin(userID);
				searchingByManager(userID);
				break;
			default:
				System.out.println("match not found..do you wish to continue? press Y/N ");
				// if choose wrong input then getting choice to continues or not
				String yourChoice = objScanner.next();
				// if yes then call again
				if (yourChoice.equalsIgnoreCase("y")) {
					searchingByManager(userID);
					// else exit system
				} else {
					System.out.println("You have exited this window");
					System.exit(0);
				}
				break;
			}
		} catch (Exception e) {
			System.out.println("Please enter user id in number format only");
			System.exit(0);
		} finally {
			search = 0;
			tempVariable = 0;
			key = 0;
			choice = null;
		}
	}

	/**
	 * @description : this method is used to display list by manager
	 * @param userID
	 * @throws InterruptedException
	 */
	private void displayListManager(int userID) throws InterruptedException {

		String choice = null;
		String yourChoice = null;
		int key = 0;

		try {
			System.out.println("\n----submenus---\n 1. press 'B' to back to Main Menu,\n"
					+ " 2. Press 'E' for Employees,\n" + " 3. press 'All' for all");
			objScanner = new Scanner(System.in);
			// getting choice
			choice = objScanner.next();

			switch (choice) {
			case "E":
			case "e":
				System.out.println("All employee information is: ");
				// iterating hashmap
				objIterator = objHashMap.entrySet().iterator();
				// looping till it has data
				while (objIterator.hasNext()) {
					// getting key
					key = objIterator.next().getKey();
					// if data matches then
					if (objHashMap.get(key).getUserRole().equals("Employee")) {
						// print info
						printCase(key);
					}
				}
				displayListManager(userID);
				break;
			case "B":
			case "b":
				// getting back to main menu
				userRole("Manager", userID);
				break;
			case "All":
				System.out.println("All employee information is: ");
				// iterating hahsmap
				objIterator = objHashMap.entrySet().iterator();
				// till it contains data
				while (objIterator.hasNext()) {
					// getting key
					key = objIterator.next().getKey();
					// if data matches
					if (!objHashMap.get(key).getUserRole().equals("Admin")
							&& !objHashMap.get(key).getUserRole().equals("Manager")) {
						// printing info
						printCase(key);

					}
				}
				displayListManager(userID);
				break;
			default:
				System.out.println("you have entered wrong choice..do you wish to continue or log off? press Y/N ");
				// if chosed wrng choice then get choice to continue or not
				yourChoice = objScanner.next();
				// if yes then call again
				if (yourChoice.equalsIgnoreCase("y")) {
					displayListManager(userID);
				} else {
					// else exit
					System.out.println("You have exited this window");
					System.exit(0);
				}
				break;
			}
		} finally {
			choice = null;
			yourChoice = null;
			key = 0;
		}
	}

	/**
	 * @description : this method diisplay info by admin
	 * @param userID
	 * @throws InterruptedException
	 */
	private void displayListAdmin(int userID) throws InterruptedException {

		String choice = null;
		String yourChoice = null;
		int key = 0;

		try {
			System.out.println("\n----submenus---\n 1. press 'B' to back to Main Menu,\n"
					+ " 2. Press 'E' for Employees,\n" + " 3. press 'M' for Manager,\n"
					+ " 4. press 'A' for Admin and \n" + " 5. press 'All' for all");
			objScanner = new Scanner(System.in);
			// getting choice
			choice = objScanner.next();

			switch (choice) {
			case "E":
			case "e":
				System.out.println("All employee information is: ");
				// iterating hashmap data
				objIterator = objHashMap.entrySet().iterator();
				// till it has data
				while (objIterator.hasNext()) {
					// getting key
					key = objIterator.next().getKey();
					// it data matches
					if (objHashMap.get(key).getUserRole().equals("Employee")) {
						// printing info
						printCase(key);
					}
				}
				displayListAdmin(userID);
				break;
			case "M":
			case "m":
				System.out.println("All manager information is: ");
				// iterating hashmap data
				objIterator = objHashMap.entrySet().iterator();
				// looping till it has data
				while (objIterator.hasNext()) {
					// getting key
					key = objIterator.next().getKey();
					// if data matches
					if (objHashMap.get(key).getUserRole().equals("Manager")) {
						// printing info
						printCase(key);
					}
				}
				displayListAdmin(userID);
				break;
			case "A":
			case "a":
				System.out.println("All Admin information is: ");
				// iterating hashmap
				objIterator = objHashMap.entrySet().iterator();
				// till it contains data
				while (objIterator.hasNext()) {
					// getting key
					key = objIterator.next().getKey();
					// if data matches
					if (objHashMap.get(key).getUserRole().equals("Admin")) {
						// printing info
						printCase(key);
					}
				}
				displayListAdmin(userID);
				break;
			case "B":
			case "b":
				// getting back to main menu
				userRole("Admin", userID);
				break;
			case "All":
				System.out.println("All information : ");
				// iterating hahsmap
				objIterator = objHashMap.entrySet().iterator();
				// till it contains data
				while (objIterator.hasNext()) {
					// getting key
					key = objIterator.next().getKey();
					// printing info
					printCase(key);
				}
				displayListAdmin(userID);
				break;
			default:
				System.out.println("you have entered wrong choice..do you wish to continue or log off? press Y/N ");
				// if input does't match then choose contiues or exit
				yourChoice = objScanner.next();
				// if yes then call again
				if (yourChoice.equalsIgnoreCase("y")) {
					displayListAdmin(userID);
				} else {
					// else exit
					System.out.println("You have exited this window");
					System.exit(0);
				}
				break;
			}
		} finally {
			choice = null;
			yourChoice = null;
			key = 0;

		}
	}

	/**
	 * @description : this method is used to print all data of user
	 * @param key
	 */
	private void printCase(int key) {

		System.out.println(" \n user_id: " + objHashMap.get(key).getUserId());
		// printing output
		System.out.println("Name : " + objHashMap.get(key).getName());
		System.out.println("Role : " + objHashMap.get(key).getUserRole());
		System.out.println("Address : " + objHashMap.get(key).getAddress());
		System.out.println("City : " + objHashMap.get(key).getCity());
		System.out.println("Salary : " + objHashMap.get(key).getBasicSalary());
		System.out.println("Mobile Number : " + objHashMap.get(key).getTelNumber() + "\n");
	}

	/**
	 * @description : this method is used to merge files into one hashmap
	 */
	private void merge() {

		// iterating hashmap
		for (int i = 0; i < objUserInfoList.size(); i++) {
			objMerged = new Merged();
			// getting index
			objInfo = objUserInfoList.get(i);

			// getting all information from list and setting into merged class
			// objectF
			objMerged.setUserId(objUserInfoList.get(i).getUserId());
			objMerged.setName(objInfo.getName());
			objMerged.setAddress(objInfo.getAddress());
			objMerged.setCity(objInfo.getCity());
			objMerged.setBasicSalary(objInfo.getBasicSalary());
			objMerged.setTelNumber(objInfo.getTelNumber());
			objMerged.setUserRole(objUserLoginInfoList.get(i).getUserRole());
			// putting values into hashmap
			objHashMap.put(objUserInfoList.get(i).getUserId(), objMerged);
		}
	}

	/**
	 * @description : this is thread run method to execute other methods based
	 *              on mode
	 */
	public void run() {
		try {

			// getting thread name
			System.out.println(objGroup.getName());
			switch (objGroup.getName()) {
			case "LOADER_PROCESS":
				// if mode is read
				if (mode.equalsIgnoreCase("read")) {
					// call userInfo
					this.userInfo();

					Thread.sleep(1000);
					// call userLoginInfo
					this.userLoginInfo();
				}
				// if mode is write
				if (mode.equalsIgnoreCase("write")) {
					Thread.sleep(2000);
					this.merge();
				}
				break;
			case "FINDER_PROCESS":
				// if mode is find
				if (mode.equalsIgnoreCase("find")) {
					// call authenticate
					this.authenticate();
				}
				break;
			default:
				break;
			}
		} catch (Exception objException) {
			objException.printStackTrace();
		}
	}
}
