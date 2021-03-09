package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

class employee{
      String name;
      Double age;
      Double Salary;
    employee (String n,Double a,Double s){
        name = n;
        age=a;
        Salary=s;
    }
    @Override
    public String toString(){
        return "Employee Name is "+ name +"   Age is "+age+"   Sallary is"+Salary+"\n";
    }
}
class sortSallary implements Comparator<employee>{

        @Override
        public int compare(employee o1, employee o2) {
            if(o1.Salary==o2.Salary)
                return 0;
            else if(o1.Salary<o2.Salary)
                return -1;
            else
                return 1;
        }

}

public class Main {

    public static void main(String[] args) {
        ArrayList<employee> employeeList = new ArrayList<employee>();
        employeeList.add(new employee("ABC",24.1,10000.0));
        employeeList.add(new employee("ABD",28.8,12000.0));
        employeeList.add(new employee("ABE",26.3,18000.0));
        employeeList.add(new employee("ABD",22.7,11000.0));
        employeeList.add(new employee("ABF",27.4,19000.0));
        employeeList.add(new employee("ABG",25.1,13000.0));

        Collections.sort(employeeList,new sortSallary() );
        Iterator it = employeeList.iterator();
        while(it.hasNext()){
            employee e = (employee) it.next();
            System.out.println(e);

        }
    }
}
