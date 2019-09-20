package com.uks.jvs.jyoti.day8.assignment3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Class Name : EmpInfoMerger Description : Merge contents of two files using
 * Thread
 *
 * @author Jyoti [01-07-2019]
 *
 */
public class EmpInfoMerger extends Thread {
	private String filePath = null;
	private String mode = null;
	private static StringBuffer sharedVariable = new StringBuffer();

	// here we defined class constructor
	public EmpInfoMerger(String filePath, String mode) {
		this.filePath = filePath;
		this.mode = mode;
	}

	/**
	 *
	 * The method is used to write a data to resource variable
	 *
	 * @throws IOException
	 * @throws InterruptedException
	 */

	@SuppressWarnings("resource")
	public synchronized void writeToResource() throws IOException, InterruptedException {
		// Create the objects
		String line = null;
		// define string buffer
		StringBuffer tempBuffer = null;
		// file input stream object
		FileInputStream objFileInputStream = null;
		BufferedReader objBufferedReader = null;
		int i = 1;
		try {

			// get file
			objFileInputStream = new FileInputStream(filePath);
			// Read file into buffered reader
			objBufferedReader = new BufferedReader(new InputStreamReader(objFileInputStream));
			// read data from file
			while ((line = objBufferedReader.readLine()) != null) {
				String name = this.getName();
				if (name.equalsIgnoreCase("Thread-0")) {
					tempBuffer = new StringBuffer();
					// Append into buffer
					tempBuffer.append(i + ") " + line);
					i++;
				} else {
					tempBuffer = new StringBuffer();
					// Append into buffer
					tempBuffer.append(line);
				}

				// Write into shared Variable
				sharedVariable.append(tempBuffer + System.lineSeparator());

				// making sleep current thread
				Thread.sleep(1000);

			}

		} finally {
			objFileInputStream = null;

		}
	}

	/**
	 * here method defines for write a file
	 *
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public synchronized void writeToFile() throws IOException, InterruptedException {
		// Create objects
		FileWriter objFileWriter = null;
		String data = null;
		File file = null;
		try {
			// initialize the object of file class
			file = new File(filePath);
			// Check file exists or not else create new file
			if (!file.exists()) {
				file.createNewFile();
			}
			// Initialize the object of FileWriter
			objFileWriter = new FileWriter(file);

			// Looping to write the data into file
			if (sharedVariable != null) {
				// Stored data of shared variable into String variable
				data = sharedVariable.toString();
				// Write the data into file
				objFileWriter.write(data + "		");
			}
		} finally {

			objFileWriter.close();
			sharedVariable = null;
			Thread.sleep(2000);

		}
	}

	/**
	 * this method is used to print the data
	 *
	 * @throws IOException
	 * @throws InterruptedException
	 */

	public void printData() throws IOException, InterruptedException {

		BufferedReader objBufferedReader = null;
		FileInputStream objFileInputStream = null;
		String line = null;
		try {

			objFileInputStream = new FileInputStream(filePath);
			objBufferedReader = new BufferedReader(new InputStreamReader(objFileInputStream));
			System.out.println("Printing Data from file.. \n");
			// Loop until it has data
			while ((line = objBufferedReader.readLine()) != null) {
				System.out.println(line);
				// Sleep thread for 2 seconds
				Thread.sleep(2000);
			}
			System.out.println("Printing Data Complete ");

		} finally {

			objFileInputStream.close();

		}

	}

	public void run() {
		try {
			// in case of read mode
			if (mode.equalsIgnoreCase("READ")) {
				writeToResource();
			}
			// in case of write mode
			else if (mode.equalsIgnoreCase("WRITE")) {
				writeToFile();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
