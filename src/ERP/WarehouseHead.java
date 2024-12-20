package ERP;
import Permission.WarehouseHeadPermissions;

public class WarehouseHead extends Users implements WarehouseHeadPermissions{
    public WarehouseHead() {
    }

    public WarehouseHead(int id, String username, String role, String department, String password) {
        super(id, username, role, department, password);
    }

    @Override
    public void directory() {
        super.directory();
    }

    @Override
    public void displayOperations() {
        super.displayOperations();
    }

    @Override
    public void displayManagement() {
        super.displayManagement();
    }


    @Override
    public void updateWarehouseEmployee() {

    }

    @Override
    public void viewWarehouseEmployee() {

    }

    @Override
    public void viewWarehouseExpenses() {

    }

    @Override
    public void addProduct() {

    }

    @Override
    public void viewProductsTransaction() {

    }

    @Override
    public void viewEmployeeInfo(String department) {

    }
}
