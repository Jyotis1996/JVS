package assignment9;

import java.io.IOException;
import java.io.InputStream;

import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Common.Constants;
/**
 * Servlet implementation class Download
 */
@WebServlet("/FileDownload")
public class FileDownload extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private String id = null;
    private Blob fileData = null;
    private String fileName = null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileDownload() {
        super();
    }
    public Connection getConnection() throws ClassNotFoundException, SQLException
   	{
   		Class.forName(Constants.DRIVER_CLASS);
   		Connection con =DriverManager.getConnection(Constants.DATABASE_URL, Constants.DATABASE_USERNAME, Constants.DATABASE_PASSWORD);
   		return con;
   	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		@SuppressWarnings("unused")
		ServletOutputStream output = response.getOutputStream();
		id = request.getParameter(Constants.DOWNLOAD);
		try
		{
			Connection con = getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(Constants.SELECT_QUERY +Integer.parseInt(id));
			while(rs.next())
			{
				fileData = rs.getBlob(Constants.FILE_DATA);
				fileName = rs.getString(Constants.FILE_NAME);
			}
		}
		catch(Exception ae)
		{
			System.out.println("Error:"+ae);
		}
		String mimeType = this.getServletContext().getMimeType(fileName);
		response.setContentType(mimeType);
		response.setHeader("Content-disposition","attachment; filename=");
		InputStream is = null;
		try {
			is = fileData.getBinaryStream();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		byte[] bytes = new byte[1024];
        int bytesRead;
        while ((bytesRead = is.read(bytes)) != -1) {
            // Write image data to Response.
            response.getOutputStream().write(bytes, 0, bytesRead);
        }
        is.close();

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
