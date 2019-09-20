/**
 * Class Name :AddEmployeesData
 * Description: AddEmployeesData class is defined to implement servlet
 * @author Jyoti Created Date:2019/08/09
 */
package com.employees_data;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AddEmployeesData")
public class AddEmployeesData extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * call constructor of class
	 */
    public AddEmployeesData() {
        super();
    }

    /**
	 * doGet() method to request servelet connection and give servlet response
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * call doGet() method inside doPost() method
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

