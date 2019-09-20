package common;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

/**
 * Represents the common utility functions like database, etc...
 */
public class CommonFunction {

	/**
	 * Establish the connection to the database server.
	 *
	 * @return Connection Connection to the MySQL database server
	 * @throws Exception
	 *             If any error occurs
	 */
	public Connection getConnection() throws Exception {
		String errorMessage = null;
		Connection dbConnection = null;
		try {
			/* Loading the MySQL database driver */
			Class.forName(Constants.DRIVER_CLASS);

			/*
			 * Creating the connection to the MySQL database server with
			 * credentials
			 */

			dbConnection = DriverManager.getConnection(Constants.DATABASE_URL, Constants.DATABASE_USERNAME,
					Constants.DATABASE_PASSWORD);

		} catch (SQLException sqlException) {
			errorMessage = sqlException.getMessage();
		} catch (ClassNotFoundException classNotFoundException) {
			errorMessage = Constants.MSG_CONN_ERROR;
		} catch (Exception exception) {
			errorMessage = exception.getMessage();
		}
		if (errorMessage != null) {
			throw new Exception(errorMessage);
		}
		return dbConnection;
	}

	/**
	 * Returns the UserBean containing the user details sent by the client as
	 * form data.
	 *
	 * @param req
	 *            HttpServletRequest
	 * @return UserBean The Bean containing User details
	 *
	 * @throws Exception
	 *             If any error occurs
	 */
	public UserBean getUserBean(HttpServletRequest req) throws Exception {

		UserBean userBean = null;
		try {
			/* Bean for UserDetails */
			userBean = new UserBean();

			/* Set the form data to the bean */
			userBean.setUserId(req.getParameter(Constants.USERID).trim());
			userBean.setPassword(req.getParameter(Constants.PASSWORD).trim());
			userBean.setSalutation(req.getParameter(Constants.SALUTATION).trim());
			userBean.setFirstName(req.getParameter(Constants.FIRSTNAME).trim());
			userBean.setMiddleInitial(req.getParameter(Constants.MIDDLE_INITIAL).trim());
			userBean.setLastName(req.getParameter(Constants.LASTNAME).trim());
			userBean.setSex(req.getParameter(Constants.SEX).trim());
			userBean.setEmailId(req.getParameter(Constants.EMAILID).trim());
			userBean.setBirthDay(req.getParameter(Constants.BIRTH_DAY).trim());
			userBean.setBirthMonth(req.getParameter(Constants.BIRTH_MONTH).trim());
			userBean.setBirthYear(req.getParameter(Constants.BIRTH_YEAR).trim());
			userBean.setAddress(req.getParameter(Constants.ADDRESS).trim());
			userBean.setAreaOfInterest(req.getParameterValues(Constants.INTEREST));
			userBean.setOtherInterests(req.getParameter(Constants.OTHER_INTEREST).trim());

			return userBean;
		} finally {
			userBean = null;
		}
	}

	/**
	 * Prints the User details on the console.
	 *
	 * @param userBean
	 *            The bean containing the user data
	 *
	 * @throws Exception
	 *             If any error occurs
	 */
	public void printOnConsole(UserBean userBean) throws Exception {

		String[] areaOfInterests = null;
		StringBuilder stringInterests = null;
		try {
			System.out.println(Constants.LABEL_HEADER);
			System.out.println(Constants.LABEL_USERID + Constants.STRING_COLON + userBean.getUserId());
			System.out.println(Constants.LABEL_PASSWORD + Constants.STRING_COLON + userBean.getPassword());
			System.out.println(Constants.LABEL_SALUTATION + Constants.STRING_COLON + userBean.getSalutation());
			System.out.println(Constants.LABEL_FIRSTNAME + Constants.STRING_COLON + userBean.getFirstName());
			System.out.println(Constants.LABEL_MIDDLE_INITIAL + Constants.STRING_COLON + userBean.getMiddleInitial());
			System.out.println(Constants.LABEL_LASTNAME + Constants.STRING_COLON + userBean.getLastName());
			System.out.println(Constants.LABEL_SEX + Constants.STRING_COLON + userBean.getSex());
			System.out.println(Constants.LABEL_EMAILID + Constants.STRING_COLON + userBean.getEmailId());
			System.out.println(Constants.LABEL_BIRTH_DATE + Constants.STRING_COLON + userBean.getBirthDate());
			System.out.println(Constants.LABEL_ADDRESS + Constants.STRING_COLON + userBean.getAddress());

			areaOfInterests = userBean.getAreaOfInterest();
			stringInterests = new StringBuilder();

			/* Is area of interest(s) selected ? */
			if (areaOfInterests != null && areaOfInterests.length > 0) {
				/* Loop through each area of interest(s) */
				for (String iInterest : areaOfInterests) {
					/*
					 * Storing each area of interests as comma separated value
					 */
					stringInterests.append(iInterest);
					stringInterests.append(Constants.STRING_COMMA);
				}

				/* Delete comma after last area of interest */
				stringInterests.delete(stringInterests.lastIndexOf(Constants.STRING_COMMA),
						stringInterests.length() - 1);
			}

			System.out.println(Constants.LABEL_INTEREST + Constants.STRING_COLON + stringInterests);
			System.out.println(Constants.LABEL_OTHER_INTEREST + Constants.STRING_COLON + userBean.getOtherInterests());
		} finally {
			areaOfInterests = null;
			stringInterests = null;
		}
	}

