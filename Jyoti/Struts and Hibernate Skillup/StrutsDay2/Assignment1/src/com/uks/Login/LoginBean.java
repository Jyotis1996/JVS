package com.uks.Login;

import com.opensymphony.xwork2.ActionSupport;
import com.uks.common.Constants;

/**
 * This class is used to get and set the username and password and validate the
 * input
 *
 * @author Jyoti Date-2019/08/30
 */
public class LoginBean extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;

	// Get the username
	public String getUsername() {
		return username;
	}

	// Set the Username
	public void setUsername(String username) {
		this.username = username;
	}

	// Get the password
	public String getPassword() {
		return password;
	}

	// Set the Password
	public void setPassword(String password) {
		this.password = password;
	}

	public void validate() {
		// Check username is empty or not
		if (getUsername().isEmpty()) {
			addFieldError(Constants.USERNAME,Constants.USERNAME_BLANK );
		}
		// Check password is Empty or not
		if (getPassword().isEmpty()) {
			addFieldError(Constants.PASSWORD, getText(Constants.PASSWORD_BLANK));
		}
	}
}
