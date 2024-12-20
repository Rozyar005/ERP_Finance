package ERP;
import Permission.WarehouseWorkerPermissions;
public class WarehouseEmployee extends Users implements WarehouseWorkerPermissions{
    public WarehouseEmployee() {
    }

    public WarehouseEmployee(int id, String username, String role, String department, String password) {
        super(id, username, role, department, password);
    }

    @Override
    public void displayOperations() {
        super.displayOperations();
    }

    @Override
    public void directory() {
        super.directory();
    }

    @Override
    public void displayManagement() {
        super.displayManagement();
    }

    @Override
    public void addProduct() {

    }

}
