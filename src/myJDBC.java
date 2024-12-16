import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public  class myJDBC {
    public Connection connectionSQL() {
        String url = "jdbc:mysql://127.0.0.1:3306/erp";
        String user = "root"; // MySQL username
        String password = "@Rozyar2005"; // MySQL password (empty string here)
        Connection connection = null;

        try {
             connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connection was successful ");

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Connection Failed");

        }
        return connection;
    }
}