	/**
	 * Insert user record into the database
	 *
	 * @param dbConnection
	 *            The connection to the database server
	 * @param userBean
	 *            The bean containing user details
	 * @throws SQLException
	 *             If SQL process cause error
	 * @throws ParseException
	 *             If invalid date is selected
	 * @throws Exception
	 *             If any error occurs
	 */
	public void addRecordIntoDatabase(Connection dbConnection, UserBean userBean)
			throws SQLException, ParseException, Exception {

		PreparedStatement insertStatement = null;
		SimpleDateFormat dateFormat = null;
		String[] areaOfInterests = null;
		StringBuilder stringInterests = null;
		java.util.Date birthDate = null;

		try {
			/* Create insert statement on given connection */
			insertStatement = dbConnection.prepareStatement(Constants.QUERY_INSERT_RECORD);

			/* Insert user details for record */
			insertStatement.setString(1, userBean.getUserId());
			insertStatement.setString(2, userBean.getPassword());
			insertStatement.setString(3, userBean.getSalutation());
			insertStatement.setString(4, userBean.getFirstName());
			insertStatement.setString(5, userBean.getMiddleInitial());
			insertStatement.setString(6, userBean.getLastName());
			insertStatement.setString(7, userBean.getSex());
			insertStatement.setString(8, userBean.getEmailId());

			dateFormat = new SimpleDateFormat(Constants.DATE_FORMAT);
			birthDate = dateFormat.parse(userBean.getBirthDate());
			insertStatement.setDate(9, new Date(birthDate.getTime()));

			insertStatement.setString(10, userBean.getAddress());

			areaOfInterests = userBean.getAreaOfInterest();
			stringInterests = new StringBuilder();

			/* Is area of interest(s) selected ? */
			if (areaOfInterests != null && areaOfInterests.length > 0) {
				/* Loop through each area of interest(s) */
				for (String iInterest : areaOfInterests) {
					/*
					 * Storing each area of interests as comma separated value
					 */
					stringInterests.append(iInterest);
					stringInterests.append(Constants.STRING_COMMA);
				}

				/* Delete comma after last area of interest */
				stringInterests.delete(stringInterests.lastIndexOf(Constants.STRING_COMMA),
						stringInterests.length() - 1);
			}

			insertStatement.setString(11, stringInterests.toString());
			insertStatement.setString(12, userBean.getOtherInterests());

			/* Insert the record into database */
			insertStatement.execute();
		} finally {
			if (insertStatement != null) {
				insertStatement.close();
				insertStatement = null;
			}
			dateFormat = null;
			areaOfInterests = null;
			stringInterests = null;
			birthDate = null;
		}
	}

	/**
	 * Update the user record into the database
	 *
	 * @param dbConnection
	 *            The connection to the database server
	 * @param userBean
	 *            The bean containing user details
	 * @throws SQLException
	 *             If SQL process cause error
	 * @throws ParseException
	 *             If invalid date is selected
	 * @throws Exception
	 *             If any error occurs
	 */
	public void updateRecordIntoDatabase(Connection dbConnection, UserBean userBean)
			throws SQLException, ParseException, Exception {

		PreparedStatement updateStatement = null;
		SimpleDateFormat dateFormat = null;
		String[] areaOfInterests = null;
		StringBuilder stringInterests = null;
		java.util.Date birthDate = null;
		try {
			/* Create update statement on given connection */
			updateStatement = dbConnection.prepareStatement(Constants.QUERY_UPDATE_RECORD);

			/* Insert user details for record */
			updateStatement.setString(1, userBean.getPassword());
			updateStatement.setString(2, userBean.getSalutation());
			updateStatement.setString(3, userBean.getFirstName());
			updateStatement.setString(4, userBean.getMiddleInitial());
			updateStatement.setString(5, userBean.getLastName());
			updateStatement.setString(6, userBean.getSex());
			updateStatement.setString(7, userBean.getEmailId());

			dateFormat = new SimpleDateFormat(Constants.DATE_FORMAT);
			birthDate = dateFormat.parse(userBean.getBirthDate());
			updateStatement.setDate(8, new Date(birthDate.getTime()));

			updateStatement.setString(9, userBean.getAddress());

			areaOfInterests = userBean.getAreaOfInterest();
			stringInterests = new StringBuilder();

			/* Is area of interest(s) selected ? */
			if (areaOfInterests != null && areaOfInterests.length > 0) {
				/* Loop through each area of interest(s) */
				for (String iInterest : areaOfInterests) {
					/*
					 * Storing each area of interests as comma separated value
					 */
					stringInterests.append(iInterest);
					stringInterests.append(Constants.STRING_COMMA);
				}

				/* Delete comma after last area of interest */
				stringInterests.delete(stringInterests.lastIndexOf(Constants.STRING_COMMA),
						stringInterests.length() - 1);
			}

			updateStatement.setString(10, stringInterests.toString());
			updateStatement.setString(11, userBean.getOtherInterests());
			updateStatement.setString(12, userBean.getUserId());

			/* Insert the record into database */
			updateStatement.execute();
		} finally {
			if (updateStatement != null) {
				updateStatement.close();
				updateStatement = null;
			}
			dateFormat = null;
			areaOfInterests = null;
			stringInterests = null;
			birthDate = null;
		}
	}

