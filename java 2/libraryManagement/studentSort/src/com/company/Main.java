package com.company;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

class student{
    String name;
    Double score;
    Double age;
    student(String n,Double s,Double a){
        name = n;
        score = s;
        age = a;
    }
    @Override
    public String toString(){
        return "Student Name is "+name+"  Score is "+score+"  age is "+age+"\n";
    }

}
class sortByScore implements Comparator<student>{

    @Override
    public int compare(student student, student t1) {
        if(student.score==t1.score)
            return 0;
        else if(student.score>t1.score)
            return - 1;
        else
            return 1;
    }
}
class sortByName implements Comparator<student>{

    @Override
    public int compare(student s1, student s2) {
        return s1.name.compareTo(s2.name);
    }
}


public class Main {

    public static void main(String[] args) throws IOException {
        ArrayList<student> slist = new ArrayList<student>();
        slist.add(new student("ABC",78.0,18.0));
        slist.add(new student("ABD",80.0,19.0));
        slist.add(new student("ABE",60.0,18.5));
        slist.add(new student("ABF",80.0,18.3));
        slist.add(new student("ABC",70.0,18.8));

        Comparator first = new sortByScore();
        Comparator secound = first.thenComparing(new sortByName());
        Collections.sort(slist,secound);
        Iterator it = slist.iterator();
        while (it.hasNext()){
            student s =(student) it.next();
            System.out.println(s);
        }
    }
}
