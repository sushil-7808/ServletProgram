package util;
import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {

    public Connection connection = null;

    //Initializing connection in the constructor
    public DatabaseConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String username = "root";
            String password = "Krishna123@";
            String URL = "jdbc:mysql://localhost:3306/servlet";

            connection = DriverManager.getConnection(URL, username, password);

        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

}
