package com.uks.jvs.Jyoti.Day1.Assignment2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;

/**
 * Class Name:DisplayMain Description:Main method class to call DisplayRecords
 * class
 *
 * @author Jyoti [22/07/2019]
 *
 */

@SuppressWarnings("unused")
public class DisplayMain {
	// main()
	public static void main(String[] args) throws Exception {

		Connection objconnection = null;
		DisplayRecords objDisplayRecords = null;

		try {
			objDisplayRecords = new DisplayRecords();
			objconnection = objDisplayRecords.connect();
			// create objRecordDisplay object to call
			// connects(),dispalysRecords(),disconnect() methods
			objDisplayRecords.displayRecords();
			objDisplayRecords.filterData();

		} catch (Exception e) {
			System.out.println("Please Check database credentials");

		} finally {
			objconnection = null;
			objDisplayRecords = null;

		}
	}
}
