package com.uks.jvs.jyoti.day4.assignment5;

import java.util.Map;
import java.util.TreeMap;

/**
 * Class Name : FrequencyCheck Description : Check the frequency of the entered
 * word as CommandLine argument
 *
 * @author Jyoti [25-06-2019]
 *
 */
public class FrequencyCheck {

	/**
	 * Method Name :countFrequency() Description : check the frequency of
	 * repetition of entered words
	 *
	 * @param argument
	 */
	public void countFrequency(String[] argument) {
		Map<String, Integer> objMap;
		try {
			if (argument.length != 0) { //if statement to check whether argument is entered or not
				objMap = new TreeMap<String, Integer>();
				for (String Words : argument) {
					Integer frequency = objMap.get(Words);
					objMap.put(Words, (frequency == null ? 1 : frequency + 1));
				}
				System.out.println(objMap);
			} else {
				System.out.println("Please Enter Arguments");
			}
		} finally {
			objMap = null;
		}
	}
}
