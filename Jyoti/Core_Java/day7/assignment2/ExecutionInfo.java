package com.uks.jvs.jyoti.day7.assignment2;

import java.io.IOException;

import com.uks.jvs.jyoti.day7.assignment1.FindInFilesMain;

/**
 * Class Name : ExecutionInfo Description : fetch the memory & time details of
 * program
 *
 * @author Jyoti [01-07-2019]
 *
 */
public class ExecutionInfo {

	public static void main(String args[]) throws IOException {
		long beforeUsedMemory;
		long startTime;
		long afterUsedMemory;
		long memUsedAfterGarbageCall;
		long endTime;

		try {

			// Total memory before using it for excution
			beforeUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

			// Statrting time of execution
			startTime = System.nanoTime();
			FindInFilesMain.main(args);

			// After execution free memory
			afterUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
			System.gc();

			// memmory used after calling garbage collector
			memUsedAfterGarbageCall = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
			endTime = System.nanoTime();

			// Print the parameters
			System.out.println("Memory used before execution: " + beforeUsedMemory);
			System.out.println("Memory used after program execution" + afterUsedMemory);
			System.out.println("\nMemory used after Manual call of garbage Collector: " + memUsedAfterGarbageCall);
			System.out.println("Time taken to execute above program: " + (endTime - startTime));

		} catch (IOException IOE) {
			IOE.printStackTrace();
		} finally {

		}

	}
}
