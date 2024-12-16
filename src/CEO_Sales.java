public class CEO_Sales extends CEO{
    public CEO_Sales(String id, String username, String password, String role, String department) {
        super(id, username, password, role, department);
    }

    public CEO_Sales() {
    }

    @Override
    public void performFunctionality() {
        System.out.println("CEO Sales functionalities: View and manage all data.");
        // Implement CEO-specific logic here
    }
}
