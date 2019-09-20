package com.uks.Jyoti.core.day2.assignment1;

/**
 * Class Name:ArrayPopulation Description:Merge two arrays
 *
 * @Author Jyoti
 * @Created Date [19-06-2019]
 */
public class ArrayPopulation {

	int finalArray[] = new int[10]; // final array for storing resultant array

	/**
	 * Method Name:populateArray Description:Get the two arrays and Arrange all
	 * elements in specific position
	 *
	 * @param array1
	 * @param array2
	 * @return finalArray
	 */

	public int[] populateArray(int[] array1, int array2[]) {
		// two integer variable declared and initialize here
		int j = 0;
		int k = 0;
		for (int i = 0; i < 10; i++) {
			if (i % 2 != 0) // elements checked here that is odd elements or
							// even elements
			{
				finalArray[i] = array2[k];
				k++; // increment the k counter of array

			} else {
				finalArray[i] = array1[j];
				j++; // increment the j counter of array
			}
		}
		return finalArray; // here the final array which is combination of both
							// odd and even declared here

	}

	/**
	 * Method Name:print Description:Print the resultant Array
	 *
	 * @param finalArray
	 */

	public void print(int[] finalArray) // print method is used for displaying
										// resultant array
	{
		for (int i : finalArray) {
			System.out.println(i); // here we print the final array

		}

	}

}
