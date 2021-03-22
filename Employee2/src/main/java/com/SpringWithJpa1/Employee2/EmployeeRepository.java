package com.SpringWithJpa1.Employee2;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by ttn on 15/3/21.
 */
public interface EmployeeRepository extends CrudRepository<Employee,Integer> {

        //Q1 Display the first name
        @Query("select firstName,lastname\n"+
                " from Employee\n "+
                "where salary >(select avg(salary)from Employee )\n"+
                " order by salary DESC,age")
        List<Object[]>findSalaryGraterThanAvg();
        @Query("select avg (salary) from Employee ")
        double averageSalary();
        //Q2 update salary of all employee
        @Modifying
        @org.springframework.transaction.annotation.Transactional
        @Transactional
        @Query(value = "update Employee set salary=:salary where salary<:averageSalary1")
        void updateSalaryLessThanAverage(@Param("salary") double salary, @Param("averageSalary1")double averageSalary1);
        //Q3 DElete salary
        @Modifying
        @Transactional
        @Query("delete from Employee where salary<:minsalary")
        void deleteEmployeeBySalary(@Param("minsalary")double salary);
        //Q4
        @Query(value ="SELECT empid,empFirstName,empAge FROM employeeTable WHERE empLastName=:LastName",nativeQuery = true)
        List<Object[]>finalEmployeeDetail2(@Param("LastName") String LastName);
        @Modifying
        @Transactional
        //Q5
        @Query(value = "DELETE FROM employeeTable WHERE empAge>:age",nativeQuery = true)
        void deleteEmployeeByAge(@Param("age") int age);
}
