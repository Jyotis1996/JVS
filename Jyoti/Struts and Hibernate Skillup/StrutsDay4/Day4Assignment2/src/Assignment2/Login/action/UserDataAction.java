package Assignment2.Login.action;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import common.db_logic.DbLogic;
import Assignment2.Login.bean.LoginBean;
import Assignment2.Login.bean.UserDataBean;
import Assignment2.Login.logic.UserLogic;


/**
 * To fetch userdata from UserDataBean class
 * @author Jyoti Date-2019/09/04
 */
public class UserDataAction {

	//Initializing the objects
	DbLogic objDbLogic = new DbLogic();
	Connection con = null;
	UserDataBean objuser = new UserDataBean();
	LoginBean objbean = new LoginBean();
	UserLogic objLogic = new UserLogic();

	/**
	 * Description : get username from UserDataBean and call fetchUser method
	 * @param username
	 * @return
	 * @throws SQLException
	 * @throws IOException
	 */
	public UserDataBean fetchUserData(String username) throws SQLException, IOException {
		UserDataBean objBean;
		//calling fetchUser method by passing username as parameter
		objBean = objLogic.fetchUser(username);
		return objBean;
	}

	/**
	 * Description : it will fetch all user data and store to ArrayList
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<UserDataBean> fetchAllUserData() throws SQLException{
		//Calling method that return the arraylist of objects
		ArrayList<UserDataBean> list = new ArrayList<UserDataBean>();
		list = objLogic.fetchAllUsers();

		//returning list
		return list;
	}
}
