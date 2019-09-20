package com.uks.jvs.Jyoti.Day4.Assignment2;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import com.uks.jvs.Jyoti.Constants;
import com.uks.jvs.Jyoti.Day1.Assignment3.PropertyUtil;

/**
 * Class Name:MetaDataDatabse Description:get the information or MetaData
 *
 * @author Jyoti [26/07/2019]
 */
public class MetaDataDatabse {
	/**
	 * Method Name:main Description:get the connection & records from
	 * database,fetch the MetaData of Database & ResultSet
	 */
	public static void main(String[] args) throws SQLException {
		Connection objConnection = null;
		DatabaseMetaData objDatabaseMetaData = null;
		PreparedStatement objPreparedStatement = null;
		ResultSet objResultSet = null;
		ResultSetMetaData objResultSetMetaData = null;
		PropertyUtil objPropertyUtil = null;
		try {
			objPropertyUtil = new PropertyUtil();
			// connection open
			objConnection = objPropertyUtil.connect();
			objDatabaseMetaData = objConnection.getMetaData();
			System.out.println(Constants.strDatabaseMetadata);
			// DataBase MetaData
			System.out.println(Constants.DriverName + objDatabaseMetaData.getDriverName());
			System.out.println(Constants.DriverVersion + objDatabaseMetaData.getDriverVersion());
			System.out.println(Constants.UserName + objDatabaseMetaData.getUserName());
			System.out.println(Constants.DatabaseName + objDatabaseMetaData.getDatabaseProductName());
			System.out.println(Constants.DatabaseVersion + objDatabaseMetaData.getDatabaseProductVersion());
			objPreparedStatement = objConnection.prepareStatement(Constants.Query_Ass4_2);
			objResultSet = objPreparedStatement.executeQuery();
			objResultSetMetaData = objResultSet.getMetaData();
			System.out.println(Constants.strseparatorline);
			System.out.println(Constants.strResultSetMetadata);
			// ResultSet MetaData
			System.out.println(Constants.TotalColumns + objResultSetMetaData.getColumnCount());
			System.out.println(Constants.ColumnName + objResultSetMetaData.getColumnName(1));
			System.out.println(Constants.ColumnType + objResultSetMetaData.getColumnTypeName(1));
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			objDatabaseMetaData = null;
			objResultSet = null;
			objResultSetMetaData = null;
		}
	}
}
