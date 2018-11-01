
package Connection;
import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnectionClass {
    private static DatabaseConnectionClass dbConnection = null; //this is a class variable and will be 
    //shared between all objects of this class at runtime. 
    Connection conn = null;
    String url;
    String dbName;
    String userName;
    String password;

    String driver;

    private DatabaseConnectionClass() {
    }

    public static DatabaseConnectionClass getInstance() {
        if (dbConnection == null) {
            dbConnection = new DatabaseConnectionClass();
        }
        return dbConnection;
    }

    public Connection getMySqlConnection(String url, String dbName, String userName, String password, String driver) {
        try {
            Class.forName(driver).newInstance();//this will provide an instance of DriverManager
            conn = DriverManager.getConnection(url + dbName, userName, password);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return conn;

    }
}
