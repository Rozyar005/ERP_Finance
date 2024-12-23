package Products;
import Database.myJDBC;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class viewProducts {

    public viewProducts() {
    }

    public void viewAllProduct() {
        String query = "SELECT * FROM products"; // SQL query to select all products

        try {
            ResultSet resultSet = myJDBC.executePreparedQuery(query);
            System.out.println("Product Table Data:");
            System.out.println("-----------------------------------------------------------");
            System.out.printf("%-10s %-20s %-15s %-15s %-15s%n", "product_id", "product_name", "product_quantity", "Amount","department", "status", "Date");

            while (resultSet.next()) {
                int productId = resultSet.getInt("product_id");
                String productName = resultSet.getString("product_name");
                int productQuantity = resultSet.getInt("product_quantity");
                double amount = resultSet.getDouble("amount");
                String department = resultSet.getString("department");
                String status = resultSet.getString("status");
                Date date = resultSet.getDate("date_added");

                System.out.println("------------------------------------");
                System.out.println("Product Details:");
                System.out.printf("Product ID      : %d%n", productId);
                System.out.printf("Product Name    : %s%n", productName);
                System.out.printf("Quantity        : %d%n", productQuantity);
                System.out.printf("Amount          : %.2f%n", amount);
                System.out.printf("Department      : %s%n", department);
                System.out.printf("Status          : %s%n", status);
                System.out.printf("Date Added      : %s%n", date);
                System.out.println("------------------------------------");
            }

        }
         catch (SQLException e) {
            System.err.println("Error fetching product details: " + e.getMessage());
        }
    }

    public void viewProductsSale(){
        String query = "SELECT * FROM products WHERE department = 'Sales'"; // SQL query to select all products in the Sale department

        try {
            ResultSet resultSet = myJDBC.executePreparedQuery(query);

            System.out.println("Sale Products Data:");
            System.out.println("-----------------------------------------------------------");
            System.out.printf("%-10s %-20s %-15s %-15s %-15s%n", "product_id", "product_name", "product_quantity", "Amount", "department");

            while (resultSet.next()) {
                int productId = resultSet.getInt("product_id");
                String productName = resultSet.getString("product_name");
                int productQuantity = resultSet.getInt("product_quantity");
                double amount = resultSet.getDouble("amount");
                String department = resultSet.getString("department");

                System.out.printf("%-10d %-20s %-15d %-15.2f %-15s%n",
                        productId, productName, productQuantity, amount, department);
            }

        } catch (SQLException e) {
            System.err.println("Error fetching product details: " + e.getMessage());
        }

    }

    public void viewProductsWarehouse(){
        String query = "SELECT * FROM products WHERE department = 'Warehouse'"; // SQL query to select all products in the Sale department

        try {
            ResultSet resultSet = myJDBC.executePreparedQuery(query);

            System.out.println("Warehouse Products Data:");
            System.out.println("-----------------------------------------------------------");
            System.out.printf("%-10s %-20s %-15s %-15s %-15s%n", "product_id", "product_name", "product_quantity", "Amount", "department");

            while (resultSet.next()) {
                int productId = resultSet.getInt("product_id");
                String productName = resultSet.getString("product_name");
                int productQuantity = resultSet.getInt("product_quantity");
                double amount = resultSet.getDouble("amount");
                String department = resultSet.getString("department");

                System.out.printf("%-10d %-20s %-15d %-15.2f %-15s%n",
                        productId, productName, productQuantity, amount, department);
            }

        } catch (SQLException e) {
            System.err.println("Error fetching product details: " + e.getMessage());
        }
    }


}


