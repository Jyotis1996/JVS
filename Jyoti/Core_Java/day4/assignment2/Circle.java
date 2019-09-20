package com.uks.jvs.jyoti.day4.assignment2;

/**
 * Class Name:Circle Description : Method overloading
 *
 * @author Jyoti [24-06-2019]
 *
 */
public class Circle {

	private final double PI = 3.14;

	/**
	 * Method Name:getArea Description:Find the Area of Circle where type of
	 * radius is double
	 *
	 * @param doubleRadius
	 */
	void getArea(double doubleRadius) {
		try {
			double Area;
			Area = PI * (doubleRadius * doubleRadius);
			System.out.println("Area of circle [ r = 5.6] " + Area);
		} finally {

		}
	}

	/**
	 * Method Name:getArea Description:Find the Area of Circle where type of
	 * radius is long
	 *
	 * @param longRadius
	 */
	void getArea(long longRadius) {
		try {
			double Area;
			Area = PI * (longRadius * longRadius);
			System.out.println("Area of circle [ r = 3] " + Area);
		} finally {

		}
	}

	/*
	 * Main method to call methods of Circle class
	 */
	public static void main(String[] args) {

		Circle objCircle = null;
		try {
			objCircle = new Circle();
			objCircle.getArea(5.6);
			objCircle.getArea(3);
		} catch (Exception ex) {

		} finally {
			objCircle = null;
		}
	}

}
