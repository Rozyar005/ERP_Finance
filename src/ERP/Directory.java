package ERP;

public class Directory {

    public Directory(String username,String Role) {

        if (Role.equalsIgnoreCase("CEO")) {
            System.out.println("Login successful! Welcome " + username);
            System.out.println("Role: " + Role);
            CEO ceo=new CEO();
            ceo.directory();
        }
        else if (Role.equalsIgnoreCase("HD Sale")){
            System.out.println("Login successful! Welcome " + username);
            System.out.println("Role: " + Role);
            SalesHead salesHead=new SalesHead();
            salesHead.directory();
        }
        else if (Role.equalsIgnoreCase("HD Warehouse")){
            System.out.println("Login successful! Welcome " + username);
            System.out.println("Role: " + Role);
            WarehouseHead warehouseHead=new WarehouseHead();
            warehouseHead.directory();
        }
        else if(Role.equalsIgnoreCase("Employee Sale")){
            System.out.println("Login successful! Welcome " + username);
            System.out.println("Role: " + Role);
            SalesEmployee salesEmployee=new SalesEmployee();
            salesEmployee.directory();
        }
        else if (Role.equalsIgnoreCase("Employee Warehouse")){
            System.out.println("Login successful! Welcome " + username);
            System.out.println("Role: " + Role);
            WarehouseEmployee warehouseEmployee=new WarehouseEmployee();
            warehouseEmployee.directory();
        }

    }
}
