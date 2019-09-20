package com.uks.jvs.jyoti.day6.assignment2;

/**
 * Class Name:ExceptionMain Description:Main Method Class Exception Handling
 *
 * @author Jyoti [27-06-2019]
 */
public class ExceptionMain {
	/*
	 * Main Method for Class To Handle the Exception
	 */
	public static void main(String[] args) throws Exception {
		ExceptionDemo objExceptionDemo = null;
		try {
			objExceptionDemo = new ExceptionDemo();
			objExceptionDemo.getException();
			objExceptionDemo.getNullPointerException();
			objExceptionDemo.getIOException();
		} catch (Exception e) {
			System.out.println("Exception is : ");
			System.out.println(e);
		} finally {
			objExceptionDemo = null;
		}
	}
}
