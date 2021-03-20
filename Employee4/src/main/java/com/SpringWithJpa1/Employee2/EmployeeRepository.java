package com.SpringWithJpa1.Employee2;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by ttn on 17/3/21.
 */
public interface EmployeeRepository extends CrudRepository<Employee ,Integer> {

}
