package com.uks.jvs.jyoti.day8.assignment2;

/**
 * Class Name : ThreadDemo1 Description : threadDemo1 extends Thread class and
 * It contains run and start method
 *
 * @author Jyoti [01-07-2019]
 *
 */
public class ThreadDemo1 extends Thread {

	private Thread t;
	private String threadName;

	/**
	 * passing the name to cunstructor
	 *
	 * @param name
	 */
	ThreadDemo1(String name) {
		threadName = name;
		System.out.println("Creating " + threadName);
	}

	// It perform actual implementation
	public void run() {
		System.out.println("Running " + threadName);

		try {
			for (int i = 1; i < 5000; i++) {
				System.out.println("Thread: " + threadName + ", " + i);
				// Let the thread sleep for a while.
				if (i % 50 == 0) {
					Thread.sleep(100);
				}
			}
		} catch (InterruptedException e) {
			System.out.println("Thread " + threadName + " interrupted.");
		}
		System.out.println("Thread " + threadName + " exiting.");
	}

	// Start method start to printing the thread
	public void start() {
		System.out.println("Starting " + threadName);
		if (t == null) {
			t = new Thread(this, threadName);
			t.start();
		}
	}
}
