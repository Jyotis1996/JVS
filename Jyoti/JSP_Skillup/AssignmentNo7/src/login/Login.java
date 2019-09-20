package login;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.CommonFunction;
import common.Constants;
import common.UserBean;
import common.Validation;

/**
 * Represents the bean for user details from login information.
 *
 */
public class Login extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	/**
	 * Process and validates the form data sent by client and sends the bean
	 * containing specific user details to the client.
	 *
	 * @param req
	 *            HttpServletRequest
	 * @param resp
	 *            HttpServletResponse
	 * @throws ServletException
	 *             if the request for the POST could not be handled
	 * @throws IOException
	 *             if I/O process cause the error
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserBean userBean = null;
		Validation validation = null;
		CommonFunction commonFunction = null;
		ArrayList<UserBean> userList = null;
		Connection dbConnection = null;
		String stringPath = null;
		String buttonEditUpdate = null;

		try {
			/*
			 * Set Character encoding UTF-8 to support Japanese characters as
			 * well
			 */
			req.setCharacterEncoding(Constants.CHAR_ENCODING_UTF8);
			resp.setCharacterEncoding(Constants.CHAR_ENCODING_UTF8);

			/* Bean for UserDetails */
			userBean = new UserBean();
			validation = new Validation();
			commonFunction = new CommonFunction();

			/* Retrieve Login information */
			String userId = req.getParameter(Constants.USERID).trim();
			String password = req.getParameter(Constants.PASSWORD).trim();

			userBean.setUserId(userId);
			userBean.setPassword(password);

			/* Set path of user login page */
			stringPath = Constants.PATH_LOGIN_ASSIGNMENT5;

			if (validation.isEmptyInput(userId)) {
				req.setAttribute(Constants.MESSAGE, Constants.NO_USERID);
			} else if (validation.isEmptyInput(password)) {
				req.setAttribute(Constants.MESSAGE, Constants.NO_PASSWORD);
			} else {
				/* Is Admin login ? */
				boolean isAdmin = userId.equals(Constants.ADMIN) && password.equals(Constants.ADMIN);

				/* Get the connection to the database server */
				dbConnection = commonFunction.getConnection();

				if (isAdmin) {
					/* Get list of all users from the database */
					userList = commonFunction.ListUsers(dbConnection);

					/* Is no user was found ? */
					if (userList.size() == 0) {
						req.setAttribute(Constants.MESSAGE, Constants.MSG_NO_USER);
					} else {
						req.setAttribute(Constants.USERLIST, userList);
					}

					stringPath = Constants.PATH_LIST_USERS_ASSIGNMENT7;
				} else {
					/* Get User details into bean */
					userBean = commonFunction.searchUser(dbConnection, userId, password);

					if (userBean == null) {
						/* Initialize to old value if no such user was found */
						req.setAttribute(Constants.MESSAGE, Constants.MSG_INVALID_LOGIN);
						req.getRequestDispatcher(Constants.PATH_LOGIN_ASSIGNMENT5).forward(req, resp);
					} else {

						buttonEditUpdate = req.getParameter(Constants.EDIT_UPDATE);

						if (buttonEditUpdate != null && buttonEditUpdate.equalsIgnoreCase(Constants.EDIT)) {
							/* Set Edit Button */
							req.setAttribute(Constants.EDIT_UPDATE, Constants.UPDATE);
							/* Set Logout Button */
							req.setAttribute(Constants.LOGOUT_CANCEL, Constants.CANCEL);
						} else {
							/* Set Read only fields */
							req.setAttribute(Constants.READONLY, Constants.READONLY);
							/* Set Disable fields */
							req.setAttribute(Constants.DISABLED, Constants.DISABLED);
							/* Set Edit Button */
							req.setAttribute(Constants.EDIT_UPDATE, Constants.EDIT);
							/* Set Logout Button */
							req.setAttribute(Constants.LOGOUT_CANCEL, Constants.LOGOUT);
						}

						stringPath = Constants.PATH_EDIT_USER_DETAILS_ASSIGNMENT6;
					}
				}
			}

			/* To display old value to registration form */
			req.setAttribute(Constants.USERBEAN_BEAN_NAME, userBean);

			req.getRequestDispatcher(stringPath).forward(req, resp);

		} catch (Exception exception) {
			req.setAttribute(Constants.ERROR, exception.getMessage());
			req.getRequestDispatcher(Constants.PATH_ERROR_PAGE).forward(req, resp);
		} finally {
			if (dbConnection != null) {
				try {
					if (!dbConnection.isClosed()) {
						dbConnection.close();
					}
				} catch (SQLException sqlException) {

				} finally {
					dbConnection = null;
				}
			}
			buttonEditUpdate = null;
			stringPath = null;
			userBean = null;
			validation = null;
			commonFunction = null;
			userList = null;
		}
	}

	@Override
	/**
	 * Redirects control to doPost()
	 *
	 * @param req
	 *            HttpServletRequest
	 * @param resp
	 *            HttpServletResponse
	 * @throws ServletException
	 *             if the request for the POST could not be handled
	 * @throws IOException
	 *             if I/O process cause the error
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
}