package com.SpringWithJpa1.Employee2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by ttn on 15/3/21.
 */
@Component
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    public Iterable<Employee> getEmploye(){
         Iterable<Employee> result = employeeRepository.findAll();
        return result;
    }

    public Employee createEmployee(Employee employee){
        return employeeRepository.save(employee);
    }
    public Employee updateEmployee(Employee employee,int id){
        Employee employee1 =employeeRepository.findById(id).get();
        employee1.setName(employee.getName());
        employee1.setAge(employee.getAge());
        employee1.setLocation(employee.getLocation());
        employeeRepository.save(employee1);

        return employee1;
    }
    public void deleteEmployee(int id){
        employeeRepository.deleteById(id);
    }
    public long count(){
        return employeeRepository.count();
    }
    public List<Employee>GetDetailFindByName(String name){
        return employeeRepository.findByName(name);
    }
    public List<Employee>GetDetailFindByAgeBetween(int age1,int age2){
        return employeeRepository.findByAgeBetween(age1,age2);
    }
    public List<Employee>GetDetailFindBynNameLike(){
        return employeeRepository.findByNameLike("A%");
    }
}
