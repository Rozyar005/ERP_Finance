package Finance;
import java.sql.*;
import java.sql.SQLException;
import Database.myJDBC;

public class Expenses extends management{

    @Override
    public void view(){

                String query = "SELECT * FROM expenses";

                try {
                    // Execute the query
                    ResultSet resultSet = myJDBC.executePreparedQuery(query);

                    // Display the results
                    System.out.println("Expenses Table Data:");
                    System.out.println("-----------------------------------------------------------");
                    System.out.printf("%-10s %-20s %-15s %-15s%n", "Expense ID", "Description", "Amount", "Date");

                    while (resultSet.next()) {
                        int expenseId = resultSet.getInt("expense_id");
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
        String query = "SELECT SUM(amount) AS total_expenses FROM expenses";

        try {
            // Execute the query
            ResultSet resultSet = myJDBC.executePreparedQuery(query);

            // Check if there's a result and display the total
            if (resultSet.next()) {
                double totalExpenses = resultSet.getDouble("total_expenses");
                super.Total_E=totalExpenses;
                System.out.println("Total Expenses: $" + totalExpenses);
            } else {
                System.out.println("No expenses data found.");
            }

        } catch (SQLException e) {
            System.err.println("Error calculating total expenses: " + e.getMessage());
        }
    }

}
