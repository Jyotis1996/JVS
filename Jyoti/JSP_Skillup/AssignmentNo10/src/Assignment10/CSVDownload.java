package Assignment10;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Common.Constants;

/**
 * Servlet implementation class CSVDownload
 */
@WebServlet("/CSVDownload")
public class CSVDownload extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CSVDownload() {
        super();
    }

    public Connection getConnection() throws ClassNotFoundException, SQLException
    {
    	Class.forName(Constants.DRIVER_CLASS);
    	Connection con = DriverManager.getConnection(Constants.DATABASE_URL,Constants.DATABASE_USERNAME,Constants.DATABASE_PASSWORD);
    	return con;
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String filePath = Constants.FILE_PATH;

		try
		{
			FileWriter objFileWriter = new FileWriter(filePath);
			Connection con = getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(Constants.SELECT_QUERY);
			java.sql.ResultSetMetaData rsmetadata = rs.getMetaData();
			for(int i=1;i<=rsmetadata.getColumnCount();i++)
			{
				objFileWriter.append(rsmetadata.getColumnName(i));
				objFileWriter.append(",");
			}
			objFileWriter.append("\n");
			while(rs.next())
			{
				objFileWriter.append(rs.getString(1));
				objFileWriter.append(",");
				objFileWriter.append(rs.getString(2));
				objFileWriter.append(",");
				objFileWriter.append(rs.getString(3));
				objFileWriter.append(",");
				objFileWriter.append(rs.getString(4));
				objFileWriter.append(",");
				objFileWriter.append(rs.getString(5));
				objFileWriter.append(",");
				objFileWriter.append(rs.getString(6));
				objFileWriter.append(",");
				objFileWriter.append(rs.getString(7));
				objFileWriter.append(",");
				objFileWriter.append(rs.getString(8));
				objFileWriter.append(",");
				objFileWriter.append(rs.getString(9));
				objFileWriter.append(",");
				objFileWriter.append(rs.getString(10));
				objFileWriter.append(",");
				objFileWriter.append('\"');
				objFileWriter.append(rs.getString(11));
				objFileWriter.append('\"');
				objFileWriter.append(",");
				objFileWriter.append(rs.getString(12));
				objFileWriter.append("\n");
			}
			objFileWriter.flush();
			objFileWriter.close();
			con.close();
		}
		catch(Exception ae)
		{
			System.out.println("Error"+ae);
		}

		response.setContentType(Constants.CONTENT_TYPE);
		response.setHeader(Constants.HEADER,Constants.ATTACHMENT);
		FileInputStream fileInputStream = new FileInputStream(filePath);
		ServletOutputStream output = response.getOutputStream();
		byte[] outputbyte = new byte[4096];
		while (fileInputStream.read(outputbyte, 0, 4096)!= -1) {
			output.write(outputbyte,0,4096);
		}
		fileInputStream.close();
		output.flush();
		output.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
