package assignment1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Constants;

/**
 * Redirects the user to the Registration page.
 */
public class UserDetails_pre extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	/**
	 * Redirect user to the registration page
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
		try {
			/* Redirect user to the registration page */
			req.getRequestDispatcher(Constants.PATH_USER_REGISTRATION_ASSIGNMENT1).forward(req, resp);
		} catch (Exception exception) {
			/* Redirect to the Error page, if error occurs. */
			req.setAttribute(Constants.ERROR, exception.getMessage());
			req.getRequestDispatcher(Constants.PATH_ERROR_PAGE).forward(req, resp);
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
	 *             if the request for the GET could not be handled
	 * @throws IOException
	 *             if I/O process cause the error
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			/* Redirect user to the registration page */
			req.getRequestDispatcher(Constants.PATH_USER_REGISTRATION_ASSIGNMENT1).forward(req, resp);
		} catch (Exception exception) {
			/* Redirect to the Error page, if error occurs. */
			req.setAttribute(Constants.ERROR, exception.getMessage());
			req.getRequestDispatcher(Constants.PATH_ERROR_PAGE).forward(req, resp);
		}
	}
}