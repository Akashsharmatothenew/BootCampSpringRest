package com.company;

class Add{
    static int add(int a,int b){
        return a+b;
    }
    static double add(double a,double b){
        return a+b;
    }
}

class Multiplication{
    static float mul(float a,float b){
        return a*b;
    }
    static int mul(int a,int b){
        return a*b;
    }
}
class Concat{
    static void abc(String str1,String str2){
        String str3 = str1.concat(str2);
        System.out.println(str3);
    }
    static void abc(String str1,String str2,String str3){
        String str4 = str1.concat(" ").concat(str2).concat(" ").concat(str3);
        System.out.println(str4);
    }
}


public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println(Add.add(2,2));
        System.out.println(Add.add(2.2,4.5));
        System.out.println(Multiplication.mul(12.2f,3.1f));
        System.out.println(Multiplication.mul(3,6));
        Concat.abc("Akash","Sharma");
        Concat.abc("Akash","Sharma","New");
    }
}
