package User_Operations;

import Database.myJDBC;

public class RemoveUsers {

    public RemoveUsers(String user_id , String pass) {
        myJDBC jdbc = new myJDBC();
        String query = "DELETE FROM users WHERE user_id = ? AND password = ?";

        int rowsAffected = myJDBC.executePreparedUpdate(query, user_id, pass);
        if (rowsAffected > 0) {
            System.out.println("User removed successfully!");
        } else {
            System.out.println("Failed to remove user. User not found.");
        }
    }
}
