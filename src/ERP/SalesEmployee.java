package ERP;
import Permission.SalesWorkerPermissions;
import Products.RemoveProducts;
import Products.viewProducts;

import java.util.Scanner;

public class SalesEmployee extends Users implements SalesWorkerPermissions{
    Scanner input;
    public SalesEmployee() {
    }

    public SalesEmployee(int id, String username, String role, String department, String password) {
        super(id, username, role, department, password);
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
    public void directory() {
        super.directory();
    }

    @Override
    public void removeProduct() {
        viewProducts remP=new RemoveProducts();
        remP.viewAllProduct();
        System.out.println("Enter the Product ID that you wanna remove: ");
        int id_product=input.nextInt();
        RemoveProducts removeProducts=new RemoveProducts();
        removeProducts.RemoveP(id_product , super.id);

    }

}
