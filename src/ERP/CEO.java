package ERP;
import Permission.CEOPermissions;
import User_Operations.AddUsers;
import User_Operations.RemoveUsers;
import User_Operations.UpdateUsers;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import Database.myJDBC;
import Finance.Expenses;
import Finance.Revenue;
import Finance.Profits;
import Products.viewProducts;
import Products.AddProducts;
import Products.RemoveProducts;
import Products.ProductsTransaction;

public class CEO extends Users implements CEOPermissions{
    myJDBC myJDBC=new myJDBC();
    Scanner input=new Scanner(System.in);
    int d=0;
    int m=0;

    public CEO(int id, String username, String role, String department, String password) {
        super(id, username, role, department, password);
    }
    public CEO(){
        super();
    }

    public void directory(){
        boolean keepRunning = true;  // Flag to keep the loop running
        while (keepRunning) {
            System.out.println("Welcome CEO! (Choose one of the Operations: 1.user_operations 2.management 3.exit)");
            int op = input.nextInt();

            switch (op) {
                case 1:
                    // User operations
                    System.out.println("Choose one of the Dept: 1.Sales 2.Warehouse ");
                    d = input.nextInt();
                    displayOperations(d);
                    break;
                case 2:
                    // Management operations
                    System.out.println("Choose one of the management options: 1.Revenue 2.Expenses 3.Profits 4.Products ");
                    m = input.nextInt();
                    displayManagement(m);
                    break;
                case 3:
                    // Exit the loop
                    keepRunning = false;
                    System.out.println("Exiting the CEO Operations.");
                    break;
                default:
                    System.out.println("Invalid option! Please try again.");
            }
        }
    }
    public void displayOperations(int d){
        // Operations for employee management in different departments
        if (d == 1) {
            viewEmployeeInfo("Sales");
            System.out.println("Choose The Operations: 1.Add 2.Remove 3.Update");
            int op = input.nextInt();
            switch (op) {
                case 1:
                    addEmployee("Sales");
                    break;
                case 2:
                    removeEmployee("Sales");
                    break;
                case 3:
                    updateEmployee("Sales");
                    break;
                default:
                    System.out.println("Invalid option, returning to department selection.");
                    displayOperations(d);
                    break;
            }
        } else if (d == 2) {
            viewEmployeeInfo("Warehouse");
            System.out.println("Choose The Operations: 1.Add 2.Remove 3.Update");
            int op = input.nextInt();
            switch (op) {
                case 1:
                    addEmployee("Warehouse");
                    break;
                case 2:
                    removeEmployee("Warehouse");
                    break;
                case 3:
                    updateEmployee("Warehouse");
                    break;
                default:
                    System.out.println("Invalid option, returning to department selection.");
                    displayOperations(d);
                    break;
            }
        }
    }
    public void displayManagement(int m){
            // Operations for managing finances and products
            switch (m) {
                case 1:
                    viewRevenue();
                    break;
                case 2:
                    viewExpenses();
                    break;
                case 3:
                    viewProfit();
                    break;
                case 4:
                    System.out.println("Choose: 1.Add a Product 2. Remove a Product 3.Product Transactions ");
                    int p = input.nextInt();
                    switch (p) {
                        case 1:
                            addProduct();
                            break;
                        case 2:
                            removeProduct();
                            break;
                        case 3:
                            viewProductsTransaction();
                            break;
                        default:
                            System.out.println("Invalid option, returning to product management.");
                            displayManagement(m);
                            break;
                    }
                    break;
                default:
                    System.out.println("Invalid option, returning to management selection.");
                    displayManagement(m);
                    break;
            }
        }


    @Override
    public void viewEmployeeInfo(String department) {
        String query = "SELECT user_id, username, role, department FROM users WHERE department = ?";

        try {
            // Execute the prepared query with the department filter
            ResultSet resultSet = myJDBC.executePreparedQuery(query, department);

            // Display the results
            System.out.println("Employees in Department: " + department);
            System.out.println("---------------------------------------------");
            System.out.printf("%-10s %-20s %-15s %-15s%n", "User ID", "Username", "Role", "Department");

            while (resultSet.next()) {
                int userId = resultSet.getInt("user_id");
                String username = resultSet.getString("username");
                String role = resultSet.getString("role");
                String dept = resultSet.getString("department");

                // Display each row of the result
                System.out.printf("%-10d %-20s %-15s %-15s%n", userId, username, role, dept);
            }

            System.out.println("---------------------------------------------");

        } catch (SQLException e) {
            System.err.println("Error retrieving employees: " + e.getMessage());
        }
        return;
    }


    @Override
    public void addEmployee(String Dept) {
        System.out.print("Enter The Username: ");
        String name= input.next();
        System.out.print("Enter The Pass: ");
        String pass= input.next();
        System.out.print("Enter The Role: ");
        String role=input.next();
        AddUsers addUsers=new AddUsers(name,pass,role,Dept);

    }

    @Override
    public void removeEmployee(String Dept) {
        System.out.print("Enter The UserID: ");
        String id= input.next();
        System.out.print("Enter The Pass: ");
        String pass= input.next();
        RemoveUsers removeUsers=new RemoveUsers(id,pass);

    }

    @Override
    public void updateEmployee(String Dept) {
        System.out.println("Enter the User ID to update: ");
        int id= input.nextInt();
        System.out.println("Choose one to Update: 1.Username 2.Pass 3.Role 4.Department");
        int op= input.nextInt();
        UpdateUsers updateUsers=new UpdateUsers();
        switch (op){
            case 1:
                System.out.println("Enter the new Username: ");
                String name=input.next();
                updateUsers.updateUsername(id,name);
                break;
            case 2:
                System.out.println("Enter the new Password: ");
                String pass=input.next();
                updateUsers.updatePassword(id,pass);
                break;

            case 3:
                System.out.println("Enter the new Role: ");
                String role=input.next();
                updateUsers.updateRole(id,role);
                break;
            case 4:
                System.out.println("Enter the new Department: ");
                String dept=input.next();
                updateUsers.updateDepartment(id,dept);
                break;
            default:
                System.out.println("Inavlid Try Again!");
                updateEmployee(Dept);

        }

    }

    @Override
    public void viewExpenses() {
        Expenses ex=new Expenses();
        ex.cal();
        ex.view();
    }

    @Override
    public void viewRevenue() {
        Revenue re=new Revenue();
        re.cal();
        re.view();

    }

    @Override
    public void viewProfit() {
        Profits pr=new Profits();
        pr.cal();
        pr.view();

    }

    @Override
    public void addProduct() {
        viewProducts addP=new AddProducts();
        addP.viewAllProduct();
        //The ID here is the user ID to put into the Transaction Table.
        AddProducts addProducts=new AddProducts(super.id);

    }

    @Override
    public void removeProduct() {
        viewProducts remP=new RemoveProducts();
        remP.viewAllProduct();
        System.out.println("Enter the Product ID that you wanna remove: ");
        int id_product=input.nextInt();
        RemoveProducts removeProducts=new RemoveProducts();
        removeProducts.RemoveP(id_product , super.id);
    }

    @Override
    public void viewProductsTransaction() {
        ProductsTransaction productsTransaction=new ProductsTransaction();
        productsTransaction.viewProductsTransaction();

    }





}



