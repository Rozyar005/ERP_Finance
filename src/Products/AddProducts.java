package Products;

import Database.myJDBC;
import java.util.Scanner;
import java.sql.*;
import java.sql.PreparedStatement;

public class AddProducts extends viewProducts {

    @Override
    public void viewAllProduct() {
        super.viewAllProduct();
    }

    public AddProducts() {
    }

    public AddProducts(int user_id) {
        int productID=0;
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the product name: ");
        String productName = input.nextLine();

        System.out.println("Enter the product quantity: ");
        int productQuantity = input.nextInt();
        input.nextLine();

        System.out.println("Enter the cost of the Product: ");
        double amount = input.nextDouble();

        String department = "Warehouse";
        String status = "Purchased ";

        String query = "INSERT INTO products (product_name, product_quantity, amount, department, status) VALUES (?, ?, ?, ?, ?)";

        try {
            PreparedStatement preparedStatement = myJDBC.connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, productName);
            preparedStatement.setInt(2, productQuantity);
            preparedStatement.setDouble(3, amount);
            preparedStatement.setString(4, department);
            preparedStatement.setString(5, status);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                java.sql.Date currentDate = new java.sql.Date(System.currentTimeMillis());

                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    productID = generatedKeys.getInt(1);  // Get the generated product_id first column
                    System.out.println("Product added successfully! Product ID: " + productID);
                    String expenseQuery = "INSERT INTO expenses (user_id, department, amount, date) VALUES (?, ?, ?, ?)";

                    PreparedStatement expenseStatement = myJDBC.connection.prepareStatement(expenseQuery);
                    expenseStatement.setInt(1, user_id);
                    expenseStatement.setString(2,department);// Set user_id
                    expenseStatement.setDouble(3, amount); // Set the amount (price of the product)
                    expenseStatement.setDate(4, currentDate); // Set the current date

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


    }

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
