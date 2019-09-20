package servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

/**
 * Class name:AddEmployeeData Description:implemented servlet for
 * AddEmployeeData class
 *
 * @author Jyoti
 *
 */
public class AddEmployeeData extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	public AddEmployeeData() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Setting up the content type of webpage
		response.setContentType("text/html");

		// Writing message to the web page
		PrintWriter out = response.getWriter();

		try {

			String name = request.getParameter("name");

			Long phoneno = Long.parseLong(request.getParameter("mn"));
			String role = request.getParameter("role");

			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://172.16.1.15:3306/northwind_jyoti",
					"jyoti", "jyoti@741");
			Statement statement = connection.createStatement();
			statement.executeUpdate("insert into employeedata(name,phoneno,role) values('" + name + "'," + phoneno
					+ ",'" + role + "')");

			String filePath = "D:\\JVS_WS\\HTMLSkillup\\Day 8\\Assignment No 2\\LocalStorage\\Employees.txt";

			File outputFile = new File(filePath);
			FileWriter fileWriter = new FileWriter(outputFile, true);
			PrintWriter printWriter = new PrintWriter(fileWriter);
			printWriter.println(name + "," + phoneno + "," + role);

			printWriter.close();

			out.println("<script type=\"text/javascript\">");
			out.println("alert('Employee details added successfully !');");
			out.println("location='index.jsp';");
			out.println("</script>");

		} catch (Exception e) {

			response.sendRedirect("index.jsp");
		}

	}

}