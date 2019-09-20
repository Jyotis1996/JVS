package com.uks.Jyoti.core.day4.assignment5;

/**
 * Class Name : FrequencyCount Description : Main Method class to call method of
 * FrequencyCheck class
 *
 * @author Jyoti [25-06-2019]
 *
 */
public class FrequencyCount {

	public static void main(String[] args) {
		FrequencyCheck objCheck;
		try {
			objCheck = new FrequencyCheck();
			objCheck.countFrequency(args);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			objCheck = null;
		}
	}

}
