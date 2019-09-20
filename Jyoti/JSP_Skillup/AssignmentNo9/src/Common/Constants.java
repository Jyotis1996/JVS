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
	public final static String DATABASE_URL = "jdbc:mysql://172.16.1.15:3306/northwind_jyoti?useSSL=false";
	public final static String DATABASE_USERNAME = "jyoti";
	public final static String DATABASE_PASSWORD = "jyoti@741";
	public final static String DOWNLOAD = "download";
	public final static String SELECT_QUERY = "select file_name,file_data from attachment1 where id=";
	public final static String FILE_DATA = "file_data";
	public final static String FILE_NAME = "file_name";

}