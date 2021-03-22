package com.SpringWithJpa1.Employee2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by ttn on 15/3/21.
 */
@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/Q52")
    public Iterable<Employee> getDetail(){
        return employeeService.getEmploye();
    }
    @PostMapping("/Q3")
    public Employee createEmployee(@RequestBody Employee emp){
        Employee employee = employeeService.createEmployee(emp);
        return employee;
    }
    @PutMapping("/Q4/{id}")
    public Employee update(@RequestBody Employee employee, @PathVariable int id){
     return employeeService.updateEmployee(employee,id);
    }
    @DeleteMapping("/Q5/{id}")
    public void delete(@PathVariable int id){
         employeeService.deleteEmployee(id);
    }
    @GetMapping("/Q6")
    public long count(){
        return employeeService.count();
    }
    //@GetMapping("/Q8")

    @GetMapping("/Q8/{name}")
    public List<Employee> getByName(@PathVariable String name){
        return employeeService.GetDetailFindByName(name);
    }
    @GetMapping("/Q9")
    public List<Employee> getByCharacter(){
        return employeeService.GetDetailFindBynNameLike();
    }
    @GetMapping("/Q10")
    public List<Employee> getByAgeBetween(){
        int age1=28;
        int age2=32;
        return employeeService.GetDetailFindByAgeBetween(age1,age2);
    }

}
