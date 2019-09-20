package com.uks.jvs.jyoti.day6.assignment1;

import java.io.IOException;
import java.text.ParseException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import com.uks.jvs.jyoti.day1.assignment4.Multicommandline;
import com.uks.jvs.jyoti.day2.assignment3.StringOperation;
import com.uks.jvs.jyoti.day3.assignment3.DateAndTime;
import com.uks.jvs.jyoti.day3.assignment5.DateAdd;
import com.uks.jvs.jyoti.day3.assignment8.ClassDetails;
import com.uks.jvs.jyoti.day4.assignment5.FrequencyCheck;
import com.uks.jvs.jyoti.day5.assignment3.EmployeeDetailsReader;
import com.uks.jvs.jyoti.day5.assignment4.EmployeeDetails;

/**
 * Class Name:UserInteraction Description:Interaction between Tasks
 *
 * @author Jyoti [27-06-2019]
 */
public class UserInteraction {
	/**
	 * Main Method Get the Input From User and Switch to according Class Created
	 *
	 */
	public static void main(String[] args) throws InputMismatchException, NoSuchElementException, ParseException,
			NullPointerException, ClassNotFoundException, IOException {
		Scanner objScanner = null;

		String command;
		Multicommandline objLine_a;
		StringOperation objOperation_b;
		Ass4Day2 objOperation_c;
		DateAndTime objDateAndTime_d;
		Ass4Day3 objDifference_e;
		DateAdd objAdd_f;
		ClassDetails objClassDetails_g;
		FrequencyCheck objChecker_h;
		EmployeeDetailsReader objReader_i;
		EmployeeDetails objEmployeeDetails_j;

		try {
			String[] InputArray;
			objScanner = new Scanner(System.in);
			System.out.println(
					" \n Choose Command Between [a to j] for following operations \n a. Reading undefined number of command line arguments \n b. String Manipulation & Regular Expression in Java \n c. String Manipulation  Using Character class \n d. Printing Date, Time and formatted Date \n e. Date Difference \n f. Date Add \n  g.  Reflection in Java \n h. Java Map Collections & Autoboxing \n j. Sorting the Record by the user specified column \n");
			command = objScanner.next();
			switch (command) {
			case "a":
				String choice;
				int ArraySize;
				System.out.println("Please choose Between Following:");
				System.out.println("1.Add Numbers");
				System.out.println("2.Change String to lower case");
				choice = objScanner.next();
				if ("1".equals(choice) || "2".equals(choice)) {
					System.out.println("Number of elements:");
					ArraySize = objScanner.nextInt() + 1;
					System.out.println("***************************************");
					System.out.println("Enter elements:");
					InputArray = new String[ArraySize];
					InputArray[0] = choice;
					for (int i = 1; i < ArraySize; i++) {// for reading array
						InputArray[i] = objScanner.next();
					}
					objLine_a = new Multicommandline();
					objLine_a.doOperation(InputArray);
				} else {
					System.out.println("invalid argument");
				}
				System.out.println("Exit(x)");
				main(args);
				break;
			case "b":
				String choice_b;
				int ArraySize_b;
				System.out.println("Please choose Between Following:");
				System.out.println("1.Reverse String");
				System.out.println("2.Count UpperCase,LowerCase & Digit");
				choice_b = objScanner.next();
				if ("1".equals(choice_b) || "2".equals(choice_b)) {
					switch (choice_b) {
					case "1":
						System.out.println("Enter String:");
						InputArray = new String[2];
						InputArray[0] = choice_b;
						InputArray[1] = objScanner.next();
						objOperation_b = new StringOperation();
						objOperation_b.doOperationWithRegEx(InputArray);
						break;
					case "2":
						System.out.println("Enter String:");
						ArraySize_b = objScanner.nextInt() + 1;
						System.out.println("*********************************");
						System.out.println("Enter Elements");
						InputArray = new String[ArraySize_b];
						InputArray[0] = choice_b;
						for (int i = 1; i < ArraySize_b; i++) {// for reading
																// array
							InputArray[i] = objScanner.next();
						}
						objOperation_b = new StringOperation();
						objOperation_b.doOperationWithRegEx(InputArray);
						break;
					}
				} else {
					System.out.println("Invalid Argument");
				}
				System.out.println("Exit(X)");
				main(args);
				break;
			case "c":
				int ArraySize_c;
				System.out.println("Count UpperCase,LowerCase & Digit \n");
				System.out.println("How Many Number of Elements?");
				ArraySize_c = objScanner.nextInt();
				System.out.println("***************************************");
				System.out.println("Enter Elements");
				InputArray = new String[ArraySize_c];
				for (int i = 0; i < ArraySize_c; i++) {// for reading
														// array
					InputArray[i] = objScanner.next();
				}
				objOperation_c = new Ass4Day2();
				objOperation_c.doOperation(InputArray);
				System.out.println("Exit(X)");
				main(args);
				break;
			case "d":
				String choice_d;
				System.out.println("Please choose Between Following:");
				System.out.println("1.Date Formatting of Today's Date");
				System.out.println("2.Date Formatting of Other Date");
				choice_d = objScanner.next();
				switch (choice_d) {
				case "1":
					System.out.println("Enter Any Valid DateFormat[ex.yyyy/MM/dd]");
					InputArray = new String[1];
					InputArray[0] = objScanner.next();
					objDateAndTime_d = new DateAndTime();
					objDateAndTime_d.ValidateDate(InputArray);
					break;
				case "2":
					System.out.println("Enter Any Valid DateFormat[ex.yyyy/MM/dd]");
					InputArray = new String[2];
					InputArray[0] = objScanner.next();
					System.out.println("Enter Date[yyyy/MM/dd]:");
					InputArray[1] = objScanner.next();
					objDateAndTime_d = new DateAndTime();
					objDateAndTime_d.ValidateDate(InputArray);
					break;
				default:
					System.out.println("Invalid Argument");
					break;
				}
				System.out.println("Exit(X)");
				main(args);
				break;
			case "e":
				System.out.println("Difference Between two Dates[in Days]\n");
				System.out.println("Enter Date[dd/MM/yyyy]:");
				InputArray = new String[2];
				InputArray[0] = objScanner.next();
				System.out.println("Enter Date[dd/MM/yyyy]:");
				InputArray[1] = objScanner.next();
				objDifference_e = new Ass4Day3();
				objDifference_e.CountDifference(InputArray);
				System.out.println("Exit(X)");
				main(args);
				break;
			case "f":
				System.out.println("Add Day,Month Or Year in Date");
				System.out.println("Enter Date[dd/MM/yyyy]:");
				InputArray = new String[3];
				InputArray[0] = objScanner.next();
				System.out.println("Select [date,month,year]:");
				InputArray[1] = objScanner.next();
				if ("date".equals(InputArray[1]) || "month".equals(InputArray[1]) || "year".equals(InputArray[1])) {
					System.out.println("Enter Number:");
					InputArray[2] = Integer.toString(objScanner.nextInt());
				}
				objAdd_f = new DateAdd();
				objAdd_f.doAddition(InputArray);
				System.out.println("Exit(X)");
				main(args);
				break;
			case "g":
				System.out.println("Details Of Class");
				System.out.println("Enter Class Name:");
				InputArray = new String[2];
				InputArray[0] = objScanner.next();
				System.out.println("Enter TypeOfInfo[ALL,M Or F]:");
				InputArray[1] = objScanner.next();
				objClassDetails_g = new ClassDetails();
				objClassDetails_g.showDetail(InputArray[0], InputArray[1]);
				System.out.println("Exit(X)");
				main(args);
				break;
			case "h":
				int ArraySize_h;
				System.out.println("Frequency Checker");
				System.out.println("How Many Number of Elements?");
				ArraySize_h = objScanner.nextInt();
				System.out.println("Enter Elements:");
				InputArray = new String[ArraySize_h];
				for (int i = 0; i < ArraySize_h; i++) {
					InputArray[i] = objScanner.next();
				}
				objChecker_h = new FrequencyCheck();
				objChecker_h.countFrequency(InputArray);
				System.out.println("Exit(X)");
				main(args);
				break;
			case "i":
				System.out.println("Searching the Records");
				System.out.println("Enter last name of employee to be searched : ");
				InputArray = new String[1];
				InputArray[0] = objScanner.next();
				objReader_i = new EmployeeDetailsReader();
				objReader_i.getLastName(InputArray);
				System.out.println("Exit(X)");
				main(args);
				break;
			case "j":
				System.out.println("Searching & Sorting the Records");
				System.out.println("Enter last name of employee to be searched : ");
				InputArray = new String[2];
				InputArray[0] = objScanner.next();
				System.out.println("Enter Sort By:");
				InputArray[1] = objScanner.next();
				objEmployeeDetails_j = new EmployeeDetails();
				objEmployeeDetails_j.getLastName(InputArray);
				System.out.println("Exit(X)");
				main(args);
				break;
			case "X":
				System.exit(0);
				break;
			default:
				System.out.println("Invalid argument");
				System.out.println("Exit(X)");
				main(args);
				break;
			}
		} catch (InputMismatchException ex) {
			System.out.println("Invalid argument");
		} catch (NoSuchElementException ex) {
			System.out.println("Invalid argument");
		} catch (ParseException ex) {
			System.out.println("Invalid date format");
		} catch (NullPointerException e) {
			System.out.println("Invalid argument");
		} catch (ClassNotFoundException ex) {
			System.out.println("Class not found");
		} catch (IOException ex) {
			System.out.println("Invalid file name");
		} finally {
			objScanner.close();
			objAdd_f = null;
			objChecker_h = null;
			objClassDetails_g = null;
			objDateAndTime_d = null;
			objDifference_e = null;
			objEmployeeDetails_j = null;
			objLine_a = null;
			objOperation_b = null;
			objOperation_c = null;
			objReader_i = null;
			objScanner = null;
		}
	}
}
