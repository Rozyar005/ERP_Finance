package Products;
import Database.myJDBC;
import java.sql.ResultSet;
import java.sql.SQLException;

public class viewProducts {

    public void viewAllProduct(){
        String query = "SELECT * FROM products"; // SQL query to select all products

        try {
            // Execute the query
            ResultSet resultSet = myJDBC.executePreparedQuery(query);

            // Check if there are results
            if (resultSet.next()) {
                // Loop through all rows and display product details
                do {
                    int productId = resultSet.getInt("product_id");
                    String productName = resultSet.getString("product_name");
                    int productQuantity = resultSet.getInt("product_quantity");
                    String department = resultSet.getString("department");
                    String status = resultSet.getString("status");

                    System.out.println("Product ID: " + productId);
                    System.out.println("Product Name: " + productName);
                    System.out.println("Quantity: " + productQuantity);
                    System.out.println("Department: " + department);
                    System.out.println("Status: " + status);
                    System.out.println("------------------------------------");

                } while (resultSet.next()); // Continue fetching the next row
            } else {
                System.out.println("No products found.");
            }

        } catch (SQLException e) {
            System.err.println("Error fetching product details: " + e.getMessage());
        }
    }

    public viewProducts() {}


}


