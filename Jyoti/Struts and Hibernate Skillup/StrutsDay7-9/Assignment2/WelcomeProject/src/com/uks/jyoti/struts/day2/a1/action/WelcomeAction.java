/**
 *
 */
package com.uks.jyoti.struts.day2.a1.action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.uks.jyoti.struts.common.util.Constants;
import com.uks.jyoti.struts.day2.a1.bean.UserDataBean;
import com.uks.jyoti.struts.day2.a1.logic.LoginLogic;

/**
 * @author jyoti
 *
 */
public class WelcomeAction extends ActionSupport implements SessionAware {

	/**
	 * This class is use for welcome user action after login
	 */
	private static final long serialVersionUID = 1L;

	String loggedUsername = null, loggedPassword = null;
	private Map<String, Object> sessionMap;

	// Creating object
	public UserDataBean objuser = new UserDataBean();
	UserDataAction objFetch = new UserDataAction();
	public LoginLogic objLogic = new LoginLogic();

	// Define array list of UserDataBean class
	public List<UserDataBean> list = null;

	public String logout() {
		// remove userName from the session
		if (sessionMap.containsKey("username")) {
			sessionMap.remove("username");
		}
		return SUCCESS;
	}

	// Login check method using session vaiable
	public String login() {
		loggedUsername = objuser.getUserid();
		loggedPassword = objuser.getPassword();
		// check if the userName is already stored in the session
		if (sessionMap.containsKey("username")) {
			loggedUsername = (String) sessionMap.get("username");
			loggedPassword = (String) sessionMap.get("password");
			return SUCCESS;
		} else if (loggedUsername != null && loggedPassword != null) {
			// sessionMap.put("username", username);
			return SUCCESS;
		} else {
			return ERROR;
		}
	}

	// Strting method of the class
	public String execute() throws SQLException, IOException {
		// method for session getting and setting method
		String status = login();

		if (status.equals(SUCCESS)) {
			// checking username and password
			if (objuser.getPassword().length() == 0 && objuser.getUserid().length() == 0) {
				addActionError("Please Enter Username and password");
			} else if (objuser.getPassword().length() == 0) {
				addActionError("Password is required");
			} else if (objuser.getUserid().length() == 0) {
				addActionError("Username is required");
			} else if (!objuser.getUserid().isEmpty() && !objuser.getPassword().isEmpty()) {
				if (objLogic.validateUser(loggedUsername, loggedPassword, sessionMap)) {
					sessionMap.put("username", objuser.getUserid());
					sessionMap.put("password", objuser.getPassword());
					if (sessionMap.get("category").equals("user")) {
						// Calling the method of UserDataAction with parameter
						// of username
						objuser = objFetch.fetchUserData(loggedUsername);
						if (!objuser.equals(null)) {
							return "user";
						} else {
							addActionError("Something went wrong please contact admin");
						}
					} else {
						objuser = objFetch.fetchUserData(loggedUsername);
						list = objFetch.fetchAllUserData();
						if (!list.equals(null)) {
							return "success";
						} else {
							addActionError("Something went wrong please contact admin");
						}
					}
				}
			}
		} else {
			addActionError(Constants.incorrectUnamePass);
		}
		// return login if user unable to login into the system
		addActionError(Constants.incorrectUnamePass);
		return "login";
	}

	@Override
	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}
}
