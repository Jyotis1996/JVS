package com.uks.jvs.jyoti.day9.assignment1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * Class Name : UserInteraction Description : To perform loader and finder
 * process
 *
 * @author Jyoti
 *
 */
public class UserInteraction {
	static Scanner objScanner = null;

	/**
	 * @description : this method calls loader and finder processes
	 * @param args
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException, InterruptedException {

		UserInteraction objInteraction = null;

		try {
			objInteraction = new UserInteraction();
			// to welcome user
			objInteraction.welcome();
			// to load data files
			objInteraction.loaderProcess();
			// to perform search
			objInteraction.finderProcess();
		} catch (Exception e) {
			// System.out.println("File Not found");
			System.out.println(e);
		} finally {
			objInteraction = null;
		}
	}

	/**
	 * @description : this method welcomes user
	 */
	private void welcome() {
		System.out.println("--------------Welcome--------------");
	}

	/**
	 * @description : this method reads configuration and loads data into memory
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws InterruptedException
	 */
	private void loaderProcess() throws FileNotFoundException, IOException, InterruptedException {
		ThreadGroup loaderProcess = null;
		DisplayInfo objEmpInfoMerger = null;
		DisplayInfo objEmpInfoMerger2 = null;
		DisplayInfo objEmpInfoMerger3 = null;

		String UserInfo = null;
		String UserLoginInfo = null;

		try {
			// loaderProcess thread group
			loaderProcess = new ThreadGroup("LOADER_PROCESS");
			// getting file1 path by reading configuration file
			UserInfo = ReadConfiguration.readNameFile();
			// getting file2 path by reading configuration file
			UserLoginInfo = ReadConfiguration.readAddressFile();
			// craeting read mode constructor with threadgroup
			objEmpInfoMerger = new DisplayInfo(UserInfo, loaderProcess, "read");
			// read mode constructor with threadgroup
			objEmpInfoMerger2 = new DisplayInfo(UserLoginInfo, loaderProcess, "read");
			// write mode constructor with threadgroup
			objEmpInfoMerger3 = new DisplayInfo("", loaderProcess, "write");

			// starting one thread
			objEmpInfoMerger.start();

			Thread.sleep(20);
			// starting second thread
			objEmpInfoMerger2.start();
			objEmpInfoMerger2.join();

			// starting third thread
			objEmpInfoMerger3.start();
			objEmpInfoMerger3.join();
		} finally {
			loaderProcess = null;
			objEmpInfoMerger = null;
			objEmpInfoMerger2 = null;
			objEmpInfoMerger3 = null;

			UserInfo = null;
			UserLoginInfo = null;
		}

	}

	/**
	 * @description : this method is used to perform authentication and find
	 *              process
	 */
	private void finderProcess() {
		ThreadGroup finderProcess = null;
		DisplayInfo objEmpInfoMerger = null;

		try {
			// finderProcess thread group
			finderProcess = new ThreadGroup("FINDER_PROCESS");
			// constructor authentication with finderProcess thread group
			objEmpInfoMerger = new DisplayInfo("", finderProcess, "find");
			// starting thread
			objEmpInfoMerger.start();
		} finally {
			finderProcess = null;
			objEmpInfoMerger = null;
		}

	}
}
