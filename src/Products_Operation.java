import java.util.Scanner;
import java.sql.*;

public class Products_Operation {
    Connection conn;
    myJDBC jdbc=new myJDBC();

    public void sellPro(){
        try {
            conn = jdbc.connectionSQL();
            String query = "SELECT ProductName, Price , Quantity , date , Status , Description  FROM Product WHERE DeptID = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            System.out.println("Products in Sales department:");
            System.out.printf("%-10s %-15s%n", "User ID", "Username");
            System.out.println("--------------------------------");


            boolean hasResults = false;
            while (resultSet.next()) {
                hasResults = true;
                int user_id = resultSet.getInt("user_id");
                String username = resultSet.getString("username");
                System.out.printf("%-10d %-15s%n", user_id, username);
            }

            if (!hasResults) {
                System.out.println("No employees found in this department.");
                return;
            }
            return;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
