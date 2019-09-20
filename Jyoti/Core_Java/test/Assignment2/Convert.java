package com.uks.jvs.jyoti.test.Assignment2;

/**
 * Class Name :Convert Description :contains method to convert integer to binary
 *
 * @author Jyoti [04-07-2019]
 *
 */
public class Convert {

	int bin[] = new int[4], i = 0;

	/**
	 * Method name :binary Description :method to convert integer to binary
	 *
	 * @param num
	 */
	void binary(int num) {
		try {
			// if statement to check that number is uptil three digit or not
			if (num > 0 && num <= 999) {
				if (num > 0) {
					bin[i++] = num % 2;
					num = num / 2;
					binary(num);
				}

				// to print binary conversion
				for (i = i - 1; i >= 0; i--) {
					System.out.print(bin[i]);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
