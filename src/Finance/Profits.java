package Finance;

public class Profits extends management{
    public double Profits;
    public double Total_P;

    @Override
    public void cal() {
        Profits=Total_R-Total_E;
        Total_P=Profits*0.7;
        this.view();

    }

    @Override
    public void view() {
        System.out.println("The Profit Before 30% Tax is: "+Profits+" $");
        System.out.println("The Total Profits Of the Business is: "+Total_P+" $");
        System.out.println();
    }
}
