package Common;

/**
 * Represents the messages including label, string, path and error messages.
 *
 *
 *
 */
public class Constants {

	/* Connection Provider */
	public final static String DRIVER_CLASS = "com.mysql.jdbc.Driver";
	public final static String HOST_NAME="172.16.1.15";
	public final static String DATABASE_NAME="northwind_jyoti";
	public final static String USERNAME = "jyoti";
	public final static String PASSWORD = "jyoti@741";
	public final static String DRIVER = "jdbc:mysql://";
	public final static String PORT = ":3306/";

	public final static String ASSIGNMENT8_PATH = "/JSP/assignment8/uploadToDB.jsp";
	public final static String Description = "description";
	public final static String ERROR_MESSAGE = "errorMessage";
	public final static String ERROR = "Error: ";
	public final static String SELECT_STATEMENT = "Select max(a.id) from Attachment1 a";
	public final static String INSERT_STATEMENT = "Insert into Attachment1(Id,File_Name,File_Data,Description) "  + " values (?,?,?,?) ";




	public final static String GET_CONNECTION = "Get connection ... ";
	public final static String CONNECTION_DONE = "Done!";

}