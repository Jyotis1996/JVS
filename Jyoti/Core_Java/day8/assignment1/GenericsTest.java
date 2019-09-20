
package com.uks.jvs.jyoti.day8.assignment1;

import java.util.HashMap;
import java.util.Map;

/**
 * Class Name : GenericsTest
 * Description : Generics in java
 * @author Jyoti [02-07-2019]
 *
 */
public class GenericsTest {
	Map<Long, String> map = new HashMap<Long, String>();

	/**
	 * Method Name : addToDictionary
	 * Description : Add data dynamically
	 * @param number
	 * @param name
	 */
	void addToDirectory(Long number, String name){
		map.put(number, name);
	}

	/**
	 * Method name :addToDir
	 * Description : predefine some data into HashMap
	 */
	void addToDir(){
		//Hashmap add the elements initially
		map.put(9987123456l, "Jacob");
		map.put(9819123456l, "Jenny");
	}

	/**
	 * Method Name : searchMobile
	 * Description : search details from mobile number
	 * @param key
	 */
	void searchMobile(long key){
		String value = map.get(key);
		System.out.println("Entered mobile number "+ key + "  belongs to:" + value);
	}

	/**
	 * Method name : printAll
	 * Description : print the elements of hashmap
	 */
	@SuppressWarnings("rawtypes")
	void printAll(){
		int i = 1;
		for( Map.Entry entry : map.entrySet() ) {
		    long key = (long) entry.getKey();
		    String value = (String) entry.getValue();
		    System.out.println("("+i+")" + "Name: " + value);
		    System.out.println("Mobile: " + key);
		    i += 1;
		}

	}
}
