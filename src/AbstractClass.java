import java.sql.*;
import java.util.Scanner;


    public abstract class AbstractClass implements Users{
    myJDBC jdbc = new myJDBC();
    Connection conn;
    Scanner input = new Scanner(System.in);

    protected String id;
    protected String username;
    protected String password;
    protected String role;
    protected String department;

    public AbstractClass(String id, String username, String password, String role, String department) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
        this.department = department;
    }
    public AbstractClass(){

    }
    @Override
    public String getUsername() { return username; }

    @Override
    public String getPassword() { return password; }

    @Override
    public String getRole() { return role; }

    @Override
    public String getDepartment() { return department; }

    public abstract void performFunctionality();
    }