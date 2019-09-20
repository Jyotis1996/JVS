package com.uks.jvs.jyoti.day5.assignment3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.List;
import java.util.Map;

/**
 * Class Name:EmployeeDetailsReader Description:Display Data from file
 *
 * @author Jyoti [27-06-2019]
 */
public class EmployeeDetailsReader {
	/**
	 * Method Name:getLastName Description:get the file & read the File
	 * Contents,Display on Console
	 *
	 * @param Lastname
	 * @throws IOException
	 * @throws NullPointerException
	 */
	public void getLastName(String[] Lastname) throws IOException, NullPointerException {
		BufferedReader objReader = null;
		final String DELIMITER = ",";
		int i = 0;
		EmployeeProperties objProperties = null;
		ArrayList<EmployeeProperties> objArrayList;
		Map<Object, List<EmployeeProperties>> objMap = null;
		try {
			objArrayList = new ArrayList<EmployeeProperties>();
			objMap = new TreeMap<Object, List<EmployeeProperties>>();
			String line = "";
			String filePath = "D:\\JVS_WS\\coreJava\\src\\com\\uks\\jvs\\jyoti\\day5\\assignment3\\Employee.csv";
			objReader = new BufferedReader(new FileReader(filePath));
			while ((line = objReader.readLine()) != null) {
				objProperties = new EmployeeProperties();
				String[] words = line.split(DELIMITER);
				if (Lastname[0].equals(words[2])) {
					objProperties.setFirstName(words[1]);
					objProperties.setLastName(words[2]);
					objProperties.setEmpType(words[3]);
					objProperties.setBasicSalary(Long.parseLong(words[4]));
					objArrayList.add(objProperties);
					objMap.put(words[0], objArrayList);
				}
			}
			if (!objMap.isEmpty()) {
				for (Map.Entry<Object, List<EmployeeProperties>> entry : objMap.entrySet()) {
					System.out.println("Employee[" + (i + 1) + "]:" + entry.getKey());
					System.out.println("Name:" + entry.getValue().get(i).getFirstName() + " "
							+ entry.getValue().get(i).getLastName());
					System.out.println("Employee Type:" + entry.getValue().get(i).getEmpType());
					System.out
							.println(
									"Salary:"
											+ (entry.getValue().get(i).getBasicSalary()
													+ (((entry.getValue().get(i).getBasicSalary()) * 12.5) / 100))
											+ "\n");
					i++;
				}
			} else {
				System.out.println("No record to display");
			}
		} finally {
			objReader.close();
			objArrayList = null;
			objReader = null;
			objProperties = null;
			objMap = null;
		}
	}
}
