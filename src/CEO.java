import java.sql.*;

public class CEO extends AbstractClass{
    myJDBC jdbc = new myJDBC();

    public CEO(String id, String username, String password, String role, String department) {
        super(id, username, password, role, department);
    }
    public CEO(){
        super();
    }

    @Override
    public void performFunctionality() {
        System.out.println("CEO functionalities: View and manage all data.");
        // Implement CEO-specific logic here
    }

    public void Display(){
        Connection conn ;

        String query = "SELECT user_id, username, department FROM users WHERE role = 'CEO';";

        try {
             conn = jdbc.connectionSQL();
             Statement statement = conn.createStatement();
             ResultSet resultSet = statement.executeQuery(query);

            System.out.println("CEO Information:");
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

