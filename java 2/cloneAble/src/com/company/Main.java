package com.company;
class Student implements Cloneable{
    int rollNo;
    String name;

    Student(int r,String n){
        rollNo=r;
        name=n;
    }
    public Object clone()throws CloneNotSupportedException{
        return super.clone();
    }
}

public class Main {

    public static void main(String[] args) {
	try{
	    Student a = new Student(111,"Akash");
	    Student b = (Student)a.clone();
	    System.out.println(a.rollNo+"  "+a.name);
        System.out.println(b.rollNo+"  "+b.name);
    }
    catch (CloneNotSupportedException c){
	    System.out.print(c);
    }
    }
}
