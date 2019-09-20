package com.assignment1.logic;

import java.sql.Connection;
import java.sql.Statement;

import com.assignment1.Database.ConnectDB;
import com.assignment1.common.Constants;

/**
 * Delete logic to delete checked row from databasse
 * @author Jyoti Date-2019/09/09
 *
 */
public class DeleteUserLogic {

	/**
	 * Delet row from database using userid
	 * @param UserName
	 * @return
	 */
	public int deleteRow(String UserName) {
		ConnectDB objConnectDB = null;
		Connection objConnection = null;
		Statement objStatement = null;
		String query="";
		int k=0;
		try {
			objConnectDB = new ConnectDB();
			objConnection=objConnectDB.connect();
			query=Constants.DELETE_QUERY +UserName +"'";
			objStatement=objConnection.createStatement();
			k=objStatement.executeUpdate(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return k;
	}

}
