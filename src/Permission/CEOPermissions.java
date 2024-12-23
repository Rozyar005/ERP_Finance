package Permission;

public interface CEOPermissions  extends GeneralPermission {

        void addEmployee(String Dept);
        void removeEmployee(String Dept);
        void updateEmployee(String Dept);
        void viewExpenses();
        void viewRevenue();
        void viewProfit();
        void addProduct();
        void removeProduct();

}

