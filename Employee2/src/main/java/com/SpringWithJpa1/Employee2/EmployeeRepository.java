package com.SpringWithJpa1.Employee2;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by ttn on 15/3/21.
 */
public interface EmployeeRepository extends PagingAndSortingRepository<Employee,Integer> {
     List<Employee>findByName(String name);
     List<Employee>findByAgeBetween(int a,int b);
     List<Employee>findByNameLike(String a);

}
