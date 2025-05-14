package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
    private static Connection connection;

    public static Connection getConnection() throws SQLException {
        // If the connection is null or closed, create a new one
        if (connection == null || connection.isClosed()) {
            // Database connection URL and credentials
            String url = "jdbc:mysql://localhost:3306/sakila";
            String user = "root";
            String password = "root";
            // Establish the connection
            connection = DriverManager.getConnection(url, user, password);
        }
        // Return the established connection
        return connection;
    }
    // Method to close the connection after tests are done
    public static void closeConnection() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }
}


