package com.SpringwithRest1.RestSpring.Q2;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by ttn on 7/3/21.
 */
@Component
public class EmployeeService {
    static List<Q2Employee> employees = new ArrayList<>();
    static int idCount =3;
    static {
        employees.add(new Q2Employee(1,"Akash",23));
        employees.add(new Q2Employee(2,"Mayank",24));
        employees.add(new Q2Employee(3,"manoj",25));
    }

    //find all employee
    public List<Q2Employee> findAll(){

        return employees;
    }
    //add employee to List
    public Q2Employee save( Q2Employee employe){
           employe.setId(++idCount);
        employees.add(employe);
        return employe;
    }
   /* public Q2Employee update(Q2Employee employee,int id){
       Q2Employee employee= employee   findOne(id);
        employees.set(1,employee);
        return employee;
    }*/
    //findOneEmployee
    public Q2Employee findOne(int id){
        for(Q2Employee employe:employees){
            if(employe.getId()==id){
                return employe;
            }
        }
        return null;
    }
    //delete Employee
    public Q2Employee deleteById(int id){
        Iterator<Q2Employee>iterator=employees.iterator();
        while(iterator.hasNext()){
            Q2Employee employee = iterator.next();
            if(employee.getId()==id){
                iterator.remove();
                return employee;
            }

        }
        return null;
    }
    public Q2Employee updateById(int id){
        Iterator<Q2Employee>iterator=employees.iterator();
        while(iterator.hasNext()){
            Q2Employee employee = iterator.next();
                if (employee.getId()==id){
                employee.setName("Changed");
                return employee;

            }

        }
        return null;
    }
}
