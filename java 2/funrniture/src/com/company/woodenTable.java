package com.company;

/**
 * Created by ttn on 17/2/21.
 */
public class woodenTable extends furniture{
    woodenTable(){
        System.out.println("Wooden Table Is Created");
    }

    @Override
    public int fireCheck(int f) {
        if(f<5){
            System.out.println("WoodenTable fireCheck test fail");
        }
        else{
            System.out.println("WoodenTable fireCheck test Pass");
        }
        return 0;
    }

    @Override
    public int streesTest(int s) {
        if(s<5){
            System.out.println("WoodenTable fireCheck test fail");
        }
        else{
            System.out.println("WoodenTable fireCheck test Pass");
        }
        return 0;
    }
}
