package com.company;


class bank{
    int interest = 0;
    void getDetails(){
        System.out.println(" the rate of interest is  : "+interest);
    }
}
class SBI extends bank{
    int interest = 8;
    void getDetails(){
        System.out.println(" SBI rate of interest is  : "+interest+" %");
    }
}
class BOI extends bank{
    int interest = 10;
    void getDetails(){
        System.out.println(" BOI rate of interest is  : "+interest+" %");
    }
}
class ICICI extends bank{
    int interest = 9;
    void getDetails(){
        System.out.println(" ICICI rate of interest is : "+interest+" %");
    }
}


public class Main {

    public static void main(String[] args) {
        SBI s = new SBI();
        BOI b = new BOI();
        ICICI i = new ICICI();
        s.getDetails();
        b.getDetails();
        i.getDetails();

    }
}
