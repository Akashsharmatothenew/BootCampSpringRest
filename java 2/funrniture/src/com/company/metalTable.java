package com.company;

/**
 * Created by ttn on 17/2/21.
 */
public class metalTable extends furniture{
    metalTable(){
        System.out.println("Metal Table is Created");
    }
    @Override
    public int fireCheck(int f) {
        if(f>5){
            System.out.println("MeatalTable streesTest Pass");
        }
        else{
            System.out.println("MeatalTable streesTest Fail");
        }
        return 0;
    }
    @Override
    public int streesTest(int s) {
        if(s>6){
            System.out.println("MeatalTable streesTest Pass");
        }
        else{
            System.out.println("MeatalTable streesTest Fail");
        }
        return 0;
    }
}