	/**
	 * Searches the userId in the database and returns the bean containing user
	 * details otherwise null.
	 *
	 * @param dbConnection
	 *            The connection to the database server
	 * @param userId
	 *            Id of User
	 * @param password
	 *            Password of User
	 * @return UserBean UserBean containing user details if found, otherwise
	 *         null.
	 * @throws SQLException
	 *             If any SQL process cause the error
	 * @throws ParseException
	 *             Parsing of invalid date
	 * @throws Exception
	 *             If any error occurs
	 */
	public UserBean searchUser(Connection dbConnection, String userId, String password)
			throws SQLException, ParseException, Exception {

		PreparedStatement selectStatement = null;
		ResultSet selectResultSet = null;
		UserBean userBean = null;
		SimpleDateFormat dateFormat = null;
		Calendar calendar = null;
		try {
			/* Create insert statement on given connection */
			selectStatement = dbConnection.prepareStatement(Constants.QUERY_SEARCH_RECORD);

			selectStatement.setString(1, userId);
			selectStatement.setString(2, password);

			selectStatement.execute();

			selectResultSet = selectStatement.getResultSet();

			/* Is user found ? */
			if (selectResultSet.next()) {
				userBean = new UserBean();

				userBean.setUserId(selectResultSet.getString(1));
				userBean.setPassword(selectResultSet.getString(2));
				userBean.setSalutation(selectResultSet.getString(3));
				userBean.setFirstName(selectResultSet.getString(4));
				userBean.setMiddleInitial(selectResultSet.getString(5));
				userBean.setLastName(selectResultSet.getString(6));
				userBean.setSex(selectResultSet.getString(7));
				userBean.setEmailId(selectResultSet.getString(8));

				dateFormat = new SimpleDateFormat(Constants.DATE_FORMAT);
				calendar = Calendar.getInstance();
				calendar.setTime(selectResultSet.getDate(9));
				userBean.setBirthDay(String.valueOf(calendar.get(Calendar.DAY_OF_MONTH)));
				userBean.setBirthMonth(String.valueOf(calendar.get(Calendar.MONTH )));
				userBean.setBirthYear(String.valueOf(calendar.get(Calendar.YEAR)));
				userBean.setBirthDate(dateFormat.format(calendar.getTime()));

				userBean.setAddress(selectResultSet.getString(10));
				userBean.setAreaOfInterest(selectResultSet.getString(11).split(Constants.STRING_COMMA));
				userBean.setOtherInterests(selectResultSet.getString(12));

				return userBean;
			} else {
				/* No such user was found */
				return null;
			}
		} finally {
			if (selectStatement != null) {
				selectStatement.close();
				selectStatement = null;
			}
			if (selectResultSet != null) {
				selectResultSet.close();
				selectResultSet = null;
			}
			userBean = null;
			dateFormat = null;
			calendar = null;
		}
	}

