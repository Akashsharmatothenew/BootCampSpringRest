package com.company;

/**
 * Created by ttn on 17/2/21.
 */
public class woodenChair extends furniture{
    woodenChair(){
        System.out.println("WoodenChair is Created");
    }
    @Override
    public int fireCheck(int f) {
        if(f<5){
            System.out.println("WoodenChair fireCheck test fail");
        }
        else{
            System.out.println("WoodenChair fireCheck test Pass");
        }
        return f;
    }
    @Override
    public int streesTest(int s) {
        if(s<5){
            System.out.println("WoodenChair StressTest fail");
        }
        else {
            System.out.println("WoodenChair StressTest Pass");
        }

        return s;
    }
}
