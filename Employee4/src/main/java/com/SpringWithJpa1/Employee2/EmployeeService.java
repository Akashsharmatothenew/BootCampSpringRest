package com.SpringWithJpa1.Employee2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ttn on 17/3/21.
 */
@Service
public class EmployeeService {
   @Autowired
    EmployeeRepository employeeRepository;


   public Iterable<Employee> ShowDetails(){
       return employeeRepository.findAll();
   }

   public Employee create(){
       Employee employee = new Employee();
       employee.setFirstName("Akash");
       employee.setLastName("Sharma");
       employee.setAge(23);
       EmployeeSalary salary = new EmployeeSalary();
       employee.setEmployeeSalary(salary);
       salary.setBasicSalary(1200);
       salary.setBonusSalary(500);
       salary.setTaxAmount(230);
       salary.setSpecialAllowanceSalary(70);
       employeeRepository.save(employee);

       return employee;

   }
   public Employee createEmployeeUsingPost(Employee employee){
       return employeeRepository.save(employee);
   }


}
