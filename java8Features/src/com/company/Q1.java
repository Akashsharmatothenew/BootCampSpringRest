package com.company;

/**
 * Created by ttn on 20/2/21.
 */

interface greaterOrNot{
    boolean great(int a,int b);
}
interface incrementByOne{
    int increment(int a);
}
interface addTwoString{
    String add(String str,String str2);
}
interface uppercase{
    String upperCase1(String str2);
}
public class Q1 {
    public static void main(String[] agr){
        greaterOrNot gr1 = (a,b)->(a>b);
        System.out.println(gr1.great(40,45));

        incrementByOne inc1 = (a)->(++a);
        System.out.println(inc1.increment(7));

        addTwoString add1=(a,b) ->(a.concat(b));
        System.out.println(add1.add("Akash ","Sharma"));

        uppercase upc1 = (a)->(a.toUpperCase());
        System.out.println(upc1.upperCase1("akash"));
    }
}
