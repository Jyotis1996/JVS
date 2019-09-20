package com.assignment1.logic;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.assignment1.Database.ConnectDB;
import com.assignment1.bean.UserListBean;

public class UserListLogic {

	public ArrayList<UserListBean> getUserList() throws SQLException {
		Connection objConnection = null;
		ConnectDB objConnectDB = null;
		ResultSet objResultSet = null;
		Statement objStatement = null;
		ArrayList<UserListBean> objArrayList = null;
		UserListBean objUserListBean = null;

		try {
			// initialize the object of ArrayList
			objArrayList = new ArrayList<>();
			// initialize the object of ConnectDB class
			objConnectDB = new ConnectDB();
			// call connect method for database connection
			objConnection = objConnectDB.connect();
			// Sql Query
			String sql = "select * from userdetails Order BY USERID ASC";
			objStatement = objConnection.createStatement();
			// Execute the Query
			objResultSet = objStatement.executeQuery(sql);
			// Loop till resultSet has records
			while (objResultSet.next()) {
				// initialize the object of UserDataBean class
				objUserListBean = new UserListBean();
				// get data from Result set and set to the USerdatabean object
				objUserListBean.setUserName(objResultSet.getString(1));
				objUserListBean.setPassword(objResultSet.getString(2));
				objUserListBean.setSalutation(objResultSet.getString(3));
				objUserListBean.setFirstName(objResultSet.getString(4));
				objUserListBean.setMiddleInitial(objResultSet.getString(5));
				objUserListBean.setLastName(objResultSet.getString(6));
				objUserListBean.setGender(objResultSet.getString(7));
				objUserListBean.setEmail(objResultSet.getString(8));
				String[] date = objResultSet.getString(9).split("/");
				objUserListBean.setBirthDate(date[0].trim());
				objUserListBean.setBirthMonth(date[1].trim());
				objUserListBean.setBirthYear(date[2].trim());
				objUserListBean.setAddress(objResultSet.getString(10));
				objUserListBean.setAreaOfInterest(objResultSet.getString(11));
				objUserListBean.setOtherInterest(objResultSet.getString(12));
				objUserListBean.setCategory(objResultSet.getString(13));
				objArrayList.add(objUserListBean);
			}
		} catch (Exception e) {
			System.out.println("Error Occurred....." + e.getLocalizedMessage());
		} finally {
			// Close the objects
			objConnection.close();
			objResultSet.close();
			objStatement.close();
		}
		// return the ArrayList Object
		return objArrayList;
	}

}
