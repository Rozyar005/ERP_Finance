package ERP;


public abstract class Users {
    public Users() {

    }

    protected int id;
    protected String username;
    protected String role;
    protected String department;

    public Users(int id, String username, String role, String department) {
        this.id = id;
        this.username = username;
        this.role = role;
        this.department = department;
    }

    public String getUsername() { return username; }

    public String getRole() { return role; }

    public String getDepartment() { return department; }

    public void directory(){}

    public void displayOperations(){}

    public void displayManagement(){}


}
