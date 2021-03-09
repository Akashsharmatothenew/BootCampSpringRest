package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String str ="Akash Sharma Priya";
        String reverse ="";
        for(int i=0;i<10;i++){
            System.out.println(i);
        }
            for(int i=10;i>0;i--)
            {
                System.out.println(i);
            }
        for(int a=str.length()-1;a>=0;a--){
            reverse=reverse+str.charAt(a);
        }
        System.out.println(reverse);
    }
}
