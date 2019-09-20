package assignment2;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
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
 */
public class UserDetailsA extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/* To hold connection to the database server */
	private Connection dbConnection;

	/*
	 * If error occurred when creating database connection at Servlet
	 * initialization
	 */
	private String errorMessage;

	@Override
	/**
	 * Initializes the servlet and makes connection to the database server.
	 *
	 * @throws ServletException
	 *             if the servlet's normal operation causes error
	 */
	public void init() throws ServletException {
		try {
			/* Loading the MySQL database driver */
			Class.forName(Constants.DRIVER_CLASS);

			/*
			 * Creating the connection to the MySQL database server with
			 * credentials
			 */
			this.dbConnection = DriverManager.getConnection(Constants.DATABASE_URL, Constants.DATABASE_USERNAME,
					Constants.DATABASE_PASSWORD);
		} catch (SQLException sqlException) {
			this.errorMessage = sqlException.getMessage();
		} catch (ClassNotFoundException classNotFoundException) {
			this.errorMessage = Constants.MSG_CONN_ERROR;
		} catch (Exception exception) {
			this.errorMessage = exception.getMessage();
		}
	}

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

		try {
			if (this.errorMessage != null) {
				throw new Exception(this.errorMessage);
			} else {
				validation = new Validation();
				commonFunction = new CommonFunction();

				/* Bean for UserDetails */
				userBean = commonFunction.getUserBean(req);

				/* Is the form data are valid? */
				if (validation.isValid(userBean)) {
					/* Write User details into the database */
					commonFunction.addRecordIntoDatabase(this.dbConnection, userBean);

					req.setAttribute(Constants.MESSAGE, Constants.MSG_REG_SUCCESS);

					/* Forward to registration page */
					req.getRequestDispatcher(Constants.PATH_USER_REGISTRATION_ASSIGNMENT2).forward(req, resp);
				} else {
					/* To display old value to registration form */
					req.setAttribute(Constants.USERBEAN_BEAN_NAME, userBean);

					/* To display error message for invalid form data */
					req.setAttribute(Constants.VALIDATION_BEAN_NAME, validation);

					/* Forward to registration page */
					req.getRequestDispatcher(Constants.PATH_USER_REGISTRATION_ASSIGNMENT2).forward(req, resp);
				}
			}
		} catch (Exception exception) {
			req.setAttribute(Constants.ERROR, exception.getMessage());
			req.getRequestDispatcher(Constants.PATH_ERROR_PAGE).forward(req, resp);
		} finally {
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

	@Override
	/**
	 * Closes the connection to the database server and clears the memory
	 * references.
	 *
	 */
	public void destroy() {
		/* Closing and clearing memory references, when no more needed. */
		if (this.dbConnection != null) {
			try {
				this.dbConnection.close();
			} catch (SQLException sqlException) {
				this.errorMessage = sqlException.getMessage();
			} catch (Exception exception) {
				this.errorMessage = exception.getMessage();
			} finally {
				this.dbConnection = null;
			}
		}
	}
}