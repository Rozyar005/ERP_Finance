package Finance;
import java.sql.*;
import java.sql.SQLException;
import Database.myJDBC;

public class Revenue extends management{


    @Override
    public void view() {
        String query = "SELECT * FROM Revenue";

        try {
            // Execute the query
            ResultSet resultSet = myJDBC.executePreparedQuery(query);

            // Display the results
            System.out.println("Revenue Table Data:");
            System.out.println("-----------------------------------------------------------");
            System.out.printf("%-10s %-20s %-15s %-15s%n", "Revenue ID", "Description", "Amount", "Date");

            while (resultSet.next()) {
                int expenseId = resultSet.getInt("Revenue_id");
                String description = resultSet.getString("description");
                double amount = resultSet.getDouble("amount");
                String date = resultSet.getString("date");

                // Display each row of the result
                System.out.printf("%-10d %-20s %-15.2f %-15s%n", expenseId, description, amount, date);
            }

            System.out.println("-----------------------------------------------------------");

        } catch (SQLException e) {
            System.err.println("Error retrieving expenses: " + e.getMessage());
        }

}

    @Override
    public void cal() {
        String query = "SELECT SUM(amount) AS total_Revenue FROM Revenue"; // SQL query to calculate total Revenue

        try {
            // Execute the query
            ResultSet resultSet = myJDBC.executePreparedQuery(query);

            // Check if there's a result and display the total
            if (resultSet.next()) {
                double totalRevenue = resultSet.getDouble("Total_Revenue");
                super.Total_R=totalRevenue;
                System.out.println("Total Revenue: $" + totalRevenue);
            } else {
                System.out.println("No Revenue data found.");
            }

        } catch (SQLException e) {
            System.err.println("Error calculating total expenses: " + e.getMessage());
        }
    }

}
