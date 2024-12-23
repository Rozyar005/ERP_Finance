package ERP;
import Permission.WarehouseWorkerPermissions;
import Products.AddProducts;
import Products.viewProducts;

import java.util.Scanner;
public class WarehouseEmployee extends Users implements WarehouseWorkerPermissions{
        Scanner input=new Scanner(System.in);
    public WarehouseEmployee() {
    }

    public WarehouseEmployee(int id, String username, String role, String department) {
        super(id, username, role, department);
    }


    @Override
    public void directory() {
        boolean keepRunning = true;
        while (keepRunning) {
            System.out.println("Welcome Employee of Warehouse ! (Choose one of the Operations: 1.Add a Product -1.Exit)");
            int op = input.nextInt();

            switch (op){
                case 1:
                    addProduct();
                    break;
                case -1:
                    keepRunning = false;
                    System.out.println("Exiting the Sales Head Operations.");
                    Log_In log=new Log_In();
                    log.login();
                    break;
                default:
                    System.out.println("Invalid option! Please try again.");

            }


        } }

    @Override
    public void addProduct() {
        viewProducts viewproducts=new viewProducts();
        viewproducts.viewProductsWarehouse();
        AddProducts addProducts=new AddProducts(super.id);


    }

}
