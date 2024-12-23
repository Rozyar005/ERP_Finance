package ERP;
import java.util.Scanner;
import Database.myJDBC;
import java.sql.*;

public class Log_In {
    myJDBC jdbc = new myJDBC();
    Scanner input = new Scanner(System.in);


    public void login() {
        System.out.println("Please Enter the user_id: ");
        String user_id = input.next();
        System.out.println("Enter the Password: ");
        String pass = input.next();

        try {
            jdbc.connectionSQL();
            String query = "SELECT * FROM users WHERE user_id = ? AND password = ?";
            ResultSet resultSet = jdbc.executePreparedQuery(query, user_id, pass);


            if (resultSet.next()) {
                // If a match is found, get the role and department
                String role = resultSet.getString("role");
                int userID =resultSet.getInt("user_id");
                String dept = resultSet.getString("department");
                String username = resultSet.getString("username");



                // You can now use these values (for example, creating a Directory object)
                Directory d = new Directory(role,userID,dept,username);
            } else {
                System.out.println("Invalid username or password. Please try again.");
                login(); // Call login again if the credentials are incorrect
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
