

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionJDBC {

    public static String DB_URL = "jdbc:mysql://localhost:3306/quiz?useSSL=false";
    public static String USER_NAME = "root";
    public static String PASSWORD = "hung28092003";


    public static Connection getConn() {
        try {
            // connnect to database 'quiz'
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
            return conn;
        } catch (Exception ex) {
            
            ex.printStackTrace();
            return null;
        }
        
    }

    public static Connection getConnection(String dbURL, String userName,
            String password) {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(dbURL, userName, password);
            System.out.println("connect successfully!");
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("connect failure!");
        }
        return conn;
    }
}
