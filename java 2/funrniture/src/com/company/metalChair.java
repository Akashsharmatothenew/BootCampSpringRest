package com.company;

/**
 * Created by ttn on 17/2/21.
 */
public class metalChair extends furniture{
    metalChair(){
        System.out.println("Metal Chair is Created");
    }

    @Override
    public int fireCheck(int f) {
        if(f<5){
            System.out.println("MeatalChair fireCheck test Pass");
        }
        else{
            System.out.println("MetalChair fireCheck test fail");
        }
        return 0;
    }

    @Override
    public int streesTest(int s) {
        if(s>5){
            System.out.println("MeatalChair streesTest Pass");
        }
        else{
            System.out.println("MeatalChair streesTest Fail");
        }
        return 0;
    }
}
