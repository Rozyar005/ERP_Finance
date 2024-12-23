package ERP;

public class Directory {

    public Directory(String Role , int userID , String Dept ,String username) {

        if (Role.equalsIgnoreCase("CEO")) {
            System.out.println("Login successful! Welcome " );
            System.out.println("Role: " + Role);
            CEO c=new CEO(userID,username,Role , Dept);
            CEO ceo=new CEO();
            ceo.directory();
        }
        else if (Role.equalsIgnoreCase("HD Sale")){
            System.out.println("Login successful! Welcome " );
            System.out.println("Role: " + Role);
            SalesHead s=new SalesHead(userID,username,Role , Dept);
            SalesHead salesHead=new SalesHead();
            salesHead.directory();
        }
        else if (Role.equalsIgnoreCase("HD Warehouse")){
            System.out.println("Login successful! Welcome " );
            System.out.println("Role: " + Role);
            WarehouseHead w=new WarehouseHead(userID,username,Role , Dept);
            WarehouseHead warehouseHead=new WarehouseHead();
            warehouseHead.directory();
        }
        else if(Role.equalsIgnoreCase("Employee Sale")){
            System.out.println("Login successful! Welcome " );
            System.out.println("Role: " + Role);
            SalesEmployee se=new SalesEmployee(userID,username,Role , Dept);
            SalesEmployee salesEmployee=new SalesEmployee();
            salesEmployee.directory();
        }
        else if (Role.equalsIgnoreCase("Employee Warehouse")){
            System.out.println("Login successful! Welcome " );
            System.out.println("Role: " + Role);
            WarehouseEmployee we=new WarehouseEmployee(userID,username,Role , Dept);
            WarehouseEmployee warehouseEmployee=new WarehouseEmployee();
            warehouseEmployee.directory();
        }

    }
}
