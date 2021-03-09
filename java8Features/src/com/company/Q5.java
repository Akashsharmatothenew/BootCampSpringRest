package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Created by ttn on 20/2/21.
 */
   class Employe{
    String name;
    int age;
    Employe(String name,int age){
        this.name=name;
        this.age=age;
    }

}
  public class Q5 {


    public static void main(String[] args) {
        //  Consumer
        Consumer<Integer> con = (x)->{
            System.out.println(x*x);
        };
        con.accept(19);
        //Supplier
        Supplier<String> str1 = () ->"Akash Sharma";
        System.out.println(str1.get());

        //<Predicate>
        Employe emp1 = new Employe("Akash",26);
        Employe emp2 = new Employe("Sumit",23);
        Employe emp3 = new Employe("Mohan",27);
        List<Employe> empList= new ArrayList<Employe>();
        empList.add(emp1);
        empList.add(emp2);
        empList.add(emp3);
        Predicate<Employe> predicateAge = (a) ->a.age >25;
        for(Employe emp : empList){
            if(predicateAge.test(emp)){
                System.out.println(emp.name +" is eligiable by age");
            }
        }

        //Function
        Function<Integer , Integer> futn1 = a-> a*4;
        System.out.println(futn1.apply(4));

        Function<Integer,Integer> futn2 = a-> a+4;
        System.out.println(futn2.apply(4));

        System.out.println(futn2.andThen(futn1).apply(4));

    }

}
