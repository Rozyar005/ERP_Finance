package ERP;


public abstract class Users {
    public Users() {

    }

    protected int id;
    protected String username;
    protected String password;
    protected String role;
    protected String department;

    public Users(int id, String username, String role, String department, String password) {
        this.id = id;
        this.username = username;
        this.role = role;
        this.department = department;
        this.password = password;
    }

    public String getUsername() { return username; }

    public String getPassword() { return password; }

    public String getRole() { return role; }

    public String getDepartment() { return department; }

    public void displayOperations(){}

    public void directory(){}

    public void displayManagement(){}


}
