package ERP;
import Permission.SalesHeadPermissions;

public class SalesHead extends Users implements SalesHeadPermissions{
    public SalesHead() {
    }

    public SalesHead(int id, String username, String role, String department, String password) {
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
    public void updateSalesEmployee() {

    }

    @Override
    public void viewSalesEmployee() {

    }

    @Override
    public void viewSalesRevenue() {

    }

    @Override
    public void removeProduct() {

    }

    @Override
    public void viewProductsTransaction() {

    }



    @Override
    public void viewEmployeeInfo(String  department) {

    }
}
