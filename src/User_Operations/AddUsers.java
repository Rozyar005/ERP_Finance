package User_Operations;
import Database.myJDBC;
import java.sql.SQLException;

public class AddUsers {

    public AddUsers(String username, String pass , String role , String dept) {
        myJDBC jdbc = new myJDBC();
        String query = "INSERT INTO users (username, password, role, department) VALUES (?, ?, ?, ?)";

        int rowsAffected = myJDBC.executePreparedUpdate(query, username, pass, role, dept);
        if (rowsAffected > 0) {
            System.out.println("User added successfully!");


        } else {
            System.out.println("Failed to add user.");
        }
    }
}
