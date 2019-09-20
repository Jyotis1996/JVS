package com.uks.Jyoti.core.day2.assignment1;

/**
 * Class Name:PopulateArray Description:Main Method Class use ArrayPopulation
 * Class
 *
 * @author Jyoti
 * @Created Date [19-06-2019]
 */

public class PopulateArray {

	public static void main(String[] args) {
		ArrayPopulation objarrayPopulation = null;
		try {
			// here array elements passed to two array
			int[] array1 = { 1, 2, 3, 4, 5 };
			int[] array2 = { 5, 6, 7, 8, 9 };
			int[] finalArray1 = new int[10];

			objarrayPopulation = new ArrayPopulation(); // object Initialization
			finalArray1 = objarrayPopulation.populateArray(array1, array2);
			// Pass array1 and array2 as parameters to populateArray method

			objarrayPopulation.print(finalArray1);
			// print method is called here for display resultant array

		} catch (ArrayIndexOutOfBoundsException objArrayIndexOutOfBoundsException) {
			// Exception is handled here

			System.out.println("Enter proper");

		} finally {

			objarrayPopulation = null;
		}

	}

}