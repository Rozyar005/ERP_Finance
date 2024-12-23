package Products;

import Database.myJDBC;
import java.sql.*;
import java.sql.PreparedStatement;
import java.util.Scanner;
public class RemoveProducts extends viewProducts {

    @Override
    public void viewAllProduct() {
        super.viewAllProduct(); // Call to view all products before removing one
    }

    public RemoveProducts() {
    }

    public void RemoveP(int product_id, int userId) {
        Scanner input = new Scanner(System.in);
        int quantity;
        String productName = "";
        double amount = 0.0;
        String department = "";
        int availableQuantity = 0;

        String selectQuery = "SELECT product_name, product_quantity, amount, department FROM products WHERE product_id = ?";

        try {
            myJDBC.connection.setAutoCommit(false);

            PreparedStatement selectStmt = myJDBC.connection.prepareStatement(selectQuery);
            selectStmt.setInt(1, product_id);
            ResultSet resultSet = selectStmt.executeQuery();

            if (resultSet.next()) {
                productName = resultSet.getString("product_name");
                amount = resultSet.getDouble("amount");
                availableQuantity = resultSet.getInt("product_quantity");
                department = resultSet.getString("department");
                System.out.println("Enter the quantity you want to remove: ");
                quantity = input.nextInt();

                while (quantity > availableQuantity) {
                    System.out.println("Enter a valid quantity: ");
                    quantity = input.nextInt();
                }

                if (quantity <= availableQuantity) {
                    int updatedQuantity = availableQuantity - quantity;
                    String updateQuery = "UPDATE products SET product_quantity = ? WHERE product_id = ?";
                    int rowsAffected = myJDBC.executePreparedUpdate(updateQuery, updatedQuantity, product_id);

                    if (rowsAffected > 0) {
                        double totalAmount = amount * quantity;
                        java.sql.Date currentDate = new java.sql.Date(System.currentTimeMillis());
                        String expenseQuery = "INSERT INTO revenue (user_id, amount, department, date) VALUES (?, ?, ?, ?)";
                        PreparedStatement expenseStatement = myJDBC.connection.prepareStatement(expenseQuery);
                        expenseStatement.setInt(1, userId); // Set user_id
                        expenseStatement.setDouble(2, totalAmount);  // Set dept_id (Warehouse)
                        expenseStatement.setString(3, department); // Set the amount (price of the product)
                        expenseStatement.setDate(4, currentDate); // Set the current date

                        int revenueRowsAffected = expenseStatement.executeUpdate();
                        if (revenueRowsAffected > 0) {
                            System.out.println("Expense record added successfully!");

                        } else {
                            System.out.println("Failed to add expense record.");
                        }
                    }
                }

            } else {
                System.out.println("Product ID not found.");
            }
        }
                catch (SQLException e) {
                e.printStackTrace();
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
