package Database;

import java.sql.*;

public class myJDBC {
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/erp";
    private static final String USER = "root";
    private static final String PASSWORD = "@Rozyar2005";

    public static Connection connection = null;

    public static Connection connectionSQL() {
        try {

                connection = DriverManager.getConnection(URL, USER, PASSWORD);

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Connection Failed.");
        }
        return connection;
    }

    public static ResultSet executeQuery(String query) {
        ResultSet resultSet = null;
        try {
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            System.err.println("Error executing query: " + e.getMessage());
        }
        return resultSet;
    }

    public static int executeUpdate(String query) {
        int rowsAffected = 0;
        try {
            Statement statement = connection.createStatement();
            rowsAffected = statement.executeUpdate(query);
        } catch (SQLException e) {
            System.err.println("Error executing update: " + e.getMessage());
        }
        return rowsAffected;
    }

    public static ResultSet executePreparedQuery(String query, Object... params) {
        ResultSet resultSet = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            // Assign parameters dynamically
            for (int i = 0; i < params.length; i++) {
                preparedStatement.setObject(i + 1, params[i]);
            }

            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            System.err.println("Error executing prepared query: " + e.getMessage());
        }
        return resultSet;
    }

    public static int executePreparedUpdate(String sql, Object... params) {
        int rowsAffected = 0;
        try {
            connectionSQL(); // Ensure connection
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            // Assign parameters dynamically
            for (int i = 0; i < params.length; i++) {
                preparedStatement.setObject(i + 1, params[i]);
            }

            rowsAffected = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error executing prepared update: " + e.getMessage());
        }
        return rowsAffected;
    }


}