	/**
	 * Returns list of all user's detail from the database.
	 *
	 * @param dbConnection
	 *            The connection to the databse server
	 * @return ArrayList<UserBean> List of all users
	 * @throws SQLException
	 *             If SQL process cause the exception
	 * @throws Exception
	 *             If any error occurs
	 */
	public ArrayList<UserBean> ListUsers(Connection dbConnection) throws SQLException, Exception {

		PreparedStatement selectStatement = null;
		ResultSet selectResultSet = null;
		UserBean userBean = null;
		ArrayList<UserBean> userList = null;
		SimpleDateFormat dateFormat = null;
		Calendar calendar = null;
		try {
			/* Create insert statement on given connection */
			selectStatement = dbConnection.prepareStatement(Constants.QUERY_LIST_ALL_USERS);

			selectStatement.execute();

			selectResultSet = selectStatement.getResultSet();

			userList = new ArrayList<UserBean>();

			while (selectResultSet.next()) {
				userBean = new UserBean();
				userBean.setUserId(selectResultSet.getString(1));
				userBean.setPassword(selectResultSet.getString(2));
				userBean.setSalutation(selectResultSet.getString(3));
				userBean.setFirstName(selectResultSet.getString(4));
				userBean.setMiddleInitial(selectResultSet.getString(5));
				userBean.setLastName(selectResultSet.getString(6));
				userBean.setEmailId(selectResultSet.getString(8));

				dateFormat = new SimpleDateFormat(Constants.DATE_FORMAT);
				calendar = Calendar.getInstance();
				calendar.setTime(selectResultSet.getDate(9));
				userBean.setBirthDay(String.valueOf(calendar.get(Calendar.DAY_OF_MONTH)));
				userBean.setBirthMonth(String.valueOf(calendar.get(Calendar.MONTH)));
				userBean.setBirthYear(String.valueOf(calendar.get(Calendar.YEAR)));
				userBean.setBirthDate(dateFormat.format(calendar.getTime()));

				userBean.setAddress(selectResultSet.getString(10));
				userBean.setAreaOfInterest(selectResultSet.getString(11).split(Constants.STRING_COMMA));
				userBean.setOtherInterests(selectResultSet.getString(12));

				userList.add(userBean);
			}

			return userList;
		} finally {
			if (selectStatement != null) {
				selectStatement.close();
				selectStatement = null;
			}
			if (selectResultSet != null) {
				selectResultSet.close();
				selectResultSet = null;
			}
			userBean = null;
			userList = null;
			dateFormat = null;
			calendar = null;
		}
	}

	/**
	 * Returns an HTML page containing a table of User details
	 *
	 * @param userBean
	 *            The bean containing User details
	 * @param contextPath
	 *            The path referring the project
	 * @return String An HTML page containing user details
	 * @throws Exception
	 *             If any error occurs
	 */
	public String getUserDetail(UserBean userBean, String contextPath) throws Exception {

		StringBuilder stringBuilder = null;
		String[] areaOfInterests = null;
		StringBuilder stringInterests = null;
		try {
			stringBuilder = new StringBuilder();

			stringBuilder.append(Constants.HTML_LINK_TO_CSS_START + contextPath + Constants.HTML_LINK_TO_CSS_END);

			stringBuilder.append(Constants.HTML_REG_SUCCESS_MESSAGE);
			stringBuilder.append(Constants.HTML_TABLE_START);
			stringBuilder.append(Constants.HTML_TABLE_HEADER);
			stringBuilder
					.append(Constants.HTML_TR_TD + Constants.LABEL_USERID + Constants.HTML_TD + userBean.getUserId());
			stringBuilder.append(
					Constants.HTML_TR_TD + Constants.LABEL_PASSWORD + Constants.HTML_TD + userBean.getPassword());
			stringBuilder.append(
					Constants.HTML_TR_TD + Constants.LABEL_SALUTATION + Constants.HTML_TD + userBean.getSalutation());
			stringBuilder.append(
					Constants.HTML_TR_TD + Constants.LABEL_FIRSTNAME + Constants.HTML_TD + userBean.getFirstName());
			stringBuilder.append(Constants.HTML_TR_TD + Constants.LABEL_MIDDLE_INITIAL + Constants.HTML_TD
					+ userBean.getMiddleInitial());
			stringBuilder.append(
					Constants.HTML_TR_TD + Constants.LABEL_LASTNAME + Constants.HTML_TD + userBean.getLastName());
			stringBuilder.append(Constants.HTML_TR_TD + Constants.LABEL_SEX + Constants.HTML_TD + userBean.getSex());
			stringBuilder
					.append(Constants.HTML_TR_TD + Constants.LABEL_EMAILID + Constants.HTML_TD + userBean.getEmailId());
			stringBuilder.append(
					Constants.HTML_TR_TD + Constants.LABEL_BIRTH_DATE + Constants.HTML_TD + userBean.getBirthDate());
			stringBuilder
					.append(Constants.HTML_TR_TD + Constants.LABEL_ADDRESS + Constants.HTML_TD + userBean.getAddress());

			areaOfInterests = userBean.getAreaOfInterest();
			stringInterests = new StringBuilder();

			/* Is area of interest(s) selected ? */
			if (areaOfInterests != null && areaOfInterests.length > 0) {
				/* Loop through each area of interest(s) */
				for (String iInterest : areaOfInterests) {
					/*
					 * Storing each area of interests as comma separated value
					 */
					stringInterests.append(iInterest);
					stringInterests.append(Constants.STRING_COMMA);
				}

				/* Delete comma after last area of interest */
				stringInterests.delete(stringInterests.lastIndexOf(Constants.STRING_COMMA),
						stringInterests.length() - 1);
			}

			stringBuilder.append(Constants.HTML_TR_TD + Constants.LABEL_INTEREST + Constants.HTML_TD + stringInterests);
			stringBuilder.append(Constants.HTML_TR_TD + Constants.LABEL_OTHER_INTEREST + Constants.HTML_TD
					+ userBean.getOtherInterests());
			stringBuilder.append(Constants.HTML_TABLE_END);

			return stringBuilder.toString();
		} finally {
			stringBuilder = null;
			areaOfInterests = null;
			stringInterests = null;
		}
	}

