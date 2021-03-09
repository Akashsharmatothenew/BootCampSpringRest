package com.company;

/**
 * Created by ttn on 20/2/21.
 */

interface Sayable{
    //default Method
    default void say(){
        System.out.println("This is deault Method");
    }

    void sayMore(String msg);

    //Static Method
    static void sayLouder(String msg){
        System.out.println(msg);
    }
}
public class Q6 implements Sayable{
    @Override
    public void sayMore(String msg) {
        System.out.println(msg);
    }

    @Override
    public void say() {
     System.out.println("Override The Default Method");
    }

    public static void main (String[] arg){
        Q6 dm = new Q6();
        dm.say();//calling default method
        dm.sayMore("Anything after default method");
        Sayable.sayLouder("Calling Static Method");
    }
}
