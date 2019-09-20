package day4.assignment1.logic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import org.apache.commons.io.FileUtils;

import common.db_logic.DbLogic;
import common.util.Constants;

/**
 * Upload logic classto upload file to database
 *
 * @author Jyoti
 *
 */
public class UploadLogic {

	Connection con = null;
	DbLogic objDbLogic = new DbLogic();

	public void uploadFile(File fileUpload, File saveFilePath) throws IOException {

		FileUtils.copyFile(fileUpload, saveFilePath);
	}

	public void insertToDB(String fileUploadFileName, File saveFilePath) {
		try {
			con = objDbLogic.connect();
			PreparedStatement preparedStatement = con.prepareStatement(Constants.QUERY);
			preparedStatement.setString(1, fileUploadFileName);
			// for inserting image in database
			FileInputStream inputStream = new FileInputStream(saveFilePath);
			preparedStatement.setBinaryStream(2, inputStream);
			int i = preparedStatement.executeUpdate();
			if (i > 0) {
				objDbLogic.disconnect();
			} else {
				objDbLogic.disconnect();
			}
		} catch (Exception e) {
			System.out.print(e);
		}

	}
}
