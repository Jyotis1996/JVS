package assignment1;

import java.io.IOException;
import java.io.PrintWriter;

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
public class UserDetails extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	/**
	 * Process and validates the form data sent by client
	 * and sends the bean to the client.
	 *
	 * @param	req		HttpServletRequest
	 * @param	resp	HttpServletResponse
	 * @throws	ServletException	if the request for the POST could not be handled
	 * @throws	IOException			if I/O process cause the error
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		Validation validation = null;
		CommonFunction commonFunction = null;
		UserBean userBean = null;
		PrintWriter out = resp.getWriter();

		try {

			validation = new Validation();
			commonFunction = new CommonFunction();

			/* Retrieve the UserBean containing client data */
			userBean = commonFunction.getUserBean(req);


			/* Is the form data are valid? */
			if (validation.isValid(userBean)) {
				/* Print on console */
				commonFunction.printOnConsole(userBean);

				req.setAttribute(Constants.MESSAGE, Constants.MSG_REG_SUCCESS);

				/* Forward to registration page */
				req.getRequestDispatcher(
						Constants.PATH_USER_REGISTRATION_ASSIGNMENT1).forward(
						req, resp);
			} else {
				/* To display old value to registration form */
				req.setAttribute(Constants.USERBEAN_BEAN_NAME, userBean);

				/* To display error message for invalid form data */
				req.setAttribute(Constants.VALIDATION_BEAN_NAME, validation);

				/* Forward to registration page */
				req.getRequestDispatcher(
						Constants.PATH_USER_REGISTRATION_ASSIGNMENT1).forward(
						req, resp);
			}
		} catch (Exception e) {
			out.println("<TABLE align=center background-color = white width=320px>");
			out.println("<TD><font color=red>Please fill all the fields</font></TD>");
			out.println("</TABLE>");
			req.getRequestDispatcher(
					Constants.PATH_USER_REGISTRATION_ASSIGNMENT1).include(req, resp);


		} finally {
			validation = null;
			commonFunction = null;
			userBean = null;
		}
	}

	@Override
	/**
	 * Redirects control to doPost()
	 *
	 * @param	req		HttpServletRequest
	 * @param	resp	HttpServletResponse
	 * @throws	ServletException	if the request for the POST could not be handled
	 * @throws	IOException			if I/O process cause the error
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Validation validation = null;
		CommonFunction commonFunction = null;
		UserBean userBean = null;
		PrintWriter out = resp.getWriter();

		try {
			validation = new Validation();
			commonFunction = new CommonFunction();

			/* Retrieve the UserBean containing client data */
			userBean = commonFunction.getUserBean(req);

			/* Is the form data are valid? */
			if (validation.isValid(userBean)) {
				/* Print on console */
				commonFunction.printOnConsole(userBean);

				req.setAttribute(Constants.MESSAGE, Constants.MSG_REG_SUCCESS);

				/* Forward to registration page */
				req.getRequestDispatcher(
						Constants.PATH_USER_REGISTRATION_ASSIGNMENT1).forward(
						req, resp);
			} else {
				/* To display old value to registration form */
				req.setAttribute(Constants.USERBEAN_BEAN_NAME, userBean);

				/* To display error message for invalid form data */
				req.setAttribute(Constants.VALIDATION_BEAN_NAME, validation);

				/* Forward to registration page */
				req.getRequestDispatcher(
						Constants.PATH_USER_REGISTRATION_ASSIGNMENT1).forward(
						req, resp);
			}
		} catch (Exception exception) {

			out.println("<TABLE align=center background-color = white width=320px>");
			out.println("<TD><font color=red>Please fill all the fields</font></TD>");
			out.println("</TABLE>");
			req.getRequestDispatcher(
					Constants.PATH_USER_REGISTRATION_ASSIGNMENT1).include(req, resp);
		} finally {
			validation = null;
			commonFunction = null;
			userBean = null;
		}
	}
}