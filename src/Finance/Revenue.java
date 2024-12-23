package Finance;
import java.sql.*;
import java.sql.SQLException;
import Database.myJDBC;

public class Revenue extends management{

    @Override
    public void cal() {
        String query = "SELECT SUM(amount) AS total_revenue FROM revenue";

        try {
            // Execute the query
            ResultSet resultSet = myJDBC.executePreparedQuery(query);

            // Check if there's a result and display the total
            if (resultSet.next()) {
                double totalRevenue = resultSet.getDouble("total_revenue");
                super.Total_R= totalRevenue;
                System.out.println("Total Revenue: $" + totalRevenue);
            } else {
                System.out.println("No expenses data found.");
            }

        } catch (SQLException e) {
            System.err.println("Error calculating total Revenue: " + e.getMessage());
        }
    }

    @Override
    public void view() {
        String query = "SELECT * FROM revenue";

        try {
            // Execute the query
            ResultSet resultSet = myJDBC.executePreparedQuery(query);
            // Display the header for the results
            System.out.println("Revenue Table Data:");
            System.out.println("-----------------------------------------------------------");
            System.out.printf("%-10s %-20s %-15s %-15s %-15s%n", "IncomeID", "UserID", "Department", "Amount", "Date");

            // Loop through the result set and display the rows
            while (resultSet.next()) {
                int incomeId = resultSet.getInt("income_id");
                int userId = resultSet.getInt("user_id"); // Changed to `int` to match ID type
                String department = resultSet.getString("department");
                double amount = resultSet.getDouble("amount");
                Date date = resultSet.getDate("date");
                // Display each row of the result
                System.out.printf("%-10d %-20d %-15s %-15.2f %-15s%n", incomeId, userId, department, amount, date);
            }

            System.out.println("-----------------------------------------------------------");

        } catch (SQLException e) {
            System.err.println("Error calculating total Revenue: " + e.getMessage());
        }
    }

    public void viewSale(){
        String query = "SELECT * FROM revenue WHERE department='sale'";

        try {
            ResultSet resultSet = myJDBC.executePreparedQuery(query);

            System.out.println("Expenses Table Data:");
            System.out.println("-----------------------------------------------------------");
            System.out.printf("%-10s %-20s %-15s %-15s %-15s%n", "ExpenseID", "UserID", "Department", "Amount", "Date");

            while (resultSet.next()) {
                int expenseId = resultSet.getInt("expense_id");
                int userId = resultSet.getInt("user_id"); // Changed to `int` to match ID type
                String department = resultSet.getString("department");
                double amount = resultSet.getDouble("amount");
                Date date = resultSet.getDate("date");
                System.out.printf("%-10d %-20d %-15s %-15.2f %-15s%n", expenseId, userId, department, amount, date);
            }

            System.out.println("-----------------------------------------------------------");

        } catch (SQLException e) {
            System.err.println("Error retrieving expenses: " + e.getMessage());
        }

    }


    }

