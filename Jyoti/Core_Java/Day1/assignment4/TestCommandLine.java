package com.uks.jvs.jyoti.day1.assignment4;

/*
 * Class Name:TestMultiCommandLine
 * Description:Get the Multiple Command line Arguments
 * Created: Jyoti [19-06-2019]
 */
public class TestCommandLine {

	public static void main(String[] args) {

		Multicommandline multicommandline = null;
		try {
			multicommandline = new Multicommandline(); // object Initialization
			multicommandline.doOperation(args); // Call Method
		} catch (Exception obj) {
			obj.printStackTrace();
			System.out.println("Please enter command line arguments");

		} finally {
			multicommandline = null;
		}

	}

}
