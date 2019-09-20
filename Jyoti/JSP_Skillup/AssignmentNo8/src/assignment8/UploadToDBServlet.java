package assignment8;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import Common.ConnectionUtils;
import Common.Constants;

/**
 * File upload to database
 * @author Jyoti
 *
 */
@WebServlet("/uploadToDB")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 2, // 2MB
        maxRequestSize = 1024 * 1024 * 50) // 50MB
public class UploadToDBServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    /**
	 *
	 * @param	request		HttpServletRequest
	 * @param	response	HttpServletResponse
	 * @throws	ServletException	if the request for the POST could not be handled
	 * @throws	IOException			if I/O process cause the error
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher(Constants.ASSIGNMENT8_PATH);

        dispatcher.forward(request, response);
    }

    @Override
    /**
	 *
	 * @param	request		HttpServletRequest
	 * @param	response	HttpServletResponse
	 * @throws	ServletException	if the request for the POST could not be handled
	 * @throws	IOException			if I/O process cause the error
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = null;
        try {
            // Connection to Database
            conn = ConnectionUtils.getMyConnection();
            conn.setAutoCommit(false);

            String description = request.getParameter(Constants.Description);

            // Part list (multi files).
            for (Part part : request.getParts()) {
                String fileName = extractFileName(part);
                if (fileName != null && fileName.length() > 0) {
                    // File data
                    InputStream is = part.getInputStream();
                    // Write to file
                    this.writeToDB(conn, fileName, is, description);
                }
            }
            conn.commit();

            // Upload successfully!.
            response.sendRedirect(request.getContextPath() + "/uploadToDBResults");
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute(Constants.ERROR_MESSAGE,Constants.ERROR  + e.getMessage());
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(Constants.ASSIGNMENT8_PATH);
            dispatcher.forward(request, response);
        } finally {
            this.closeQuietly(conn);
        }
    }

    /**
     * To extract file name
     * @param part
     * @return
     */
    private String extractFileName(Part part) {
        // form-data; name="file"; filename="C:\file1.zip"
        // form-data; name="file"; filename="C:\Note\file2.zip"
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                // C:\file1.zip
                // C:\Note\file2.zip
                String clientFileName = s.substring(s.indexOf("=") + 2, s.length() - 1);
                clientFileName = clientFileName.replace("\\", "/");
                int i = clientFileName.lastIndexOf('/');
                // file1.zip
                // file2.zip
                return clientFileName.substring(i + 1);
            }
        }
        return null;
    }

    /**
     * get the id from database
     * @param conn
     * @return
     * @throws SQLException
     */
    private Long getMaxAttachmentId(Connection conn) throws SQLException {
        String sql = Constants.SELECT_STATEMENT;
        PreparedStatement pstm = conn.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        if (rs.next()) {
            long max = rs.getLong(1);
            return max;
        }
        return 0L;
    }

    /**
     * Write file data to database attachment1
     * @param conn
     * @param fileName
     * @param is
     * @param description
     * @throws SQLException
     */
    private void writeToDB(Connection conn, String fileName, InputStream is, String description) throws SQLException {

        String sql = Constants.INSERT_STATEMENT;
        PreparedStatement pstm = conn.prepareStatement(sql);

        Long id = this.getMaxAttachmentId(conn) + 1;
        pstm.setLong(1, id);
        pstm.setString(2, fileName);
        pstm.setBlob(3, is);
        pstm.setString(4, description);
        pstm.executeUpdate();
    }

    /**
     * Close connection
     * @param conn
     */
    private void closeQuietly(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
        }
    }

}