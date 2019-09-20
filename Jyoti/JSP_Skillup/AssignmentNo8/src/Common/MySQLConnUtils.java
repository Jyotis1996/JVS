package Common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import Common.Constants;

/**
 * Database connection
 * @author Jyoti
 *
 */
public class MySQLConnUtils {


   // Connect to MySQL
   public static Connection getMySQLConnection() throws SQLException,
           ClassNotFoundException {

       return getMySQLConnection(Constants.HOST_NAME, Constants.DATABASE_NAME, Constants.USERNAME, Constants.PASSWORD);
   }

   public static Connection getMySQLConnection(String hostName, String dbName,
           String userName, String password) throws SQLException,
           ClassNotFoundException {
       Class.forName(Constants.DRIVER_CLASS);

       String connectionURL =Constants.DRIVER + Constants.HOST_NAME + Constants.PORT + Constants.DATABASE_NAME;

       Connection conn = DriverManager.getConnection(connectionURL, Constants.USERNAME,Constants.PASSWORD);
       return conn;
   }
}