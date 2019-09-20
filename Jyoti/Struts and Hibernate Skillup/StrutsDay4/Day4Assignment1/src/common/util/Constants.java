package common.util;

/**
 *Constants file to avoid hardcoded literals
 *
 */
public class Constants {

	//Static final String variables
	public static final String DB_DriverName = "DBname";
	public static final String DB_URL="URL";
	public static final String DB_username  = "Username" ;
	public static final String Db_password = "Password";
    public static final String PROPERTIES = "common.util.database";
    public static final String FILE_UPLOAD = "D:/Struts/Day4Assignment1/WebContent/WEB-INF/Upload/";
    public static final String FILE_UPLOAD_SUCCESSFULL =  "Upload successfully completed";
    public static final String NOT_IMAGE_FILE ="Uploaded file is not image file, please upload only image files";
    public static final String FILE_SIZE_EXCEEDS ="Your image size extends the limit of 20mb";
    public static final String SELECT_IMAGE ="Please select image file first then try to upload";
    public static final String QUERY ="INSERT INTO IMAGE_UPLOAD(NAME,IMAGE) VALUES(?,?)";
    public static final String UPLOAD_SUCCESS ="File Uploaded to database";
    public static final String UPLOAD_UNSUCCESSFUL =" File not uploaded to database";
    public static final String IMAGE_NOT_SELECTED = "Please image select file first \n  If you select file other than image file can not uploaded";

	public void getPropertyValue() {

	}
}
