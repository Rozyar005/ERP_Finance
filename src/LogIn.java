import java.sql.*;
import java.util.Scanner;

public class LogIn {
    Connection conn;


    myJDBC jdbc = new myJDBC();
    Scanner input = new Scanner(System.in);


    public void login() {
        System.out.println("Please Enter the Username: ");
        String username = input.next();
        System.out.println("Enter the Password: ");
        String pass = input.next();


        try {
            conn = jdbc.connectionSQL();
            String query = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, pass);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String role = resultSet.getString("role");
                String department = resultSet.getString("department");
                Directory d = new Directory(username, role, department);
            } else {
                System.out.println("Invalid username or password. Please try again.");
                login();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
