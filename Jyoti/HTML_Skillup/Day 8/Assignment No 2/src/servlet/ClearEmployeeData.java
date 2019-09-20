package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Class Name:ClearEmployeeData Description:Implemented servlet for
 * ClearEmployeeData class
 *
 * @author Jyoti
 */

public class ClearEmployeeData extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ClearEmployeeData() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Setting up the content type of webpage
		response.setContentType("text/html");

		// Writing message to the web page
		PrintWriter out = response.getWriter();

		out.println("<!DOCTYPE HTML>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">");
		out.println("<title>Clearing Data</title>");
		out.println("<link rel=\"stylesheet\" href=\"css/style2.css\">");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class=\"container\">");

		try {

			String filePath = "D:\\JVS_WS\\HTMLSkillup\\Day 8\\Assignment No 2\\LocalStorage\\Employees.txt";

			File outputFile = new File(filePath);
			FileWriter fileWriter = new FileWriter(outputFile);
			PrintWriter printWriter = new PrintWriter(fileWriter);
			printWriter.println("");
			printWriter.close();

			out.println("<div style=\"overflow-x:hidden;\" class=\"fetchedData\">");
			out.println(" <p> ");
			out.println("Data cleared successfully !");
			out.println("</p>");
			out.println("</div>");

		} catch (Exception e) {
			out.println("<div class=\"fetchedData\">");
			out.println(" <p> ");
			out.println("Error clearing Data !");
			out.println("</p>");
			out.println("</div>");

		}

		out.println("</div>");
		out.println("</body>");
		out.println("<br><br><br><br>");

		out.println(
				"<a type=\"button\" class=\"button\" href=\"index.jsp\" style=\"text-decoration: none;\">Go Back</a>");

		out.println("</html>");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
