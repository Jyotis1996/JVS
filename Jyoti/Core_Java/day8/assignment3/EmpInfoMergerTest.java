package com.uks.jvs.jyoti.day8.assignment3;

/**
 * Class Name : EmpInfoMergerTest Description : Main Class
 *
 * @author Jyoti [01-07-2019]
 *
 */
public class EmpInfoMergerTest {

	public static void main(String[] args) {

		// Create the objects of EmpInfoMerger class
		EmpInfoMerger objEmpInfoMerger1 = null;
		EmpInfoMerger objEmpInfoMerger2 = null;
		EmpInfoMerger objEmpInfoMerger3 = null;

		try {
			// Path of first file
			String path1 = ("D:\\JVS_WS\\coreJava\\src\\com\\uks\\jvs\\jyoti\\day8\\assignment3\\Name.txt");
			objEmpInfoMerger1 = new EmpInfoMerger(path1, "READ");

			// Starting first thread
			objEmpInfoMerger1.start();

			// Path of second file
			String path2 = ("D:\\JVS_WS\\coreJava\\src\\com\\uks\\jvs\\jyoti\\day8\\assignment3\\Address.txt");
			objEmpInfoMerger2 = new EmpInfoMerger(path2, "READ");
			Thread.sleep(100);
			// Starting second Thread
			objEmpInfoMerger2.start();

			System.out.println("Wait few time Merging data..");
			objEmpInfoMerger1.join();
			objEmpInfoMerger2.join();

			// Path of Third non Existing file
			String path3 = ("D:\\JVS_WS\\coreJava\\src\\com\\uks\\jvs\\jyoti\\day8\\assignment3\\Merged.txt");
			objEmpInfoMerger3 = new EmpInfoMerger(path3, "WRITE");

			// Starting third thread
			objEmpInfoMerger3.start();
			objEmpInfoMerger3.join();

			// Printing the result
			objEmpInfoMerger3.printData();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Release the objects
			objEmpInfoMerger1 = null;
			objEmpInfoMerger2 = null;
			objEmpInfoMerger3 = null;
		}

	}

}
