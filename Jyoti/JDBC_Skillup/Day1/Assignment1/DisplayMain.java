package com.uks.jvs.Jyoti.Day1.Assignment1;

import java.sql.SQLException;

/**
 * Class Name:DisplayMain Description:Main method class to call RecordDisplay
 * class
 *
 * @author Jyoti [19/07/2019]
 *
 */
public class DisplayMain {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		@SuppressWarnings("unused")
		RecordDisplay objRecordDisplay = null;
		try {
			objRecordDisplay = new RecordDisplay();// methods call
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			objRecordDisplay = null;
		}
	}
}
