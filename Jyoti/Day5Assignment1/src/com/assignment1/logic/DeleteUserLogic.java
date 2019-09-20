package com.assignment1.logic;

import java.sql.Connection;
import java.sql.Statement;

import com.assignment1.Database.ConnectDB;

public class DeleteUserLogic {

	public int deleteRow(String UserName) {
		ConnectDB objConnectDB = null;
		Connection objConnection = null;
		Statement objStatement = null;
		String query="";
		int k=0;
		try {
			objConnectDB = new ConnectDB();
			objConnection=objConnectDB.connect();
			query="delete from UserDetails where USERID='" +UserName +"'";
			objStatement=objConnection.createStatement();
			k=objStatement.executeUpdate(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return k;
	}

}
