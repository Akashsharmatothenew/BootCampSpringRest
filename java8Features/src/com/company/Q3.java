package com.company;


import java.util.function.BiFunction;

class adder{
    int addTwo(int a,int b){
        return a+b;
    }
}
class subtractor{
    int sub(int b,int c){
        if(b>c)
            return b-c;
        else
            return 0;
    }
}
class multiplication{
    static int mul(int a,int b){
        return a*b;
    }
}



public class Q3 {
    public static void main(String[] arg) {
        BiFunction<Integer, Integer, Integer> ad1 = new adder()::addTwo;
        int result = ad1.apply(20, 19);
        System.out.println(result);

        BiFunction<Integer,Integer,Integer> sub1 = new subtractor()::sub;
        int result1=sub1.apply(8,3);
        System.out.println(result1);

        BiFunction<Integer,Integer,Integer> m1=multiplication::mul;
        int result3= m1.apply(34,5);
        System.out.println(result3);


        BiFunction<Integer,Integer,Integer>add=(a,b)->a+b;
        System.out.println("sum = " +add.apply(23,45));

    }
}
