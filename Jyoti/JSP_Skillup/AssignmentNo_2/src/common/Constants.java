package common;

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

	/* Form fields names */
	public final static String ADMIN = "admin";
	public final static String USERID = "userId";
	public final static String PASSWORD = "password";
	public final static String SALUTATION = "salutation";
	public final static String FIRSTNAME = "firstName";
	public final static String MIDDLE_INITIAL = "middleInitial";
	public final static String LASTNAME = "lastName";
	public final static String SEX = "sex";
	public final static String EMAILID = "emailId";
	public final static String BIRTH_DAY = "day";
	public final static String BIRTH_MONTH = "month";
	public final static String BIRTH_YEAR = "year";
	public final static String ADDRESS = "address";
	public final static String INTEREST = "interest";
	public final static String OTHER_INTEREST = "otherInterests";

	/* Label for printing purpose only */
	public final static String LABEL_HEADER = "===============UserDetails===============\n";
	public final static String LABEL_USERID = "UserId";
	public final static String LABEL_PASSWORD = "Password";
	public final static String LABEL_SALUTATION = "Salutation";
	public final static String LABEL_FIRSTNAME = "First Name";
	public final static String LABEL_MIDDLE_INITIAL = "Middle Initial";
	public final static String LABEL_LASTNAME = "Last Name";
	public final static String LABEL_SEX = "Sex";
	public final static String LABEL_EMAILID = "Email Id";
	public final static String LABEL_BIRTH_DATE = "BirthDate";
	public final static String LABEL_ADDRESS = "Address";
	public final static String LABEL_INTEREST = "Interest";
	public final static String LABEL_OTHER_INTEREST = "Other Interests";
	public final static String LABEL_FOOTER = "=========================================";

	public final static String STRING_NONE = "";
	public final static String STRING_COLON = " : ";
	public final static String STRING_COMMA = ", ";
	public final static String STR_COMMA = ", ";
	public final static String STRING_DOUBLE_QUOTE = "\"";
	public final static String STRING_SPACE = "/";
	public final static String STRING_MALE = "Male";
	public final static String STRING_FEMALE = "Female";
	public final static String STRING_DAY = "Day";
	public final static String STRING_MONTH = "Month";
	public final static String STRING_YEAR = "Year";
	public final static String STRING_MESSAGE = "message";
	public final static String STRING_FILELIST = "FileList";

	public final static String LINE_SEPARATOR = "line.separator";

	public final static String DATE_FORMAT = "DD/MM/YYYY";

	public final static String CHAR_ENCODING_UTF8 = "UTF-8";
	public final static String CONTENT_TYPE_TEXT_HTML = "text/html";

	public final static String HTML_NEWLINE = "<BR>";
	public final static String HTML_BOLD_START = "<B>";
	public final static String HTML_BOLD_END = "</B>";
	public final static String HTML_LINK_TO_CSS_START = "<Link type='text/css' rel='stylesheet' href='";
	public final static String HTML_LINK_TO_CSS_END = "/CSS/Login.css' />";
	public final static String HTML_DIV_START = "<DIV class='center'>";
	public final static String HTML_DIV_END = "</DIV>";
	public final static String HTML_TABLE_START = "<TABLE align='center' border='2' cellspacing='2'>";
	public final static String HTML_TABLE_END = "</TABLE>";
	public final static String HTML_TABLE_HEADER = "<TH colspan='2'>User Details</TH>";
	public final static String HTML_TR_TD = "<TR><TD>";
	public final static String HTML_TD = "<TD>";
	public final static String HTML_REG_SUCCESS_MESSAGE = "<div align='center' style='color:green;font-weight: bold;'>Registration is done successfully.</div>";

	public final static String MESSAGE = "Message";
	public final static String ERROR = "Error";
	public final static String USERLIST = "UserList";
	public final static String READONLY = "ReadOnly";
	public final static String DISABLED = "Disabled";

	public final static String EDIT_UPDATE = "EditUpdate";
	public final static String LOGOUT_CANCEL = "LogOutCancel";
	public final static String EDIT = "Edit";
	public final static String UPDATE = "Update";
	public final static String LOGOUT = "Logout";
	public final static String CANCEL = "Cancel";

	public final static String USERBEAN_BEAN_NAME = "userBean";
	public final static String VALIDATION_BEAN_NAME = "validation";

	public final static String PATH_USER_REGISTRATION_ASSIGNMENT1 = "/JSP/assignment1/UserDetails.jsp";
	public final static String PATH_USER_REGISTRATION_ASSIGNMENT2 = "/JSP/assignment2/UserDetails.jsp";
	public final static String PATH_USER_REGISTRATION_ASSIGNMENT3 = "/JSP/assignment3/UserDetails.jsp";
	public final static String PATH_USER_REGISTRATION_ASSIGNMENT4 = "/JSP/assignment4/UserDetails.jsp";
	public final static String PATH_LOGIN_ASSIGNMENT5 = "/JSP/assignment5/Login.jsp";
	public final static String PATH_USER_DETAILS_ASSIGNMENT5 = "/JSP/assignment5/UserDetails.jsp";
	public final static String PATH_EDIT_USER_DETAILS_ASSIGNMENT6 = "/JSP/assignment6/EditUserDetails.jsp";
	public final static String PATH_LIST_USERS_ASSIGNMENT7 = "/JSP/assignment7/ListUsers.jsp";

	public final static String PATH_ERROR_PAGE = "/JSP/Error.jsp";

	public final static String UPLOAD_DIR_PATH = "/Upload/";
	public final static String CSV_FILE_NAME = "UserData.csv";

	public final static String MIMETYPE_APPLICATION = "application/octet-stream";

	public final static String HEADER_CONTENT_DISPOSITION = "Content-Disposition";
	public final static String ATTACHMENT_FILE = "attachment; filename=\"";

	public final static String MSG_REG_SUCCESS = "Registration is done successfully.";
	public final static String MSG_UPDATE_SUCCESS = "User details have been updated successfully.";
	public final static String MSG_CONN_ERROR = "Error occurred while connecting to the database. <br>The driver class might be invalid or not found.";
	public final static String MSG_INVALID_LOGIN = "Either UserId or Password is invalid.";
	public final static String MSG_NO_USER = "No User was found in the database.";
	public final static String MSG_UPLOAD_SUCCESS = "File was uploaded successfully.";

	public final static String QUERY_INSERT_RECORD = "INSERT INTO USERDETAILS(USERID,PASSWORD,SALUTATION,FIRSTNAME,MIDDLEINITIAL,LASTNAME,SEX,EMAILID,BIRTHDATE,ADDRESS,AREAOFINTEREST,OTHERINTEREST) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
	public final static String QUERY_UPDATE_RECORD = "UPDATE USERDETAILS SET PASSWORD=?,SALUTATION=?,FIRSTNAME=?,MIDDLEINITIAL=?,LASTNAME=?,SEX=?,EMAILID=?,BIRTHDATE=?,ADDRESS=?,AREAOFINTEREST=?,OTHERINTEREST=? WHERE USERID=?";
	public final static String QUERY_SEARCH_RECORD = "SELECT * FROM USERDETAILS WHERE BINARY USERID=? AND BINARY PASSWORD=?";
	public final static String QUERY_LIST_ALL_USERS = "SELECT USERID,PASSWORD,SALUTATION,FIRSTNAME,MIDDLEINITIAL,LASTNAME,SEX,EMAILID,BIRTHDATE,ADDRESS,AREAOFINTEREST,OTHERINTEREST FROM USERDETAILS";

	/* REGEX criteria for specific user details */
	public final static String REGEX_USERID = "[a-zA-Z]+[a-zA-Z_0-9]*";
	public final static String REGEX_NAME = "[a-zA-Z\u3041-\u3096\u30A0-\u30FF\u4E00-\u9FBF]+";
	public final static String REGEX_MALE_SALUTATION = "Mr.|Dr.";
	public final static String REGEX_FEMALE_SALUTATION = "Ms.|Mrs.|Dr.";
	public final static String REGEX_EMAILID = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";

	/* Error messages */
	public final static String NO_FILE_UPLOADED = "No file(s) have been uploaded.";

	public final static String NO_ACCESS = "You do not have access to upload a file on the server.";

	public final static String NO_USERID = "Please enter UserID";
	public final static String INVALID_USERID = "You have entered invalid UserID. UserID must start with an english alphabet and rest of should be alphanumberic.";
	public final static String SHORT_USERID = "UserId must be atleast 6 characters long.";

	public final static String NO_PASSWORD = "Please enter Password";
	public final static String SHORT_PASSWORD = "Password must be atleast 6 characters long.";

	public final static String INVALID_SALUTATION_FOR_SEX = "Invalid salutation is selected for sex. Please select valid salutation or sex.";

	public final static String NO_FIRSTNAME = "Please enter First Name";
	public final static String INVALID_FIRSTNAME = "You have entered invalid First Name. First Name must be in alphabets.";

	public final static String INVALID_MIDDLE_INITIAL = "You have entered invalid Middle Initial. Middle Initial must be in alphabets.";

	public final static String NO_LASTNAME = "Please enter Last Name";
	public final static String INVALID_LASTNAME = "You have entered invalid Last Name. Last Name must be in alphabets.";

	public final static String NO_SEX_SELECTED = "Please select sex";

	public final static String INVALID_EMAILID = "You have entered an invalid Email Id.";

	public final static String NO_DAY_SELECTED = "Please select Birth Day";
	public final static String NO_MONTH_SELECTED = "Please select Birth Month";
	public final static String NO_YEAR_SELECTED = "Please select Birth Year";
	public final static String INVALID_BIRTHDATE = "Birth Date is invalid. Please select valid Birth Date.";

	public final static String NO_INTEREST = "Please select atleast an interest OR specify in other interests.";
}