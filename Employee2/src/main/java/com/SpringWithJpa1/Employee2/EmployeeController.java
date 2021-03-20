package com.SpringWithJpa1.Employee2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by ttn on 15/3/21.
 */
@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
     @GetMapping("/Q11")
     public Iterable<Employee>getall(){
         return employeeService.findEmployee();
     }
    @GetMapping("/Q1")
    public List<Object[]> getDetailes2(){
        return employeeService.findEmployeeService();
    }
    @DeleteMapping("/Q3")
    public void Delete(){
        employeeService.deleteEmployeeService();
    }
    @PatchMapping("/Q2")
    public void updateSalary(@RequestBody Employee employee){
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>intercepted");
        employeeService.updateLessThanAvgSalary(employee.getSalary());

    }
    @GetMapping("/Q4")
    public List<Object[]> detailEmployee(){

        return employeeService.findEmployee1();
    }
    @DeleteMapping("/Q5")
    public void deleteByAge(){
        employeeService.deleteEmployeeByAge();
    }
}
