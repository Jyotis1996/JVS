package com.uks.jvs.Jyoti.Day3.Assignment2;

/**
 * Class Name : InsertIntoResultSetMain Description : Main Class
 *
 * @author Jyoti [24/07/2019]
 *
 */
public class InsertIntoResultSetMain {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		// Creating object and calling method for operation
		InsertIntoResultSet objInsertIntoResultSet = new InsertIntoResultSet();
		objInsertIntoResultSet.connect();
		objInsertIntoResultSet.inserInto();
		objInsertIntoResultSet.disconnect();
	}

}
