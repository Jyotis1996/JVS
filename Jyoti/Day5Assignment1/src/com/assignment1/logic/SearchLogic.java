package com.assignment1.logic;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.assignment1.Database.ConnectDB;
import com.assignment1.bean.UserListBean;

public class SearchLogic {

	public ArrayList<UserListBean> getList(String input) {

		Connection objConnection = null;
		ConnectDB objConnectDB = null;
		ResultSet objResultSet = null;
		Statement objStatement = null;
		ArrayList<UserListBean> objArrayList = null;
		UserListBean objUserListBean = null;
		try {
			objArrayList = new ArrayList<>();
			objConnectDB = new ConnectDB();
			// call connect method for database connection
			objConnection = objConnectDB.connect();
			//String sql = "select * from UserDetails";
			objStatement = objConnection.createStatement();
			objResultSet = objStatement.executeQuery(input);
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
				objUserListBean.setAddress(objResultSet.getString(10));
				objUserListBean.setCategory(objResultSet.getString(13));
				objArrayList.add(objUserListBean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objArrayList;
	}
}
