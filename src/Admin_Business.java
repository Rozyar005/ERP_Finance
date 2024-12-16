import jdk.dynalink.Operation;
import java.util.Scanner;

    public class Admin_Business extends AbstractClass{
    Scanner input=new Scanner(System.in);


    public Admin_Business(){
        super();

    }

    @Override
    public void performFunctionality() {
        System.out.println("Choose one of the operations: 1.Employee's Info 2.CashFlow 3.Warehousing 4.Sales 5.Finances 6.Products ");
        int op=input.nextInt();
        switch (op){
            case 1:
                System.out.println("Choose the Employee Type 1. CEO 2.Workers");
                int op1=input.nextInt();
                if (op1==1){
                    CEO c=new CEO();
                    c.Display();
                    operationEmployee();
                }else if(op1==2){
                    Employee e=new Employee();
                    e.Display();










                    operationEmployee();
                }else{
                    System.out.println("Invalid try again");
                    performFunctionality();
                }
                break;
            case 2:

        }

    }

    public  void operationEmployee(){
        System.out.println("Do you wanna Perform Operations on the given Info? 1.yes 2.no ");
        int op= input.nextInt();
        if(op==1){
            System.out.println("Enter one of the Operations (1.Add 2.Remove  3.Update) Info ");
            int op1=input.nextInt();
            User_Operations user_operations=new User_Operations();

            switch (op1){
                case 1:
                    user_operations.userAdd();
                    break;
                case 2:
                    System.out.println("Choose a Department that you wanna remove the Employees from: 1.Finanace 2.Warehousing 3.Sales ");
                    user_operations.userRemove();
                    break;
                    case 3:
                        System.out.println("Choose a Department that you wanna Update the Employees from: 1.Finanace 2.Warehousing 3.Sales ");
                        user_operations.userUpdate();
                        break;
                default:
                    System.out.println("Invalid Enter it again");
                    operationEmployee();
                    break;


            }

        } else if (op==2) {
            this.performFunctionality();
        }else {
            System.out.println("Invalid Try again");
            operationEmployee();
        }
    }
}
