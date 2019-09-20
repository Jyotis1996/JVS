package com.uks.jyoti.struts.day2.a1.action;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.uks.jyoti.struts.day2.a1.bean.LoginBean;
import com.uks.jyoti.struts.day2.a1.bean.UserDataBean;
import com.uks.jyoti.struts.day2.a1.logic.UserLogic;

public class UserDataAction {

	/**
	 * This class is use for user data action
	 */

	Connection con = null;
	UserDataBean objuser = new UserDataBean();
	LoginBean objbean = new LoginBean();
	UserLogic objLogic = new UserLogic();

	public UserDataBean fetchUserData(String username) throws SQLException, IOException {

		UserDataBean objBean;
		// calling fetchUser method by passing usernmae as parameter
		objBean = objLogic.fetchUser(username);
		return objBean;
	}

	public List<UserDataBean> fetchAllUserData() throws SQLException {
		try {
			// Calling method that return the arraylist of objects
			List<UserDataBean> list = objLogic.fetchAllUsers();

			// returning list
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
