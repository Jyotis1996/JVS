package com.uks.Jyoti.core.day1.assignment3;

/*
 * Class Name:UsernamePassword
 * Description:Check and Compare Login Details
 * Created:Jyoti [19-06-2019]
 */
public class UsernamePassword {
	/*
	 * Method Name:validate
	 * Description:Accept Login Details From user and Validate it
	 * Created:Jyoti [20-06-2019]
	 */

	public void validate(String Uname, String psw) {

		String strUsername = "ABC"; //hardcoded value for username
		String strPassWord = "ABC"; //hardcoded value for password

		//if else condition to authenticate username and password
			if (Uname.equals(strUsername) && psw.equals(strPassWord)) {
				System.out.println("Authenticated User");
				System.out.println("UserName:" + Uname + "\nPassword:" + psw);
			} else {
				System.out.println("Incorrect credentials");
			}
	}
}