	/**
	 * Checks and returns true if the file sent from client is uploaded on the
	 * server successfully, otherwise false.
	 *
	 * @param req
	 *            HttpServletRequest
	 * @param servletContext
	 *            ServletRequest
	 * @return boolean True if file is uploaded on the server, otherwise false.
	 * @throws Exception
	 *             If any exception occurred during file upload process
	 */
	public boolean isFileUploaded(HttpServletRequest req, ServletContext servletContext) throws Exception {
		DiskFileItemFactory diskFileItemFactory = null;
		ServletFileUpload servletFileUpload = null;
		List<FileItem> items = null;
		File file = null;
		boolean isFileUploaded = true;

		try {
			/* Factory for disk based file item */
			diskFileItemFactory = new DiskFileItemFactory();

			/* File Upload handler */
			servletFileUpload = new ServletFileUpload(diskFileItemFactory);

			/* Process multi-part data */
			items = servletFileUpload.parseRequest(req);

			/* Process uploaded items */
			for (FileItem iItem : items) {
				/* Is file field (input type="file")? */
				if (!iItem.isFormField()) {
					/* Get name of uploaded file */
					String filename = FilenameUtils.getName(iItem.getName());

					/* Set maximum memory size, request size and file size */
					diskFileItemFactory.setSizeThreshold(Integer.MAX_VALUE);
					servletFileUpload.setSizeMax(Long.MAX_VALUE);
					servletFileUpload.setFileSizeMax(Long.MAX_VALUE);

					/* Locate to the upload directory */
					file = new File(servletContext.getRealPath(Constants.UPLOAD_DIR_PATH));

					/* Does Files directory exists on root? */
					if (file.exists()) {
						/* Set upload file path */
						file = new File(servletContext.getRealPath(Constants.UPLOAD_DIR_PATH + filename));
					} else {
						/* Is Files directory created on root? */
						if (!file.mkdir()) {
							/* Set upload file path (root) */
							file = new File(servletContext.getRealPath(filename));
						} else {
							/* Set upload file path */
							file = new File(servletContext.getRealPath(Constants.UPLOAD_DIR_PATH + filename));
						}
					}

					/* Does the file already exists ? */
					if (file.exists()) {
						/* Delete old file */
						file.delete();
					}

					/* can't create file ? */
					if (!file.createNewFile()) {
						isFileUploaded = false;
					} else {
						iItem.write(file);
					}
				}
			}
			return isFileUploaded;
		} catch (Exception exception) {
			/* Does the file already exists ? */
			if (file.exists()) {
				/*
				 * Delete file(usually corrupted,...) in case of any error
				 * occurred while uploading
				 */
				file.delete();
			}
			throw new Exception(exception.getMessage());

		} finally {
			diskFileItemFactory = null;
			servletFileUpload = null;
			items = null;
			file = null;
		}
	}

	/**
	 * Returns names of all uploaded files on the server.
	 *
	 * @param directory
	 *            The path to the upload directory on the server
	 * @return ArrayList<String> List of names of all uploaded files on the
	 *         server
	 * @throws Exception
	 *             If any error occurs
	 */
	public ArrayList<String> listUploadFiles(String directory) throws Exception {

		ArrayList<String> fileList = null;
		File uploadDirectory = null;
		File[] uploadedFiles = null;
		try {
			fileList = new ArrayList<String>();

			/* Locate to the upload directory on the server */
			uploadDirectory = new File(directory);

			/* Get list of all uploaded files */
			uploadedFiles = uploadDirectory.listFiles();

			/* Is no files uploaded? */
			if (uploadedFiles == null || uploadedFiles.length == 0) {
				return null;
			}

			for (File iFile : uploadedFiles) {
				/* Add name of each file to the list */
				fileList.add(iFile.getName());
			}

			return fileList;
		} finally {
			fileList = null;
			uploadDirectory = null;
			uploadedFiles = null;
		}
	}

