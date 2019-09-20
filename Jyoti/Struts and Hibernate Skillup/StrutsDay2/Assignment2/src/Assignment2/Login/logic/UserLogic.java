package Assignment2.Login.logic;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import common.db_logic.DbLogic;
import common.util.Constants;
import Assignment2.Login.bean.UserDataBean;

/**
 * user logic class to fetch users data from database
 *
 * @author Jyoti Date-2019/09/04
 */
public class UserLogic {
	// Initilizing the objects
	DbLogic objDbLogic = new DbLogic();
	Connection con = null;
	UserDataBean objuser = new UserDataBean();
	SimpleDateFormat dateFormat = null;
	Calendar calendar = null;

	public UserDataBean fetchUser(String userid) throws SQLException {
		// UserDataBean objuser=null;
		try {
			con = objDbLogic.connect();
			Statement stmt = con.createStatement();
			// Executing the query
			ResultSet rs = stmt.executeQuery(Constants.QUERY_ASS2 + userid + "'");

			// cheking records are available or not
			while (rs.next()) {

				// Setting the value through the setter method
				objuser.setFirstName(rs.getString(1));
				objuser.setMiddleName(rs.getString(2));
				objuser.setLastName(rs.getString(3));
				objuser.setSex(rs.getString(4));
				objuser.setEmailId(rs.getString(5));
				objuser.setBirthDate(rs.getString(6));
				objuser.setAddress(rs.getString(7));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// retuns the object of UserDataBean class
		return objuser;
	}

	public ArrayList<UserDataBean> fetchAllUsers() throws SQLException {
		ArrayList<UserDataBean> list = new ArrayList<UserDataBean>();

		con = objDbLogic.connect();
		Statement stmt = con.createStatement();
		// Executin gthe query
		ResultSet rs = stmt.executeQuery(Constants.QUERY_ASS_TWO);

		// cheking records are available or not
		while (rs.next()) {
			// Creating object here for storing multiple objects and returns it
			UserDataBean objuser = new UserDataBean();
			// Setting the value through the setter method
			objuser.setFirstName(rs.getString(4));
			objuser.setMiddleName(rs.getString(5));
			objuser.setLastName(rs.getString(6));
			objuser.setSex(rs.getString(7));
			objuser.setEmailId(rs.getString(8));
			objuser.setBirthDate(rs.getString(9));
			objuser.setAddress(rs.getString(10));

			// Adding data into the arraylist
			list.add(objuser);
		}

		// Returning the arraylist of objects
		return list;
	}
}
