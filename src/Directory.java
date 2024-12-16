public class Directory {
    public Directory(String username,String Role,String department) {

        if (Role.equalsIgnoreCase("Admin")) {
            System.out.println("Login successful! Welcome " + username);
            System.out.println("Role: " + Role);
            Admin_Business adminBusiness = new Admin_Business();
            adminBusiness.performFunctionality();
        } else if (Role.equalsIgnoreCase("CEO") && department.equalsIgnoreCase("Finance")) {
            System.out.println("Login successful! Welcome " + username);
            System.out.println("Role: " + Role + ", Department: " + department);
            CEO ceof = new CEO_Finance();
            ceof.performFunctionality();
        } else if (Role.equalsIgnoreCase("CEO") && department.equalsIgnoreCase("Warehousing")) {
            System.out.println("Login successful! Welcome " + username);
            System.out.println("Role: " + Role + ", Department: " + department);
            CEO ceow = new CEO_Warehousing();
            ceow.performFunctionality();

        } else if (Role.equalsIgnoreCase("CEO") && department.equalsIgnoreCase("Sales")) {
            System.out.println("Login successful! Welcome " + username);
            System.out.println("Role: " + Role + ", Department: " + department);
            CEO ceos = new CEO_Sales();
            ceos.performFunctionality();
        } else if (Role.equalsIgnoreCase("Employee") && department.equalsIgnoreCase("Sales")) {
            System.out.println("Login successful! Welcome " + username);
            System.out.println("Role: " + Role + ", Department: " + department);
            Employee empS = new Employee_Sales();
            empS.performFunctionality();
        } else if (Role.equalsIgnoreCase("Employee") && department.equalsIgnoreCase("Warehousing")) {
            System.out.println("Login successful! Welcome " + username);
            System.out.println("Role: " + Role + ", Department: " + department);
            Employee empW = new Employee_Warehousing();
            empW.performFunctionality();
        }
    }


}