	/**
	 * Downloads the file requested from client
	 *
	 * @param req
	 *            HttpServletRequest
	 * @param resp
	 *            HttpServletResponse
	 * @param servletContext
	 *            ServletContext
	 * @throws Exception
	 *             If any error occurred during file downloading process
	 */
	public void downloadFile(HttpServletRequest req, HttpServletResponse resp, ServletContext servletContext)
			throws Exception {
		ServletOutputStream servletOutputStream = null;
		DataInputStream dataInputStream = null;
		File file = null;

		try {
			/* Get path of Upload directory on the server */
			String directoryPath = servletContext.getRealPath(Constants.UPLOAD_DIR_PATH);

			/* Get the name of file */
			String fileName = req.getParameter(Constants.STRING_FILELIST);

			/* Locate to the file on the server directory */
			file = new File(directoryPath, fileName);

			int segmentLength = 0;

			/* Stream to download CSV file */
			servletOutputStream = resp.getOutputStream();

			// servletContext = getServletConfig().getServletContext();

			/* Get MIME type of the file */
			String mimeType = servletContext.getMimeType(file.getAbsolutePath());

			if (mimeType == null) {
				mimeType = Constants.MIMETYPE_APPLICATION;
			}

			/* Set content type and content length to MIME */
			resp.setContentType(mimeType);
			resp.setContentLength((int) file.length());

			/* Set HTTP header */
			resp.setHeader(Constants.HEADER_CONTENT_DISPOSITION,
					Constants.ATTACHMENT_FILE + fileName + Constants.STRING_DOUBLE_QUOTE);

			/* Segment of 4K */
			byte[] byteBuffer = new byte[4096];

			/* To read from file */
			dataInputStream = new DataInputStream(new FileInputStream(file));

			/* Is file found and not empty? */
			boolean isFileContent = (dataInputStream != null)
					&& ((segmentLength = dataInputStream.read(byteBuffer)) != -1);

			if (isFileContent) {
				do {
					/*
					 * Reads the file's bytes and writes them to the response
					 * stream
					 */
					servletOutputStream.write(byteBuffer, 0, segmentLength);

					/* Is not EOF ? */
					isFileContent = (dataInputStream != null)
							&& ((segmentLength = dataInputStream.read(byteBuffer)) != -1);

				} while (isFileContent);
			}
		} catch (Exception exception) {
			/* Is file exists ? */
			if (file.exists()) {
				/*
				 * Delete the file in case of file is corrupt during downloading
				 */
				file.delete();
			}
			throw new Exception(exception.getMessage());
		} finally {
			/* Close and clear resources when not needed. */
			if (dataInputStream != null) {
				dataInputStream.close();
				dataInputStream = null;
			}

			if (servletOutputStream != null) {
				servletOutputStream.close();
				servletOutputStream = null;
			}

			file = null;
		}
	}

	/**
	 * Checks whether the CSV file would be deleted or not.
	 *
	 * @param directoryPath
	 *            The path of directory on the server
	 * @return boolean True if CSV file would deleted, otherwise false.
	 * @throws Exception
	 *             If any error occurs
	 */
	public boolean deleteCSVFile(String directoryPath) throws Exception {

		File csvFile = null;
		try {
			/* Locate to the CSV file on directory on server */
			csvFile = new File(directoryPath, Constants.CSV_FILE_NAME);

			/* Is file exists ? */
			if (csvFile.exists()) {
				/* Can't delete file ? */
				if (!csvFile.delete()) {
					return false;
				}
			}

			return true;
		} finally {
			csvFile = null;
		}
	}

