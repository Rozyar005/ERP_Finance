public class CEO_Warehousing extends CEO{
    public CEO_Warehousing(String id, String username, String password, String role, String department) {
        super(id, username, password, role, department);
    }

    public CEO_Warehousing() {
    }


    @Override
    public void performFunctionality() {
        System.out.println("CEO Warehousing functionalities: View and manage all data.");
        // Implement CEO-specific logic here
    }
}
