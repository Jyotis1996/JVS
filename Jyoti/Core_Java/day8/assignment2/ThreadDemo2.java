package com.uks.jvs.jyoti.day8.assignment2;

/**
 * Class Name : ThreadDemo2 Description : class implements runnable interface
 * and print the value 1 to 500
 *
 * @author Jyoti [01-07-2019]
 *
 */
public class ThreadDemo2 implements Runnable {
	private Thread t;
	private String threadName;

	/**
	 * pass the name to the constructor
	 *
	 * @param name
	 */
	ThreadDemo2(String name) {
		threadName = name;
		System.out.println("Creating " + threadName);
	}

	/**
	 * Run method contains actual implementation
	 */
	public void run() {
		System.out.println("Running " + threadName);
		try {
			for (int i = 0; i < 5000; i++) {
				System.out.println("Thread: " + threadName + ", " + i);
				// Let the thread sleep for a while.
				if (i % 75 == 0) {
					Thread.sleep(200);
				}

			}
		}
		// exception is catched here
		catch (InterruptedException e) {
			System.out.println("Thread " + threadName + " interrupted.");
		}
		System.out.println("Thread " + threadName + " exiting.");
	}

	/**
	 * start method is default method which start the printing thread
	 */
	public void start() {
		System.out.println("Starting " + threadName);
		if (t == null) {
			t = new Thread(this, threadName);
			t.start();
		}
	}
}