	/**
	 * Returns the name of each column of UserDetails as comma separated value
	 * (CSV).
	 *
	 * @return String Column names as CSV.
	 * @throws Exception
	 *             If any error occurred.
	 */
	public String getColumnNames() throws Exception {
		StringBuilder stringBuilder = null;

		try {
			stringBuilder = new StringBuilder();

			stringBuilder.append(Constants.STRING_DOUBLE_QUOTE + Constants.LABEL_USERID + Constants.STRING_DOUBLE_QUOTE
					+ Constants.STR_COMMA);
			stringBuilder.append(Constants.STRING_DOUBLE_QUOTE + Constants.LABEL_PASSWORD
					+ Constants.STRING_DOUBLE_QUOTE + Constants.STR_COMMA);
			stringBuilder.append(Constants.STRING_DOUBLE_QUOTE + Constants.LABEL_SALUTATION
					+ Constants.STRING_DOUBLE_QUOTE + Constants.STR_COMMA);
			stringBuilder.append(Constants.STRING_DOUBLE_QUOTE + Constants.LABEL_FIRSTNAME
					+ Constants.STRING_DOUBLE_QUOTE + Constants.STR_COMMA);
			stringBuilder.append(Constants.STRING_DOUBLE_QUOTE + Constants.LABEL_MIDDLE_INITIAL
					+ Constants.STRING_DOUBLE_QUOTE + Constants.STR_COMMA);
			stringBuilder.append(Constants.STRING_DOUBLE_QUOTE + Constants.LABEL_LASTNAME
					+ Constants.STRING_DOUBLE_QUOTE + Constants.STR_COMMA);
			stringBuilder.append(Constants.STRING_DOUBLE_QUOTE + Constants.LABEL_SEX + Constants.STRING_DOUBLE_QUOTE
					+ Constants.STR_COMMA);
			stringBuilder.append(Constants.STRING_DOUBLE_QUOTE + Constants.LABEL_EMAILID + Constants.STRING_DOUBLE_QUOTE
					+ Constants.STR_COMMA);
			stringBuilder.append(Constants.STRING_DOUBLE_QUOTE + Constants.LABEL_BIRTH_DATE
					+ Constants.STRING_DOUBLE_QUOTE + Constants.STR_COMMA);
			stringBuilder.append(Constants.STRING_DOUBLE_QUOTE + Constants.LABEL_ADDRESS + Constants.STRING_DOUBLE_QUOTE
					+ Constants.STR_COMMA);
			stringBuilder.append(Constants.STRING_DOUBLE_QUOTE + Constants.LABEL_INTEREST
					+ Constants.STRING_DOUBLE_QUOTE + Constants.STR_COMMA);
			stringBuilder.append(Constants.STRING_DOUBLE_QUOTE + Constants.LABEL_OTHER_INTEREST
					+ Constants.STRING_DOUBLE_QUOTE + System.getProperty(Constants.LINE_SEPARATOR));

			return stringBuilder.toString();
		} finally {
			stringBuilder = null;
		}
	}

	/**
	 * Returns the String comma separated values (CSV) from the passed userBean.
	 *
	 * @param userBean
	 *            userBean containing the UserDetails
	 * @return String CSV of UserDetails
	 */
	public String getUserBeanAsString(UserBean userBean) {
		StringBuilder stringBuilder = null;

		try {
			stringBuilder = new StringBuilder();

			stringBuilder.append(Constants.STRING_DOUBLE_QUOTE + userBean.getUserId() + Constants.STRING_DOUBLE_QUOTE
					+ Constants.STR_COMMA);
			stringBuilder.append(Constants.STRING_DOUBLE_QUOTE + userBean.getPassword() + Constants.STRING_DOUBLE_QUOTE
					+ Constants.STR_COMMA);
			stringBuilder.append(Constants.STRING_DOUBLE_QUOTE + userBean.getSalutation()
					+ Constants.STRING_DOUBLE_QUOTE + Constants.STR_COMMA);
			stringBuilder.append(Constants.STRING_DOUBLE_QUOTE + userBean.getFirstName() + Constants.STRING_DOUBLE_QUOTE
					+ Constants.STR_COMMA);
			stringBuilder.append(Constants.STRING_DOUBLE_QUOTE + userBean.getMiddleInitial()
					+ Constants.STRING_DOUBLE_QUOTE + Constants.STR_COMMA);
			stringBuilder.append(Constants.STRING_DOUBLE_QUOTE + userBean.getLastName() + Constants.STRING_DOUBLE_QUOTE
					+ Constants.STR_COMMA);
			stringBuilder.append(Constants.STRING_DOUBLE_QUOTE + userBean.getSex() + Constants.STRING_DOUBLE_QUOTE
					+ Constants.STR_COMMA);
			stringBuilder.append(Constants.STRING_DOUBLE_QUOTE + userBean.getEmailId() + Constants.STRING_DOUBLE_QUOTE
					+ Constants.STR_COMMA);
			stringBuilder.append(Constants.STRING_DOUBLE_QUOTE + userBean.getBirthDate() + Constants.STRING_DOUBLE_QUOTE
					+ Constants.STR_COMMA);
			stringBuilder.append(Constants.STRING_DOUBLE_QUOTE + userBean.getAddress() + Constants.STRING_DOUBLE_QUOTE
					+ Constants.STR_COMMA);
			stringBuilder.append(Constants.STRING_DOUBLE_QUOTE);

			for (String iInterest : userBean.getAreaOfInterest()) {
				stringBuilder.append(iInterest + Constants.STR_COMMA);
			}
			stringBuilder.deleteCharAt(stringBuilder.lastIndexOf(Constants.STR_COMMA));

			stringBuilder.append(Constants.STRING_DOUBLE_QUOTE + Constants.STR_COMMA);
			stringBuilder.append(Constants.STRING_DOUBLE_QUOTE + userBean.getOtherInterests()
					+ Constants.STRING_DOUBLE_QUOTE + System.getProperty(Constants.LINE_SEPARATOR));

			return stringBuilder.toString();
		} finally {
			stringBuilder = null;
		}
	}

