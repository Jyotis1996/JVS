
package com.uks.jvs.Jyoti.Day3.Assignment1;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import javax.sql.rowset.WebRowSet;

import com.uks.jvs.Jyoti.Day1.Assignment3.PropertyUtil;
import com.uks.jvs.Jyoti.Constants;

/**
 * Class Name:DataFetcher Descriptiopn :In this class function are written to
 * execute query either in cached method or XML method
 *
 * @author Jyoti [24/07/2019]
 *
 */
public class DataFetcher {

	String command, dataSourceName;
	Connection objConnection = null;
	PropertyUtil objPropertyUtil = new PropertyUtil();

	/**
	 * method to establish database connection
	 *
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	void connect() throws ClassNotFoundException, SQLException {
		try {
			objConnection = objPropertyUtil.connect();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
	}

	// For display the data using the Cached method
	CachedRowSet executeInCached() throws SQLException {
		Statement stmt = objConnection.createStatement();
		ResultSet rs = stmt.executeQuery(Constants.Query);
		RowSetFactory factory = RowSetProvider.newFactory();
		CachedRowSet rowSet = factory.createCachedRowSet();
		rowSet.populate(rs);
		objConnection.close();
		return rowSet;
	}

	// For display the data using the WebRowSet method
	WebRowSet executeInXML() throws SQLException {
		RowSetFactory factory = RowSetProvider.newFactory();
		WebRowSet webRowSet = factory.createWebRowSet();
		webRowSet.setCommand(Constants.Query);
		webRowSet.execute(objConnection);
		objConnection.close();
		return webRowSet;
	}

	// For discconeting the Database
	void disconnect() throws Exception {
		objPropertyUtil.disconnect();
	}
}
