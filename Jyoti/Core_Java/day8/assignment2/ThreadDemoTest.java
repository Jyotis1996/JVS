package com.uks.jvs.jyoti.day8.assignment2;

/**
 * Class Name : ThreadDemoTest Description : class contains a main method
 *
 * @author Jyoti [01-07-2019]
 *
 */
public class ThreadDemoTest {

	/**
	 * In main class we create object of both class an called the respective
	 * start method.
	 *
	 * @param args
	 */
	public static void main(String args[]) {
		// object of the ThreadDemo1 class
		ThreadDemo1 objThreadDemo1 = new ThreadDemo1("Thread-1");
		objThreadDemo1.start();
		// object of the ThreadDemo2 class
		ThreadDemo2 objThreadDemo2 = new ThreadDemo2("Thread-2");
		objThreadDemo2.start();
	}

}
