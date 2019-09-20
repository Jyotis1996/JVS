package assignment8;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * File uploaded suuceefully following servlet page is called
 * @author Jyoti
 *
 */

@WebServlet("/uploadToDBResults")
public class UploadToDBResultsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;


    public UploadToDBResultsServlet() {
        super();
    }

    @Override
    /**
	 * process and check that file is uploaded successfully
	 *
	 * @param	request		HttpServletRequest
	 * @param	response	HttpServletResponse
	 * @throws	ServletException	if the request for the POST could not be handled
	 * @throws	IOException			if I/O process cause the error
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher
            = request.getServletContext().getRequestDispatcher("/JSP/assignment8/uploadToDBResults.jsp");

        dispatcher.forward(request, response);
    }

}