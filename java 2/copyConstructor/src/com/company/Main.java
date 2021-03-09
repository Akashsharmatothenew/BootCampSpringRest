package com.company;

class Student{
    int id;
    String name;
    Student(int i,String n){
        id =i;
        name=n;
    }
    Student(Student s){
        id = s.id;
        name = s.name;
    }
    void display(){
        System.out.println(id +"  "+name);
    }
}
public class Main {

    public static void main(String[] args) {
    Student a = new Student(111,"Akash");
    Student b = new Student(a);
    a.display();
    b.display();
    }
}
