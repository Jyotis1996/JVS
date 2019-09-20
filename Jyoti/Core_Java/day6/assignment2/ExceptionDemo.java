package com.uks.jvs.jyoti.day6.assignment2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Class Name:ExceptionDemo Description:Exception Handling
 *
 * @author Jyoti [27-06-2019]
 */
public class ExceptionDemo {
	/**
	 * Method Name:getException Description:Exception Handling Created
	 */
	Scanner objScanner = new Scanner(System.in);
	Scanner objScanner1 ;
	String a = null; //null value

	public void getException() throws InputMismatchException,ArithmeticException {
		try {

		// throws InputMisMatch,ArithmeticException
			System.out.println("Enter wrong input to generate InputMisMatch exception");
		System.out.println("Enter 0 as second value to generate arithmetic exception");
		System.out.println("Enter first value : ");
		int num1 = objScanner.nextInt();

		System.out.println("Enter second value : ");
		int num2 =  objScanner.nextInt();

		int ans = num1/num2;
		System.out.println("Answer is : "+ ans);
		} catch(InputMismatchException IE){
			System.out.println("Exception is generated : ");
			System.out.println(IE);
		} catch (ArithmeticException AE) {
			System.out.println("Exception is generated :");
			System.out.println(AE);
		}
	}

	public void getNullPointerException() throws NullPointerException {
		try {
             //Throws NullPointerException
            System.out.println(a.charAt(0));
        } catch(NullPointerException e) {
            System.out.println("Exception is generated");
            System.out.println(e);
        }
	}

	@SuppressWarnings("hiding")
	public void getIOException() throws FileNotFoundException,IOException{
		try {
			//throws FileNotFoundException
			System.out.println("Enter file path");
			@SuppressWarnings("resource")
			String path = new Scanner(System.in).nextLine();

			File file = new File(path);
			objScanner1 = new Scanner(file);
		} catch (FileNotFoundException FE) {
			System.out.println("Exception is generated");
			System.out.println(FE);
		} catch (IOException IOE) {
			System.out.println("Exception is generated");
			System.out.println(IOE);
		}
		objScanner.close();
	}

}
