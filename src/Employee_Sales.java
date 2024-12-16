import java.sql.*;
import java.util.Scanner;
public class Employee_Sales extends Employee{
    public Employee_Sales(String id, String username, String password, String role, String department) {
        super(id, username, password, role, department);
    }

    public Employee_Sales() {
        super();
    }


    @Override
    public void performFunctionality() {
        System.out.println("Sales Employee functionalities:");
        System.out.println("Enter one of the operations you want to follow 1.Sell Products 2.Transaction History 3.Personal Info");
        int op= input.nextInt();
        switch (op){
            case 1:
                Products_Operation productsOperation=new Products_Operation();
                productsOperation.sellPro();
                break;
            case 2:
                Transactions transactions=new Transactions();
                transactions.SellTrans();
                break;
            case 3:
                this.Display();
                break;

        }

    }

    @Override
    public void Display() {
        myJDBC jdbc=new myJDBC();
        Connection conn ;

        String query = "SELECT user_id, username, department , Amount FROM users, Budget WHERE role = 'Employee' and department='Sales';";

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


