package Products;

import Database.myJDBC;
import java.sql.*;
import java.sql.PreparedStatement;

public class RemoveProducts extends viewProducts {

    @Override
    public void viewAllProduct() {
        super.viewAllProduct(); // Call to view all products before removing one
    }

    public RemoveProducts() {
    }

    public void RemoveP(int product_id, int userId) {

        // Variables for product data
        String productName = "";
        double productAmount = 0.0;
        String department = "";

        // Prepare SQL query to get the product details before deletion
        String selectQuery = "SELECT product_name, amount, department FROM products WHERE product_id = ?";

        try {
            // Prepare and execute the select query
            PreparedStatement selectStmt = myJDBC.connection.prepareStatement(selectQuery);
            selectStmt.setInt(1, product_id);
            ResultSet resultSet = selectStmt.executeQuery();

            // If product exists, get the product details
            if (resultSet.next()) {
                productName = resultSet.getString("product_name");
                productAmount = resultSet.getDouble("amount");
                department = resultSet.getString("department");
            }

            // Now, remove the product from the database
            String deleteQuery = "DELETE FROM products WHERE product_id = ?";
            int rowsAffected = myJDBC.executePreparedUpdate(deleteQuery, product_id);

            // Display success or failure message based on rows affected
            if (rowsAffected > 0) {
                System.out.println("Product removed successfully!");

                // Get the department ID based on the product's department
                int deptId = getDeptId(department);

                // Insert the transaction into the revenue table
                String insertRevenueQuery = "INSERT INTO revenue (user_id, amount, dept_id, date) VALUES (?, ?, ?, NOW())";

                // Insert into revenue table
                int revenueRowsAffected = myJDBC.executePreparedUpdate(insertRevenueQuery, userId, productAmount, deptId);

                if (revenueRowsAffected > 0) {
                    System.out.println("Revenue recorded successfully!");
                } else {
                    System.out.println("Failed to record revenue.");
                }

            } else {
                System.out.println("Failed to remove product. Product ID not found.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("An error occurred while removing the product or recording the revenue.");
        }
//transactiony mawa
    }

    // Method to get the department ID based on the department associated with the product
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
