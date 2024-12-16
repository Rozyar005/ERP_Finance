import java.sql.*;
import java.util.Scanner;


public class User_Operations {
Scanner input=new Scanner(System.in);
myJDBC jdbc=new myJDBC();
Connection conn;
Admin_Business adminBusiness=new Admin_Business();

    public void userAdd(){
        System.out.println("Name: ");
        String username = input.next();
        System.out.println("Password: ");
        String pass = input.next();
        System.out.println("Role: ");
        String role = input.next();
        System.out.println("Employee of Dept: 1. WareHousing  2. Finance  3. Sales");
        int deptOption = input.nextInt();

        String department = null;
        switch (deptOption) {
            case 1:
                department = "WareHousing";
                break;
            case 2:
                department = "Finance";
                break;
            case 3:
                department = "Sales";
                break;
            default:
                System.out.println("Invalid department option!");
                return;
        }


        try {
            conn = jdbc.connectionSQL();
            String query = "INSERT INTO users (username, password, role, department) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, pass);
            statement.setString(3, role);
            statement.setString(4, department);

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("New Employee Added successfully!");

            } else {
                System.out.println("Sign-up failed. Please try again.");
                userAdd();
            }
            adminBusiness.performFunctionality();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void userRemove(){
        int rem=input.nextInt();
        String dept = null;
        switch (rem){
            case 1:
                dept="Finanace";
                DisplayAll(dept);
                removePro(dept);
                break;
            case 2:
                dept="Warehousing";
                DisplayAll(dept);
                removePro(dept);

                break;
            case 3:
                dept="Sales";
                DisplayAll(dept);
                removePro(dept);
                break;

            default:
                System.out.println("Invalid Please Enter it Again");
                userRemove();

        }
    }
    public void removePro(String dept) {
        System.out.print("Enter the User ID of the employee to remove: ");
        int userIdToRemove = input.nextInt();

        String deleteQuery = "DELETE FROM users WHERE user_id = ?";
        try (PreparedStatement statment = conn.prepareStatement(deleteQuery)) {
            statment.setInt(1, userIdToRemove);

            int rowsAffected = statment.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Employee with User ID " + userIdToRemove + " has been removed successfully.");
            } else {
                System.out.println("No employee found with User ID " + userIdToRemove + ".");
            }

                adminBusiness.performFunctionality();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }



    public void userUpdate(){
        int up=input.nextInt();
        String dept = null;
        switch (up){
            case 1:
                dept="Finanace";
                DisplayAll(dept);
                updatePro(dept);
                break;
            case 2:
                dept="Warehousing";
                DisplayAll(dept);
                updatePro(dept);
                break;
            case 3:
                dept="Sales";
                DisplayAll(dept);
                updatePro(dept);
                break;
            default:
                System.out.println("Invalid Please Enter it Again");
                userUpdate();

        }

    }
    public void updatePro(String dept){
        Admin_Business adminBusiness=new Admin_Business();

        System.out.print("Enter the User ID of the employee to Update: ");
        int userIdToUpdate = input.nextInt();
        System.out.println("Select the field you want to update:");
        System.out.println("1. Username");
        System.out.println("2. Password");
        System.out.println("3. Role");
        System.out.println("4. Department");
        System.out.println("5. Budget");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
        int choice = input.nextInt();
        String query="";
        if(choice==0){
            adminBusiness.performFunctionality();
        }

        try {
            conn = jdbc.connectionSQL();

            switch (choice) {
                case 1:
                    System.out.print("Enter the new username: ");
                    String newUsername = input.nextLine();
                     query = "UPDATE users SET username = ? WHERE user_id = ?";
                    try (PreparedStatement statement = conn.prepareStatement(query)) {
                        statement.setString(1, newUsername);
                        statement.setInt(2, userIdToUpdate);
                        int rowsAffected = statement.executeUpdate();
                        if (rowsAffected > 0) {
                            System.out.println("Username updated successfully.");
                        } else {
                            System.out.println("No user found with the given User ID.");
                        }
                    }
                    userUpdate();
                    break;

                case 2:
                    System.out.print("Enter the new password: ");
                    String newPassword = input.nextLine();
                     query = "UPDATE users SET password = ? WHERE user_id = ?";
                    try (PreparedStatement statement = conn.prepareStatement(query)) {
                        statement.setString(1, newPassword);
                        statement.setInt(2, userIdToUpdate);
                        int rowsAffected = statement.executeUpdate();
                        if (rowsAffected > 0) {
                            System.out.println("Password updated successfully.");

                        } else {
                            System.out.println("No user found with the given User ID.");
                        }
                    }
                    userUpdate();
                    break;

                case 3:
                    System.out.print("Enter the new role: ");
                    String newRole = input.nextLine();
                    query = "UPDATE users SET role = ? WHERE user_id = ?";
                    try (PreparedStatement statement = conn.prepareStatement(query)) {
                        statement.setString(1, newRole);
                        statement.setInt(2, userIdToUpdate);
                        int rowsAffected = statement.executeUpdate();
                        if (rowsAffected > 0) {
                            System.out.println("Role updated successfully.");

                        } else {
                            System.out.println("No user found with the given User ID.");
                        }
                    }
                    userUpdate();
                    break;

                case 4:
                    System.out.print("Enter the new department: ");
                    String newDepartment = input.nextLine();
                    query = "UPDATE users SET department = ? WHERE user_id = ?";
                    try (PreparedStatement statement = conn.prepareStatement(query)) {
                        statement.setString(1, newDepartment);
                        statement.setInt(2, userIdToUpdate);
                        int rowsAffected = statement.executeUpdate();
                        if (rowsAffected > 0) {
                            System.out.println("Department updated successfully.");

                        } else {
                            System.out.println("No user found with the given User ID.");
                        }
                    }
                    userUpdate();
                    break;

                case 5:
                    System.out.print("Enter the new budget amount: ");
                    double newBudgetAmount = input.nextDouble();
                    query = "UPDATE Budget SET Amount = ? WHERE user_id = ?";
                    try (PreparedStatement statement = conn.prepareStatement(query)) {
                        statement.setDouble(1, newBudgetAmount);
                        statement.setInt(2, userIdToUpdate);
                        int rowsAffected = statement.executeUpdate();
                        if (rowsAffected > 0) {
                            System.out.println("Budget updated successfully.");
                        } else {
                            System.out.println("No budget record found for the given User ID.");
                        }
                    }
                    userUpdate();
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void DisplayAll(String dept){
        try {
            conn = jdbc.connectionSQL();
            String query = "SELECT user_id, username FROM users WHERE department = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            System.out.println("Employees in " + dept + " department:");
            System.out.printf("%-10s %-15s%n", "User ID", "Username");
            System.out.println("--------------------------------");
            boolean hasResults = false;
            //we need a loop here to get all the results
            while (resultSet.next()) {
                hasResults = true;
                int user_id = resultSet.getInt("user_id");
                String username = resultSet.getString("username");
                System.out.printf("%-10d %-15s%n", user_id, username);
            }

            if (!hasResults) {
                System.out.println("No employees found in this department.");
                return;
            }
            return;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}
