package com.uks.jvs.jyoti.day9.assignment1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * Class Name :ReadConfiguration Description : read configuration properties
 *
 * @author Jyoti [03-07-2019]
 *
 */

public class ReadConfiguration {

	/**
	 * @description : this method returns userInfo file path
	 * @return userInfo file path
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static String readNameFile() throws FileNotFoundException, IOException {
		String path = null;
		String key = null;
		Properties objProperties = null;
		try {
			key = "UserInfo";
			objProperties = new Properties();
			// reading file path of userinfo into properties
			objProperties.load(new FileReader(new File(
					"D:\\JVS_WS\\coreJava\\src\\com\\uks\\jvs\\jyoti\\day9\\assignment1\\readConfiguration.properties")));

			// converting into string
			path = (String) objProperties.get(key);

			path = new File(path).getAbsolutePath();

		} finally {
			key = null;
			objProperties = null;
		}
		// returning path
		return path;
	}

	/**
	 * @description : this method returns userLoginInfo file path
	 * @return UserLoginInfo path
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static String readAddressFile() throws FileNotFoundException, IOException {
		String path = null;
		String key = null;
		Properties objProperties = null;

		try {
			key = "UserLoginInfo";
			objProperties = new Properties();
			// reading file path of userLoginInfo into properites
			objProperties.load(new FileReader(new File(
					"D:\\JVS_WS\\coreJava\\src\\com\\uks\\jvs\\jyoti\\day9\\assignment1\\readConfiguration.properties")));

			// converting into string path
			path = (String) objProperties.get(key);
			path = new File(path).getAbsolutePath();
		} finally {
			objProperties = null;
			key = null;
		}
		// returning file path
		return path;
	}
}
