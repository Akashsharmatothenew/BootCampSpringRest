package com.SpringWithJpa1.Employee2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ttn on 17/3/21.
 */
@RestController
public class EmployeeController {
     @Autowired
    EmployeeService employeeService;

     @GetMapping("/Q1")
    public Iterable<Employee> ShowEmployeeList(){
         return employeeService.ShowDetails();
     }

     @PostMapping("/Q2")
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeService.createEmployeeUsingPost(employee);
     }
}
