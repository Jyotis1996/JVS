package com.uks.jvs.jyoti.day2.assignment5;

import java.util.Map;
import java.util.Set;

/**
 * Class Name:RuntimeTest
 * Description:Open NotePad and Print Environment variable
 * @author Jyoti
 * @Created date [20-06-2019]
 */

public class RuntimeTest {

	/**
	 * Method Name:doRuntime Description:Open NotePad using Runtime Class
	 */

	public void doruntime() {
		try {
			Runtime.getRuntime().exec("notepad.exe");
		} catch (Exception obj) {
			obj.printStackTrace();
		}
	}

	/**
	 * Method Name:doProcessBuilder Description:Open NotePad using
	 * ProcessBuilder
	 */

	public void doProcessBuilder() {
		ProcessBuilder objProcessBuilder = null;
		try {
			objProcessBuilder = new ProcessBuilder("notepad.exe");
			objProcessBuilder.start();

		} catch (Exception obj) {
			obj.printStackTrace();
		} finally {
			objProcessBuilder = null;
		}
	}

	/**
	 * Method Name:printVariable Description:Print Environment Variables
	 */
	public void printVariable() {
		ProcessBuilder objProcessBuilder = null;
		try {
			objProcessBuilder = new ProcessBuilder();
			Map<String, String> objMap = objProcessBuilder.environment();
			Set<String> keys = objMap.keySet();
			for (String objkey : keys) {
				System.out.println(objkey + "==>" + objMap.get(objkey));
			}
		} catch (Exception obj) {
			obj.printStackTrace();
		} finally {
			objProcessBuilder = null;

		}
	}

	public static void main(String[] args) {
		RuntimeTest objRuntimeTest = null;
		try {
			objRuntimeTest = new RuntimeTest();
			objRuntimeTest.doProcessBuilder();
			objRuntimeTest.doruntime();
			objRuntimeTest.printVariable();
		} catch (Exception obj) {
			obj.printStackTrace();
		} finally {
			objRuntimeTest = null;

		}
	}
}
