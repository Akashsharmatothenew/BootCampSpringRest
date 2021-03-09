package com.SpringwithRest1.RestSpring.Q3;

import com.SpringwithRest1.RestSpring.Q2.EmployeeService;
import com.SpringwithRest1.RestSpring.Q2.Q2Employee;
import com.SpringwithRest1.RestSpring.Q6.EmployeeNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

/**
 * Created by ttn on 8/3/21.
 */
@RestController
public class Q3EmployeeResource {
    @Autowired
    EmployeeService employeeService;
    //Get uri("/employee")
    //retriveAllemployee
    @GetMapping("/employee/Q3")
    public List<Q2Employee>retrieveAllEmployee(){
        return employeeService.findAll();
    }
    //Q4 get one employee one
    @GetMapping("/employee/Q4/{id}")
    public Q2Employee retrieveEmployee(@PathVariable int id){
        Q2Employee employee= employeeService.findOne(id);
         if(employee==null)
             throw new EmployeeNotFound("id - "+id);

        return employee;
    }
    //Q5
    //created emplyoee
    @PostMapping("/employee/Q5")
    public ResponseEntity<Object> createdUser(@Valid @RequestBody Q2Employee employee){
       Q2Employee saveEmplyoee=  employeeService.save(employee);
       //Created
        // /User/5=/user/user.getid(),=/user/{id}=savedEmployee.getId()

      URI location=  ServletUriComponentsBuilder.
                fromCurrentRequest().
                path("/{id}").
                buildAndExpand(saveEmplyoee.getId()).toUri();

      return ResponseEntity.created(location).build();
    }
    //Q7   delete a user
    @DeleteMapping("/employee/Q7/{id}")
    public void deleteEmployee(@PathVariable int id){
        Q2Employee employee = employeeService.deleteById(id);
        if(employee==null)
            throw new EmployeeNotFound("id - "+id);
    }
    @PutMapping("/employee/Q8/{id}")
            public void update(@RequestBody Q2Employee employee,@PathVariable int id){

        Q2Employee employees = employeeService.updateById(id,employee);
    }


}
