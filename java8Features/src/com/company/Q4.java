package com.company;

/**
 * Created by ttn on 20/2/21.
 */
interface EmployeeFactotry{
    Employee getEmployee(String name,int age,String city);
}
class Employee{
    String name;
    int age;
    String city;
    Employee(String n,int a,String c){
        name=n;
        age=a;
        city = c;
        System.out.println("Name : "+name+", Age : "+age+", City : "+city);
    }
}
public class Q4 {
    public static void main(String[] arg){
        EmployeeFactotry emp1 = Employee::new;
        emp1.getEmployee("Akash",24,"Delhi");


    }
}
