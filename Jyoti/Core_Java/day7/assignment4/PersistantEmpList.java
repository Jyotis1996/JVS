package com.uks.jvs.jyoti.day7.assignment4;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;

/**
 * Class Name : PersistentEmpList Description - Store the Employee Details in
 * Hash table and also perform Serialization and De-Serialization
 *
 * @author Jyoti [01-07-2019]
 */
public class PersistantEmpList {
	/**
	 * Method Name : storeInCollection Description - The storeInCollection
	 * method is used to add each employee data in HashTable
	 *
	 * @param objArrayList
	 */
	public void storeInCollection(ArrayList<EmployeeDetail> objArrayList) {
		Map<Integer, EmployeeDetail> objMap = null;
		int keys;
		try {

			objMap = new Hashtable<Integer, EmployeeDetail>();
			for (EmployeeDetail objDetails : objArrayList) {
				keys = 0;
				objMap.put(keys, objDetails);
				for (int keys1 : objMap.keySet()) {
					System.out.println("Employee Name  : " + objMap.get(keys1).getempName());
					System.out.println("Employee Age  :" + objMap.get(keys1).getempAge());
					System.out.println("Employee Salary : " + objMap.get(keys1).getempSalary());
					System.out.println("----------------------------------------------------");
					keys++;
				}
			}
		} finally {
		}
	}

	/**
	 * Method Name : serializeExec description - Method use to Serialized data
	 * in hash table
	 *
	 * @param objArrayList
	 * @throws IOException
	 */


	public void serializeExec(ArrayList<EmployeeDetail> objArrayList) throws IOException {
		FileOutputStream objFileOutputStream;
		ObjectOutputStream objObjectOutputStream;
		try {

			objFileOutputStream = new FileOutputStream(
					"D:\\JVS_WS\\coreJava\\src\\com\\uks\\jvs\\jyoti\\day7\\assignment4\\SerializeData.ser");
			objObjectOutputStream = new ObjectOutputStream(objFileOutputStream);
			objObjectOutputStream.writeObject(objArrayList);
			System.out.println("Save Your Data Successfully....!!!");
		} catch (Exception ae) {
			System.out.println("Error is:" + ae);
		}
	}

	/**
	 * * Method Name - deSerializeExec Description - Method Perform
	 * De-Serialization of Data in hash table
	 *
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	@SuppressWarnings("unchecked")
	public void deSerializeExec() throws IOException, ClassNotFoundException {
		ArrayList<EmployeeDetail> objArrayList = null;
		FileInputStream objFileInputStream = null;
		ObjectInputStream objObjectInputStream = null;
		try {
			objFileInputStream = new FileInputStream(
					"D:\\JVS_WS\\coreJava\\src\\com\\uks\\jvs\\jyoti\\day7\\assignment4\\SerializeData.ser");
			objObjectInputStream = new ObjectInputStream(objFileInputStream);
			System.out.println("After desrialization output is :");
			System.out.println("...your data in deserialized from..." + objFileInputStream);
			objArrayList = (ArrayList<EmployeeDetail>) objObjectInputStream.readObject();
			for (EmployeeDetail objEmployeeDetails : objArrayList) {
				System.out.println("------Employee Detail---------");
				System.out.println("Employee First Name:" + objEmployeeDetails.getempName());
				System.out.println("Employee Age: " + objEmployeeDetails.getempAge());
				System.out.println("Employee Salary: " + objEmployeeDetails.getempSalary());
				System.out.println("------------------------------------");
			}
		} finally {
			objObjectInputStream.close();
			objFileInputStream.close();
		}
	}
}
