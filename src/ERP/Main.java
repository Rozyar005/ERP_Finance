package ERP;

import Database.myJDBC;
import Finance.Expenses;
import Finance.Revenue;

public class Main {

    public static void main(String[] args) {
        myJDBC j=new myJDBC();
        j.connectionSQL();
        Expenses e=new Expenses();
        e.cal();
        Revenue r=new Revenue();
        r.cal();

        Log_In log=new Log_In();
        log.login();


    }

}
