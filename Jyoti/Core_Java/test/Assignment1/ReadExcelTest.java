package com.uks.jvs.jyoti.test.Assignment1;

/**
 * Class Name : ReadExcelTest Description : Main class to read contents of excel
 * file and print on terminal
 *
 * @author Jyoti [04-07-2019]
 *
 */
public class ReadExcelTest {

	public static void main(String[] args) {
		ReadExcelDemo objReadExcel = null;
		try {
			objReadExcel = new ReadExcelDemo();
			objReadExcel.readExcel();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			objReadExcel = null;
		}
	}

}
