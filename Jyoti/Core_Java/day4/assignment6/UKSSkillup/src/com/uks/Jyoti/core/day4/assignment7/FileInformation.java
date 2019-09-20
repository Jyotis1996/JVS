package com.uks.Jyoti.core.day4.assignment7;

import java.io.File;

/**
 * Class Name : FileInformation Description : Get information about file or
 * directory
 *
 * @author Jyoti [25-06-2019]
 *
 */
public class FileInformation {

	/**
	 * Method Name : getFileInfo() Description : to check from path whether file
	 * or directory and display information
	 *
	 * @param argument
	 */
	public void getFileInfo(String[] argument) {
		File objFile;
		try {
			if (argument.length != 0 && argument.length == 1) {
				objFile = new File(argument[0]);
				if (objFile.exists()) {
					// if statement to check wether entered path exist or not
					System.out.println("Path : " + objFile.getAbsolutePath());
					if (objFile.isFile()) {
						System.out.println(objFile.getPath() + " is File");
						System.out.println("File Size : " + this.getSize(objFile));
					}

					if (objFile.isDirectory()) {
						System.out.println(objFile.getPath() + "is Directory");
						System.out.println("Directory Size : " + this.getSize(objFile));
					}
				} else {
					System.out.println("Entered path does not exist");
				}
			} else {
				System.out.println("Please enter path as argument");
			}
		} finally {
			objFile = null;
		}
	}

	/**
	 * Method Name : getSize() Description : Calculate the size of file or
	 * directory and return size to getFileInfo() method
	 *
	 * @param objFileParameter
	 * @return size
	 */
	public long getSize(File objFileParameter) {
		try {
			long size;
			if (objFileParameter.isDirectory()) {
				size = 0;
				for (File objFile : objFileParameter.listFiles()) {
					size += getSize(objFile);
				}

			} else {
				size = objFileParameter.length();
			}

			return size;
		} finally {
			objFileParameter = null;
		}
	}

	public static void main(String[] args) {

		FileInformation objFileInfo = null;
		try {
			objFileInfo = new FileInformation();
			objFileInfo.getFileInfo(args);

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			objFileInfo = null;
		}
	}

}
