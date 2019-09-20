package com.uks.Login;

import java.sql.SQLException;

import com.uks.common.Constants;

/**
 * This class used to get the username and password from the html form and pass
 * it to another class for validations
 *
 * @author Jyoti Date-2019/08/31
 */
public class LoginAction extends LoginBean {
	private static final long serialVersionUID = -1015689408628899135L;

	/**
	 * This method is used to call the validation method for username and
	 * password and display the message as per details
	 */
	public String execute() throws ClassNotFoundException, SQLException {
		LoginLogic objLoginLogic = null;
		try {
			// Initialize the object of LoginLogic class
			objLoginLogic = new LoginLogic();
			// Check the username and password is correct or not.
			if (objLoginLogic.validateUser(getUsername(), getPassword())) {
				// return success if details correct
				return "success";
			} else {
				// display if details not correct
				addActionMessage(Constants.INVALID);
				return "failure";
			}
		} finally {
			// release the object
			objLoginLogic = null;
		}
	}
}
