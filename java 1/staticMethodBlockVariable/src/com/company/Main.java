package com.company;


 class myDetail{
    String firstName;
    static String lastName = "Sharmaasharma";
    int age;

    static void change(){
        lastName = "Sharma";
    }
    myDetail(String n,int a){
        firstName = n;
        age =a;
    }
    void display(){
        System.out.println(firstName +" "+lastName+" "+age);
    }
    static{
        System.out.println("My Details :-");
    }

}

public class Main {

    public static void main(String[] args) {
        myDetail.change();
        myDetail my = new myDetail("Akash",24);
        myDetail my1 = new myDetail("vikash",24);

        my.display();



    }
}
