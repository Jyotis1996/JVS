package com.uks.jvs.jyoti.day1.assignment3;

/*
 * Class Name:TestCommandLine
 * Description:Get the value for command line
 * Created:Jyoti [19-06-2019]
 */
public class TestCommandLine {
	public static void main(String[] args) {
		UsernamePassword usernamepassword = null;
		try {
			usernamepassword = new UsernamePassword();
			usernamepassword.validate(args[0], args[1]);
			// command line argument as 0th and 1st position of string array.
		} catch (Exception obj) {
			obj.printStackTrace();
			System.out.println("Please enter command line arguments");
		} finally {
			usernamepassword = null;
		}

	}
}
