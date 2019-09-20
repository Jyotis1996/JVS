
package common.util;

/**
 * @author Jyoti Date-2019/09/04
 */
public class Constants {

	
	public static final String ERROR = "ERROR";
	public static final String SUCCESS = "SUCCESS";
	//Connection variables
	public static final String DB_DriverName = "DBname";
	public static final String DB_URL="URL";
	public static final String DB_username  = "Username" ;
	public static final String Db_password = "Password";
	public static final String PATH="common.util.database";

	// login page variable
	public static final String ERRORIUP = "Please Enter Username and password";
	public static final String PASSOWORDREQUIRED="Password is required";
	public static final String USERNAMEREQUIRED="username is required";
	public static final String ADMIN="admin";
	public static final String INVALIDUSERNAMEPASSWORD ="Username and password is incorrect";
	public static final String ERROR1 ="error";
	public static final String LOGIN="login";
	public static final String CATEGORY="Category";
	public static final String CONNECTION="Database Connected !!!!";
	public static final String DISCONNECTION="Database Disonnected !!!!";
	public static final String LOGINSUCCESS="Log in successful !!!!!";


	// Database query
	public static final String QUERY_ASS_TWO = "select * from userdetails";
	public static final String QUERY_ASS2="SELECT firstname,middleinitial,lastname,sex,emailid,birthdate,address FROM userdetails where userid = '";
	public static final String QUERY_ASS2_3 = "select * from userdetails where UserId=? and Password=?";





}
