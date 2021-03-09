package java1;

/**
 * Created by ttn on 28/2/21.
 */
class Bank{
    int intreset =0;
    public void getDetails(){
        System.out.println("Bank Rate of Intreset is : "+intreset+" %");
    }
}
class SBI extends Bank{
    int intreset=8;
    @Override
    public void getDetails(){
        System.out.println(" SBI rate of interest is  : "+intreset+" %");
    }
}
class BOI extends Bank{
    int intreset=10;
    @Override
    public void getDetails(){
        System.out.println(" SBI rate of interest is  : "+intreset+" %");
    }
}
class ICICI extends Bank{
    int intreset=12;
    @Override
    public void getDetails(){
        System.out.println(" SBI rate of interest is  : "+intreset+" %");
    }
}
public class Q11 {
    public static void main(String[] args) {
        Bank s = new SBI();
        Bank b = new BOI();
        Bank i = new ICICI();
        Bank n = new Bank();

        s.getDetails();
        b.getDetails();
        i.getDetails();


    }



}
