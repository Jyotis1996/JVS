package com.uks.jvs.jyoti.day7.assignment1;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.LineNumberReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class Name:FindInFiles Description:Find the String from File or Directory
 *
 * @author Jyoti [01-07-2019]
 */
public class FindInFiles {
	/**
	 * Method Name:getInputs Description:get the input from User
	 */

	final static Charset ENCODING = StandardCharsets.ISO_8859_1;
	String searchFileString = null;
	String Filepath = null;
	int Count = 0;

	public void getInputs(String SearchString, String pathFile) throws IOException {
		File objFiles;
		File[] objFilesList;

		try {
			searchFileString = SearchString;
			Filepath = pathFile;
			objFiles = new File(pathFile);
			if (objFiles.exists()) {
				if (objFiles.isDirectory()) {
					objFilesList = objFiles.listFiles();
					if (objFilesList.length != 0) {
						for (File file : objFilesList) {
							if (file.isFile()) {
								this.getInputs(searchFileString, file.getCanonicalPath());
							}
						}
					} else {
						System.out.println("No record found ");
					}
				}
				if (objFiles.isFile()) {
					this.readFile(objFiles.getCanonicalPath());
				}
				if (Count == 0) {
					System.out.println("No record found for " + objFiles.getCanonicalPath());
				}
			} else {
				System.out.println("Entered path does not exist");
			}

		} finally {
			objFiles = null;
			objFilesList = null;
		}
	}

	/**
	 * Method Name:readFile Description:Read the file
	 *
	 * @param filepath
	 * @throws IOException
	 */

	public void readFile(String filepath) throws IOException {
		Path objPath;
		BufferedReader objReader;
		LineNumberReader objLineNumberReader;
		String line = null;
		try {
			objPath = Paths.get(filepath);
			objReader = Files.newBufferedReader(objPath, ENCODING);
			objLineNumberReader = new LineNumberReader(objReader);
			while ((line = objLineNumberReader.readLine()) != null) {
				if ((this.searchString(line)) == 1) {// find string
					String msg = "Line " + objLineNumberReader.getLineNumber() + " : " + line;
					System.out.println(objPath + " " + msg);
					Count++;
				}
			}
		} finally {
			objLineNumberReader = null;
			objPath = null;
			objReader = null;
		}
	}

	/**
	 * Method Name:serchString Description:Search the String from File
	 *
	 * @param line
	 * @return
	 */

	public int searchString(String line) {
		Pattern objPattern;
		Matcher objMatcher;
		try {
			objPattern = Pattern.compile(searchFileString);
			objMatcher = objPattern.matcher("");
			objMatcher.reset(line);
			if (objMatcher.find()) {
				return 1;
			}
		} finally {
			objMatcher = null;
			objPattern = null;
		}
		return 0;
	}
}
