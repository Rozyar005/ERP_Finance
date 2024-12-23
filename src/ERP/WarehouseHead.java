package ERP;
import Finance.Expenses;
import Permission.WarehouseHeadPermissions;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import Database.myJDBC;
import Products.AddProducts;
import Products.viewProducts;
import User_Operations.UpdateUsers;

public class WarehouseHead extends Users implements WarehouseHeadPermissions {
    Scanner input = new Scanner(System.in);

    public WarehouseHead() {
    }

    public WarehouseHead(int id, String username, String role, String department) {
        super(id, username, role, department);
    }

    @Override
    public void directory() {
        boolean keepRunning = true;
        while (keepRunning) {
            System.out.println("Welcome Head of Warehouse ! (Choose one of the Operations: 1.View Warehouse Employee 2.Update Users 3.View Expenses 4.Add Products 5.exit)");
            int op = input.nextInt();
                switch (op) {
                    case 1:
                        this.viewEmployeeInfo("Warehouse");
                        break;
                    case 2:
                        updateWarehouseEmployee();
                        break;
                    case 3:
                        viewWarehouseExpenses();
                        break;
                    case 4:
                        addProduct();
                        break;
                    case 5:
                        keepRunning = false;
                        System.out.println("Exiting the Warehouse Head .");
                        Log_In log = new Log_In();
                        log.login();
                        break;
                    default:
                        System.out.println("Invalid option! Please try again.");

                }

        }}


            @Override
            public void updateWarehouseEmployee () {
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
                            updateWarehouseEmployee();

                    }
                    System.out.println("Update: 1.Username 2.Pass 3.Role 4.Department -1.To Exit");
                    op= input.nextInt();
                }
                directory();

            }
            @Override
            public void viewWarehouseExpenses () {
                Expenses expenses = new Expenses();
                expenses.viewWarehouse();

            }

            @Override
            public void addProduct () {
                viewProducts viewproducts=new viewProducts();
                viewproducts.viewProductsWarehouse();
                AddProducts addProducts=new AddProducts(super.id);


            }

            @Override
            public void viewEmployeeInfo (String department){
                String query = "SELECT user_id, username, role, department FROM users WHERE department = ?";

                try {
                    PreparedStatement stmt = myJDBC.connection.prepareStatement(query);
                    stmt.setString(1, "Warehouse");  // Set the department to 'Warehouse'

                    ResultSet resultSet = stmt.executeQuery();

                    System.out.println("Employees in Department: Warehouse");
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