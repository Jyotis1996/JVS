package com.uks.jvs.jyoti.day8.assignment1;

import java.util.Scanner;

/**
 * Class Name : GenericTestMain
 * Description : Main class to invoke methods of GenericTest class
 * @author Jyoti [02-07-2019]
 *
 */
public class GenericTestMain {

	public static void main(String[] args){
		long mobile;
		String name ;
		Scanner scan = new Scanner(System.in);

		try{
			GenericsTest obj = new GenericsTest();
			obj.addToDir();
			obj.printAll();
			System.out.println("Enter many elements you want to add: ");
			int ele = scan.nextInt();

			for(int i = 0; i < ele; i++){
				System.out.println("Enter Mobile number");
				mobile = scan.nextLong();
				System.out.println("Enter first name of user");
				name = scan.next();

				//Calling function for add data to directory
				obj.addToDirectory(mobile, name);
			}

			//print all the elements
			obj.printAll();
			//searching
			//for  dynamically
			System.out.println("===============Enter Mobile number of Jenny or Jecob=====================");
			mobile = scan.nextLong();
			obj.searchMobile(mobile);

			System.out.println("===============Enter Mobile number=====================");
			mobile = scan.nextLong();
			obj.searchMobile(mobile);
		}
		catch(Exception e){
			System.out.println("Enter valid data");
		}
		finally{
			scan.close();
		}
	}

}
