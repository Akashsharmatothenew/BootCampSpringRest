package com.company;

/**
 * Created by ttn on 20/2/21.
 */
public class Q2 {
    public static void main (String[] agr){
        multiple mu1 = (a,b)->(a*b);
        System.out.println(mu1.mul(34,29));

    }
}
interface multiple{
    int mul(int a,int b);
}