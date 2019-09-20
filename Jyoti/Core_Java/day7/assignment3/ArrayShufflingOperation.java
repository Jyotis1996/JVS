package com.uks.jvs.jyoti.day7.assignment3;

import java.util.Random;


/**
 * Class Name:ArrayShufflingOperation
 * Description:Shuffling Operation on Array
 * @author Jyoti [28-06-2019]
 */
public class ArrayShufflingOperation {
	/**
	 * Method Name:getUserArray
	 * Description:get the array elements from user &
	 * print randomly
	 * @param userArray
	 */

	public void getUserArray(String[] userArray) {
		String temp;
		int index;
		Random objRandom;
		try {
			objRandom = new Random();
			for (int i = userArray.length - 1; i > 0; i--) {
				index = objRandom.nextInt(i + 1);// Random index
				if (index != i) {
					temp = userArray[index];
					userArray[index] = userArray[i];
					userArray[i] = temp;
				}
			}
			System.out.println("String After Shuffling");
			for (int i = 0; i < userArray.length; i++) {
				System.out.println(userArray[i]);// print array randomly
			}
		} finally {
			objRandom = null;
		}
	}
}
