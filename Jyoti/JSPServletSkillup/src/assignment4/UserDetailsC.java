package assignment4;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.CommonFunction;
import common.Constants;
import common.UserBean;
import common.Validation;

/**
 * Represents the bean for form data sent from Registration page.
 *
 */
public class UserDetailsC extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	/**
	 * Process and validates the form data sent by client and sends the bean to
	 * the client.
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
		Connection dbConnection = null;

		try {
			/*
			 * Set Character encoding UTF-8 to support Japanese characters as
			 * well
			 */
			req.setCharacterEncoding(Constants.CHAR_ENCODING_UTF8);
			resp.setCharacterEncoding(Constants.CHAR_ENCODING_UTF8);

			validation = new Validation();
			commonFunction = new CommonFunction();

			/* Bean for UserDetails */
			userBean = commonFunction.getUserBean(req);

			/* Is the form data are valid? */
			if (validation.isValid(userBean)) {
				/* Get the connection to the database server */
				dbConnection = commonFunction.getConnection();

				/* Write User details into the database */
				commonFunction.addRecordIntoDatabase(dbConnection, userBean);

				/* Print User details on the browser */
				printInBrowser(userBean, resp);
			} else {
				/* To display old value to registration form */
				req.setAttribute(Constants.USERBEAN_BEAN_NAME, userBean);

				/* To display error message for invalid form data */
				req.setAttribute(Constants.VALIDATION_BEAN_NAME, validation);

				/* Forward to registration page */
				req.getRequestDispatcher(Constants.PATH_USER_REGISTRATION_ASSIGNMENT4).forward(req, resp);
			}
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
			userBean = null;
			validation = null;
			commonFunction = null;
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

	/**
	 * Prints the User details in the browser page
	 *
	 * @param userBean
	 *            The bean containing the User details
	 * @param resp
	 *            HttpServletResponse
	 * @throws IOException
	 *             If an IO error occurs
	 * @throws Exception
	 *             If all other than IO error occurs
	 */
	private void printInBrowser(UserBean userBean, HttpServletResponse resp) throws IOException, Exception {
		resp.setContentType(Constants.CONTENT_TYPE_TEXT_HTML);

		PrintWriter printWriter = resp.getWriter();

		String htmlUserDetail = new CommonFunction().getUserDetail(userBean, getServletContext().getContextPath());

		/* Print table on browser page */
		printWriter.println(htmlUserDetail);
	}
}