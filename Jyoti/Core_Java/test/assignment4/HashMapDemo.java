package com.uks.jvs.jyoti.test.assignment4;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * ClassName : HashMapDemo Descriptionn:Sort contents in hashmap using empcode
 * as key
 *
 * @author Jyoti [05-07-2019]
 *
 */
class HashMapDemo {

	public static void main(String[] args) {

		Map<Integer, String> objMap = new HashMap<Integer, String>();
		// Enter contents in hash map
		objMap.put(101, "asd");
		objMap.put(100, "cfd");
		objMap.put(90, "gdf");
		objMap.put(115, "qwe");
		objMap.put(166, "weq");
		objMap.put(113, "wer");
		objMap.put(118, "yes");
		objMap.put(293, "nsa");
		objMap.put(150, "tes");
		objMap.put(112, "mds");
		objMap.put(243, "fsa");

		// Print the Elements of the Map before Sorting
		System.out.println("Elements of the HashMap before Sorting");
		printMap(objMap);

		// Create a Treemap of objMap to get it sorted
		Map<Integer, String> sortedMap = new TreeMap<Integer, String>(objMap);

		// Print the Elements of the Map after Sorting
		System.out.println("Elements of the HashMap after Sorting");
		printMap(sortedMap);

	}

	/**
	 * Method Name : printMap Description : print the contents of hashmap
	 *
	 * @param map
	 */
	public static void printMap(Map<Integer, String> map) {
		System.out.println("**************************************");
		for (Map.Entry<Integer, String> entry : map.entrySet()) {
			System.out.println("Employee Code : " + entry.getKey() + " Name : " + entry.getValue());
		}
		System.out.println();
	}
}
