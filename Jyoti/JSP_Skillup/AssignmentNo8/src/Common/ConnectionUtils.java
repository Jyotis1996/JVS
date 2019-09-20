package Common;

import java.sql.Connection;
import java.sql.SQLException;
import Common.Constants;

/**
 * Get the database connection and test it wether connection is working or not
 * @author Jyoti
 *
 */
public class ConnectionUtils {

    public static Connection getMyConnection() throws SQLException,
            ClassNotFoundException {

        return MySQLConnUtils.getMySQLConnection();
    }

    //
    // Test Connection ...
    //
    public static void main(String[] args) throws SQLException,
            ClassNotFoundException {

        System.out.println(Constants.GET_CONNECTION);

        // Get a Connection object
        Connection conn = ConnectionUtils.getMyConnection();

        System.out.println(Constants.GET_CONNECTION + conn);

        System.out.println(Constants.CONNECTION_DONE);
    }

}