package com.uks.jvs.jyoti.day5.assignment5;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

/**
 * Class Name:DirectoryListing Description:File Filters & Listing Directories
 *
 * @author Jyoti [26-06-2019]
 */
public class DirectoryListing {
	/**
	 * Method Name:getFilePath Description:File Searching with Specific
	 *
	 * @author Jyoti
	 */
	public void getFilePath(final String strFilePath, final String fileExtension, int recursion)
			throws IOException, NullPointerException {
		File objFile;
		FilenameFilter objFilter;
		File[] objALLFiles;
		File[] objFilesList;
		final String[] extensionList;
		try {
			objFile = new File(strFilePath);

			// Exist Or Not?
			if (objFile.exists()) {
				if (objFile.isDirectory()) {
					// Directory Or Not?
					System.out.println(objFile.getPath() + " is Directory");
					// Searching for * or specific Extension
					extensionList = fileExtension.split(",");
					if ("*".equals(fileExtension)) {
						objALLFiles = objFile.listFiles();
						if (objALLFiles.length != 0 && objALLFiles != null) {
							for (File file : objALLFiles) {
								if (file.isFile()) {
									System.out.println(file.getCanonicalPath());
								}
							}
						}
					} else {
						/*
						 * FileNameFilter with accept Method for Filtering Files
						 */
						objFilter = new FilenameFilter() {
							@Override
							public boolean accept(File directory, String extension) {
								for (String ext : extensionList) {
									if (extension.endsWith(ext)) {
										return true;
									}
								}
								return false;
							}
						};
						objFilesList = objFile.listFiles(objFilter);
						if (objFilesList.length != 0 && objFilesList != null) {
							for (File file : objFilesList) {
								System.out.println(file.getCanonicalPath());// Filter
																			// Result
							}
						} else {
							System.out.println("File not exist with this extension");
						}
					}
				} else {
					System.out.println(objFile.getPath() + " is Not Directory");
				}
			} else {
				System.out.println("Entered path does not exist");
			}
		} finally {
			objALLFiles = null;
			objFile = null;
			objFilesList = null;
			objFilter = null;
		}
	}

	/**
	 * Method Name:recursiveMethod Description:Filter Operation for SubDirectory
	 *
	 * @author Jyoti
	 */
	public void recursiveMethod(String path, String extension, int recursion) throws IOException, NullPointerException {
		File objFile;
		File[] strAllFiles;
		try {
			objFile = new File(path);
			if (objFile.exists()) {
				strAllFiles = objFile.listFiles();
				if (strAllFiles.length != 0) {
					for (File filename : strAllFiles) {
						if (filename.isDirectory()) {
							this.getFilePath(filename.getCanonicalPath(), extension, recursion);
						}
					}
				}
			}
		} finally {
			objFile = null;
		}
	}
}