	/**
	 * Returns the path of CSV file of user details if there user(s) were found
	 * in the database, otherwise null for no user found in the database.
	 *
	 * @param dbConnection
	 *            The connection to the database server
	 * @param directoryPath
	 *            The path of directory for CSV file
	 * @return String The link of generated CSV file
	 * @throws IOException
	 *             If I/O process cause the exception
	 * @throws SQLException
	 *             If SQL process cause the exception
	 * @throws Exception
	 *             If any error occurs
	 */
	public String getCSVFileLink(Connection dbConnection, String directoryPath)
			throws IOException, SQLException, Exception {

		String csvFileLink = null;
		File csvFile = null;
		FileWriter fileWriter = null;

		ArrayList<UserBean> userList = null;
		try {

			userList = ListUsers(dbConnection);

			if (userList != null && userList.size() > 0) {
				/* Is old CSV file deleted, if exists ? */
				boolean isDeleted = deleteCSVFile(directoryPath);

				/* Locate to the CSV file */
				csvFile = new File(directoryPath, Constants.CSV_FILE_NAME);

				/* Is old file deleted, if exists ? */
				if (isDeleted) {
					/* Create new CSV file */
					csvFile.createNewFile();
					fileWriter = new FileWriter(csvFile);
				} else {
					/* Overwrite the old file */
					fileWriter = new FileWriter(csvFile, false);
				}

				fileWriter.write(getColumnNames());

				for (UserBean iUserBean : userList) {

					fileWriter.write(getUserBeanAsString(iUserBean));
				}

				csvFileLink = csvFile.getAbsolutePath();
			}

			return csvFileLink;

		} catch (Exception exception) {
			deleteCSVFile(directoryPath);
			throw new Exception(exception.getMessage());
		} finally {
			if (fileWriter != null) {
				fileWriter.close();
				fileWriter = null;
			}
			csvFileLink = null;
			csvFile = null;
		}
	}

	/**
	 * Downloads the CSV file containing details of all users at the client.
	 *
	 * @param resp
	 *            HttpServletResponse
	 * @param servletContext
	 *            ServletContext
	 * @param directoryPath
	 *            The path of directory, which contains the CSV file
	 * @throws Exception
	 *             If any error occurred during the CSV file download process.
	 */
	public void downloadCSVFile(HttpServletResponse resp, ServletContext servletContext, String directoryPath)
			throws Exception {
		File csvFile = null;
		ServletOutputStream servletOutputStream = null;
		DataInputStream dataInputStream = null;
		try {
			/* Locate to the generated CSV file */
			csvFile = new File(directoryPath, Constants.CSV_FILE_NAME);

			int segmentLength = 0;

			/* Stream to download CSV file */
			servletOutputStream = resp.getOutputStream();

			/* Get MIME type of the file */
			String mimeType = servletContext.getMimeType(csvFile.getAbsolutePath());

			if (mimeType == null) {
				mimeType = Constants.MIMETYPE_APPLICATION;
			}

			/* Set content type and content length to MIME */
			resp.setContentType(mimeType);
			resp.setContentLength((int) csvFile.length());

			/* Set HTTP header */
			resp.setHeader(Constants.HEADER_CONTENT_DISPOSITION,
					Constants.ATTACHMENT_FILE + Constants.CSV_FILE_NAME + Constants.STRING_DOUBLE_QUOTE);

			/* Segment of 4K */
			byte[] byteBuffer = new byte[4096];

			/* To read from CSV file */
			dataInputStream = new DataInputStream(new FileInputStream(csvFile));

			/* Is file found and not empty? */
			boolean isFileContent = (dataInputStream != null)
					&& ((segmentLength = dataInputStream.read(byteBuffer)) != -1);

			if (isFileContent) {
				do {
					/*
					 * Reads the file's bytes and writes them to the response
					 * stream
					 */
					servletOutputStream.write(byteBuffer, 0, segmentLength);

					/* Is not EOF ? */
					isFileContent = (dataInputStream != null)
							&& ((segmentLength = dataInputStream.read(byteBuffer)) != -1);

				} while (isFileContent);
			}
		} finally {
			deleteCSVFile(directoryPath);

			if (dataInputStream != null) {
				dataInputStream.close();
				dataInputStream = null;
			}
			if (servletOutputStream != null) {
				servletOutputStream.close();
				servletOutputStream = null;
			}
			csvFile = null;
		}
	}
}