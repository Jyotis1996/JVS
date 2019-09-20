package com.assignment1.bean;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 * Class takes the Form argument values and set and get the value to variables
 * @author Jyoti date-2019/09/09
 *
 */
public class LoginBean extends ActionForm {
	private static final long serialVersionUID = 1L;
	private String userName = null;
	private String password = null;

	/**
	 * Get Username
	 *
	 * @return
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * Set Username
	 *
	 * @param userName
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * Get Password
	 *
	 * @return
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Set Password
	 *
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Validate method validate the user input
	 */
	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();
		// Check user name is empty or not
		if (getUserName().isEmpty()) {
			// Add user name error
			errors.add("userName_error", new ActionMessage("UserName.error"));
		}
		// Check password is Empty or not
		if (getPassword().isEmpty()) {
			// add password error
			errors.add("password_error", new ActionMessage("Password.error"));
		}
		// return error
		return errors;
	}

	/**
	 * this method reset the variables
	 */
	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		this.userName = "";
		this.password = "";
		super.reset(mapping, request);

	}

}
