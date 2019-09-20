package com.uks.jvs.jyoti.day7.assignment4;

import java.util.ArrayList;

/**
 * Class Name : ShowEmployeeDetails Description - Execute Main Method
 *
 * @author Jyoti [28-06-2019]
 */
public class ShowEmployeeDetails {
	/**
	 * Method Name : Main method Description - call PersistantEmpList and
	 * StoreObject Class
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		PersistantEmpList objPersistantEmpList = null;
		StoreObject objStoreObject = null;
		ArrayList<EmployeeDetail> objArrayList;
		try {
			objPersistantEmpList = new PersistantEmpList();
			objStoreObject = new StoreObject();
			objArrayList = objStoreObject.getDetails();
			objPersistantEmpList.storeInCollection(objArrayList);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			objStoreObject = null;
			objArrayList = null;
		}
	}
}
