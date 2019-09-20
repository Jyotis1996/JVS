package common;

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
import javax.servlet.http.HttpServletRequest;

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
				userBean.setBirthMonth(String.valueOf(calendar.get(Calendar.MONTH)));
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
}