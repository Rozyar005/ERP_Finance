package Permission;

public interface WarehouseHeadPermissions extends GeneralPermission{
    void updateWarehouseEmployee();
    void viewWarehouseEmployee();
    void viewWarehouseExpenses();
    void addProduct();
    void viewProductsTransaction();
}
