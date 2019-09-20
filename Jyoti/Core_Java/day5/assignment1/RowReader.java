package com.uks.jvs.jyoti.day5.assignment1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Class Name : RowReader description -class read file form file path and set
 * value in constructor of General employee
 *
 * @author Jyoti [28-06-2019]
 */
public class RowReader {
	/**
	 * Method Name : showDetails description - method read the file
	 *
	 * @param path
	 * @return ArrayList
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	public ArrayList<BaseEmployee> showDetails(String path) throws NumberFormatException, IOException {

		String line = null;
		BufferedReader stream = null;
		ArrayList<BaseEmployee> csvData = null;
		StringTokenizer objStringTokenizer = null;
		try {
			// instantiate ArrayList
			csvData = new ArrayList<BaseEmployee>();
			stream = new BufferedReader(new FileReader(path));
			// read the whole file data and store it into arraylist
			while ((line = stream.readLine()) != null) {
				objStringTokenizer = new StringTokenizer(line, ",");
				while (objStringTokenizer.hasMoreTokens()) {
					csvData.add(new GeneralEmployee(objStringTokenizer.nextToken(), objStringTokenizer.nextToken(),
							objStringTokenizer.nextToken(), objStringTokenizer.nextToken(),
							Double.parseDouble(objStringTokenizer.nextToken())));
				}
			}
		} finally {
			stream.close();
			line = null;
			objStringTokenizer = null;
		}
		return csvData;
	}
}
