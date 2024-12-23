package ERP;
import Finance.Revenue;
import Permission.SalesHeadPermissions;
import Products.RemoveProducts;
import Products.viewProducts;
import Database.myJDBC;
import User_Operations.UpdateUsers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class SalesHead extends Users implements SalesHeadPermissions {


    Scanner input=new Scanner(System.in);
    public SalesHead() {
    }

    public SalesHead(int id, String username, String role, String department) {
        super(id, username, role, department);
    }

    @Override
    public void directory() {
        boolean keepRunning = true;  // Flag to keep the loop running
        while (keepRunning) {
            System.out.println("Welcome Head of Sales ! (Choose one of the Operations: 1.View Sales Employee 2.Update Users 3.View Revenue 4.Remove Products 5.exit)");
            int op = input.nextInt();

                switch (op){
                    case 1:
                        viewEmployeeInfo("Sales");
                        break;
                    case 2:
                        updateSalesEmployee();
                        break;
                    case 3:
                        viewSalesRevenue();
                        break;
                    case 4:
                        removeProduct();
                        break;
                    case 5:
                        // Exit the loop
                        keepRunning = false;
                        System.out.println("Exiting the Sales Head Operations.");
                        Log_In log=new Log_In();
                        log.login();
                        break;
                    default:
                        System.out.println("Invalid option! Please try again.");

                }


    }}





        @Override
        public void updateSalesEmployee () {
        int op;

        System.out.println("Enter the User ID to update: ");
        int id= input.nextInt();
        System.out.println("Choose one to Update: 1.Username 2.Pass ");
        op= input.nextInt();
        UpdateUsers updateUsers=new UpdateUsers();
        while (op!=-1) {
            switch (op) {
                case 1:
                    System.out.println("Enter the new Username: ");
                    String name = input.next();
                    updateUsers.updateUsername(id, name);
                    break;
                case 2:
                    System.out.println("Enter the new Password: ");
                    String pass = input.next();
                    updateUsers.updatePassword(id, pass);
                    break;

                default:
                    System.out.println("Inavlid Try Again!");
                    updateSalesEmployee();

            }
            System.out.println("Update: 1.Username 2.Pass  -1.To Exit");
            op= input.nextInt();
        }
        directory();

    }

        @Override
        public void viewSalesRevenue () {
            Revenue revenue = new Revenue();
            revenue.viewSale();
        }

        @Override
        public void removeProduct () {
            viewProducts remP = new viewProducts();
            remP.viewProductsSale();
            System.out.println("Enter the Product ID that you wanna remove: ");
            int id_product = input.nextInt();
            RemoveProducts removeProducts = new RemoveProducts();
            removeProducts.RemoveP(id_product, super.id);

        }


    @Override
    public void viewEmployeeInfo (String department){
        String query = "SELECT user_id, username, role, department FROM users WHERE department = ?";

        try {
            PreparedStatement stmt = myJDBC.connection.prepareStatement(query);
            stmt.setString(1, "Sales");  // Set the department to 'Warehouse'

            ResultSet resultSet = stmt.executeQuery();

            System.out.println("Employees in Department: Sales");
            System.out.println("---------------------------------------------");
            System.out.printf("%-10s %-20s %-15s %-15s%n", "User ID", "Username", "Role", "Department");

            while (resultSet.next()) {
                int userId = resultSet.getInt("user_id");
                String username = resultSet.getString("username");
                String role = resultSet.getString("role");
                String dept = resultSet.getString("department");

                System.out.printf("%-10d %-20s %-15s %-15s%n", userId, username, role, dept);
            }

            System.out.println("---------------------------------------------");

        } catch (SQLException e) {
            System.err.println("Error retrieving employees: " + e.getMessage());
        }

    }
    }

