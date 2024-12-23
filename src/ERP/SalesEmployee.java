package ERP;
import Permission.SalesWorkerPermissions;
import Products.RemoveProducts;
import Products.viewProducts;

import java.util.Scanner;

public class SalesEmployee extends Users implements SalesWorkerPermissions{
    Scanner input=new Scanner(System.in);
    public SalesEmployee() {
    }

    public SalesEmployee(int id, String username, String role, String department) {
        super(id, username, role, department);
    }

    @Override
    public void directory() {
        boolean keepRunning = true;  // Flag to keep the loop running
        while (keepRunning) {
            System.out.println("Welcome Employee of Sales ! (Choose one of the Operations: 1.Sale a Product -1.Exit)");
            int op = input.nextInt();

            switch (op){
                case 1:
                    removeProduct();
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


        }
    }

    @Override
    public void removeProduct() {
        viewProducts remP=new viewProducts();
        remP.viewProductsSale();
        System.out.println("Enter the Product ID that you wanna remove: ");
        int id_product=input.nextInt();
        RemoveProducts removeProducts=new RemoveProducts();
        removeProducts.RemoveP(id_product ,super.id);
    }

}
