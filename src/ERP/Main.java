package ERP;

import Database.myJDBC;
import Finance.Profits;
import Finance.Revenue;
import Finance.Expenses;

public class Main {

    public static void main(String[] args) {
        myJDBC j=new myJDBC();
        try{
            j.connectionSQL();


        }finally {
            System.out.println("Connection Failed ");
        }
        Revenue r=new Revenue();
        Expenses e=new Expenses();
        Profits p=new Profits();
        r.cal();
        e.cal();
        p.cal();


        Log_In log=new Log_In();
        log.login();


    }

}
