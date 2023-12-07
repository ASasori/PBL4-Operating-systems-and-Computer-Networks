package quizserver;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionJDBC {

    public static String DB_URL = "jdbc:mysql://localhost:3306/quiz?useSSL=false";
//    public static String url="jdbc:mysql://127.0.0.1:3306/quiz";
    public static String USER_NAME = "root";
    public static String PASSWORD = "Javascript29";


    public static Connection getConn() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            // connnect to database 'quiz'
            Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
            System.out.println("Connection to DB successfull");
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
