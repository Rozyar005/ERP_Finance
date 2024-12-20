package User_Operations;

import Database.myJDBC;

public class UpdateUsers {

    // Update the username for a specific user
    public void updateUsername(int user_id, String newUsername) {
        String query = "UPDATE users SET username = ? WHERE user_id = ?";
        int rowsAffected = myJDBC.executePreparedUpdate(query, newUsername, user_id);
        if (rowsAffected > 0) {
            System.out.println("Username updated successfully!");
        } else {
            System.out.println("Failed to update username. User ID may not exist.");
        }
    }

    // Update the password for a specific user
    public void updatePassword(int user_id, String newPassword) {
        String query = "UPDATE users SET password = ? WHERE user_id = ?";
        int rowsAffected = myJDBC.executePreparedUpdate(query, newPassword, user_id);
        if (rowsAffected > 0) {
            System.out.println("Password updated successfully!");
        } else {
            System.out.println("Failed to update password. User ID may not exist.");
        }
    }

    // Update the role for a specific user
    public void updateRole(int user_id, String newRole) {
        String query = "UPDATE users SET role = ? WHERE user_id = ?";
        int rowsAffected = myJDBC.executePreparedUpdate(query, newRole, user_id);
        if (rowsAffected > 0) {
            System.out.println("Role updated successfully!");
        } else {
            System.out.println("Failed to update role. User ID may not exist.");
        }
    }

    // Update the department for a specific user
    public void updateDepartment(int user_id, String newDepartment) {
        String query = "UPDATE users SET department = ? WHERE user_id = ?";
        int rowsAffected = myJDBC.executePreparedUpdate(query, newDepartment, user_id);
        if (rowsAffected > 0) {
            System.out.println("Department updated successfully!");
        } else {
            System.out.println("Failed to update department. User ID may not exist.");
        }
    }
}
