package com.SpringWithJpa1.Employee2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by ttn on 15/3/21.
 */
@Component
public class EmployeeService {
    @Autowired
     EmployeeRepository employeeRepository;


    Iterable<Employee>findEmployee(){
        return employeeRepository.findAll();
    }
    //Q1
   List<Object[]> findEmployeeService(){

        return employeeRepository.findSalaryGraterThanAvg();
   }
   //Q2
   @Transactional
   public void updateLessThanAvgSalary(int salary){
       employeeRepository.updateSalaryLessThanAverage(salary,employeeRepository.averageSalary());
   }
   //Q3
   @Transactional
   public void deleteEmployeeService(){

       employeeRepository.deleteEmployeeBySalary(1100);
   }
   //Q4
    @Transactional
   public List<Object[]> findEmployee1(){
       List<Object[]> employee = employeeRepository.finalEmployeeDetail2("singh");
       return employee;
   }
   //@5
   @Transactional
   public void deleteEmployeeByAge(){

       employeeRepository.deleteEmployeeByAge(27);
   }
}
