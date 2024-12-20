package Products;

import Database.myJDBC;
import java.util.Scanner;
import java.sql.*;

public class AddProducts extends viewProducts {

    @Override
    public void viewAllProduct() {
        super.viewAllProduct();
    }

    public AddProducts() {
    }

    public AddProducts(int user_id) {
        int productID=0;
        // Scanner for user input
        Scanner input = new Scanner(System.in);

        // Ask user to enter product details
        System.out.println("Enter the product name: ");
        String productName = input.nextLine();

        System.out.println("Enter the product quantity: ");
        int productQuantity = input.nextInt();
        input.nextLine(); // Consume the newline character left by nextInt()

        System.out.println("Enter the cost of the Product: ");
        double amount = input.nextDouble();
        String department = "Warehouse";
        String status = "Expenses";

        // SQL query to insert a new product into the products table
        String query = "INSERT INTO products (product_name, product_quantity, amount, department, status) VALUES (?, ?, ?, ?, ?)";

        try {
            // Create PreparedStatement with return generated keys
            PreparedStatement preparedStatement = myJDBC.connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            // Set the parameters for the query
            preparedStatement.setString(1, productName);
            preparedStatement.setInt(2, productQuantity);
            preparedStatement.setDouble(3, amount);
            preparedStatement.setString(4, department);
            preparedStatement.setString(5, status);

            // Execute the update (insert)
            int rowsAffected = preparedStatement.executeUpdate();

            // If insertion was successful, get the generated product ID
            if (rowsAffected > 0) {
                // Get the generated keys (product_id)
                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    productID = generatedKeys.getInt(1);  // Get the generated product_id first column
                    System.out.println("Product added successfully! Product ID: " + productID);
                    // After adding the product, now add it to the expenses table
                    // Expense details
                    String expenseQuery = "INSERT INTO expenses (user_id, dept_id, amount, date) VALUES (?, ?, ?, ?)";

                    // Get department ID (this might be mapped from a department string)
                    int deptId = getDeptId(department);  // You need to implement a method to get dept_id based on department name

                    // Set current date for the expense
                    java.sql.Date currentDate = new java.sql.Date(System.currentTimeMillis());

                    // Insert expense record
                    PreparedStatement expenseStatement = myJDBC.connection.prepareStatement(expenseQuery);
                    expenseStatement.setInt(1, user_id); // Set user_id
                    expenseStatement.setInt(2, deptId);  // Set dept_id (Warehouse)
                    expenseStatement.setDouble(3, amount); // Set the amount (price of the product)
                    expenseStatement.setDate(4, currentDate); // Set the current date

                    // Execute the expense insert query
                    int expenseRowsAffected = expenseStatement.executeUpdate();
                    if (expenseRowsAffected > 0) {
                        System.out.println("Expense record added successfully!");
                    } else {
                        System.out.println("Failed to add expense record.");
                    }
                } else {
                    System.out.println("Failed to retrieve the generated product ID.");
                }
            } else {
                System.out.println("Failed to add product.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("An error occurred while adding the product.");
        }

        ProductsTransaction productsTransaction=new ProductsTransaction(productID,productName,productQuantity,"Purchased",amount,department,user_id);

    }

    // Helper method to get dept_id from the department name
    private int getDeptId(String department) {
        int deptId = 0;
        try {
            String deptQuery = "SELECT dept_id FROM department WHERE department = ?";
            PreparedStatement preparedStatement = myJDBC.connection.prepareStatement(deptQuery);
            preparedStatement.setString(1, department);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                deptId = resultSet.getInt("dept_id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return deptId;
    }
    }
