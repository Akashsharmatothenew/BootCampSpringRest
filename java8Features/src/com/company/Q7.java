package com.company;

/**
 * Created by ttn on 20/2/21.
 */

interface Sayable1 {
    //default Method
    default void say() {
        System.out.println("This is deault Method");
    }

    void sayMore(String msg);
}
public class Q7 implements Sayable1 {
    @Override
    public void say() {
        System.out.println("Override Default Method");
    }

    @Override
    public void sayMore(String msg) {
        System.out.println(msg);
    }

    public static void main(String[] arg) {
        Q7 dm = new Q7();
        dm.say();//calling override default method
        dm.sayMore("Anything after default method");
    }
}
