import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;

public class Employee extends AbstractClass{
    public Employee(String id, String username, String password, String role, String department) {
        super(id, username, password, role, department);
    }

    public Employee(){

    }

    @Override
    public void performFunctionality() {
    }

    public void Display(){
        myJDBC jdbc=new myJDBC();
        Connection conn ;

        String query = "SELECT user_id, username, department FROM users WHERE role = 'Employee';";

        try {
            conn = jdbc.connectionSQL();
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            System.out.println("Employee Information:");
            System.out.printf("%-10s %-15s %-15s%n", "User ID", "Username", "Department");
            System.out.println("---------------------------------------------");

            while (resultSet.next()) {
                int userId = resultSet.getInt("user_id");
                String username = resultSet.getString("username");
                String department = resultSet.getString("department");

                System.out.printf("%-10d %-15s %-15s%n", userId, username, department);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


