package com.company;

/**
 * Created by ttn on 21/2/21.
 */
interface flybird{
    default void run(){
        System.out.println("Fly in the sky");
    }
}
interface waterbird{
    default void run(){
        System.out.println("Swimming in water");
    }
}
public class Q8 implements flybird,waterbird{
    public void run(){
        flybird.super.run();
        waterbird.super.run();
    }
    public static void main(String[] arg){
        Q8 Swan = new Q8();
        Swan.run();
    }
}
