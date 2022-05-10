package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBContext {

   private static java.sql.Connection connection = null;
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3030/se04_de150334";
    static final String DB_USER = "root";
    static final String DB_PASS = "12345";

    public static java.sql.Connection getConnection() {
     
        if (connection != null) {
            return connection;
        } else {
            try {
                Class.forName(JDBC_DRIVER);
                connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            } catch (ClassNotFoundException e) {
                // TODO: handle exception
                e.printStackTrace();
            } catch (SQLException e) {
                // TODO: handle exception
                e.printStackTrace();
            }
            return connection;
        }
    }
}
