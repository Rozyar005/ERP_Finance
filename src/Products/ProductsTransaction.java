package Products;

import Database.myJDBC;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductsTransaction {


    public ProductsTransaction(int product_id, String producut_name , int quantity, String transaction_type,double price, String department, int employee_id) {
        myJDBC jdbc = new myJDBC();

        String query = "INSERT INTO product_transactions (product_id, transaction_type, quantity, price, department, employee_id, status) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";

        int rowsAffected = jdbc.executePreparedUpdate(query, product_id, transaction_type, quantity, price, department, employee_id, "Completed");

        if (rowsAffected > 0) {
            System.out.println("Product transaction added successfully!");
        } else {
            System.out.println("Failed to add product transaction.");
        }
    }

    public ProductsTransaction() {
    }

    public void viewProductsTransaction(){
        myJDBC jdbc = new myJDBC();
        String query = "SELECT * FROM product_transactions";

        try {
            // Execute the query
            ResultSet resultSet = jdbc.executePreparedQuery(query);

            // Display the result
            System.out.println("Product Transactions:");
            System.out.println("------------------------------------------------------");

            while (resultSet.next()) {
                int transactionId = resultSet.getInt("transaction_id");
                int productId = resultSet.getInt("product_id");
                String transactionType = resultSet.getString("transaction_type");
                int quantity = resultSet.getInt("quantity");
                double price = resultSet.getDouble("price");
                String department = resultSet.getString("department");
                int employeeId = resultSet.getInt("employee_id");
                String status = resultSet.getString("status");

                // Print transaction details
                System.out.printf("Transaction ID: %d, Product ID: %d, Type: %s, Quantity: %d, Price: %.2f, Department: %s, Employee ID: %d, Status: %s%n",
                        transactionId, productId, transactionType, quantity, price, department, employeeId, status);
            }

            System.out.println("------------------------------------------------------");

        } catch (SQLException e) {
            System.err.println("Error retrieving product transactions: " + e.getMessage());
        }
    }

    }


