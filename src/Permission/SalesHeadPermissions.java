package Permission;

public interface SalesHeadPermissions extends GeneralPermission{
    void updateSalesEmployee();
    void viewSalesEmployee();
    void viewSalesRevenue();
    void removeProduct();
    void viewProductsTransaction();


}
