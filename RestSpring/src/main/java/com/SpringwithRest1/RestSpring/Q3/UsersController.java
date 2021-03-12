package com.SpringwithRest1.RestSpring.Q3;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.context.annotation.Primary;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import com.SpringwithRest1.RestSpring.Q2.UsersService;
import com.SpringwithRest1.RestSpring.Q2.User;
import com.SpringwithRest1.RestSpring.Q6.EmployeeNotFound;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

/**
 * Created by ttn on 8/3/21.
 */

@RestController
public class UsersController {
    @Autowired
    UsersService usersService;
    //Get uri("/employee")
    //retriveAllemployee
    @GetMapping("/users/Q4")
    public List<User>retrieveAllUsers(){
        return usersService.findAll();
    }
    //Q4 get one employee one

    @GetMapping("/Q11/{id}")
    public EntityModel<User> retrieveUsers(@PathVariable int id){
        User list= usersService.findOne(id);
         if(list==null)
             throw new EmployeeNotFound("id - "+id);
         //retrieveAllUsers add link through method
        EntityModel<User> resource = EntityModel.of(list);
        WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllUsers());

        resource.add(linkTo.withRel("all-users"));

        return resource;
    }
    //Q5
    //created emplyoee
    @PostMapping("/users/Q3")
    @ApiModelProperty(notes = "Uri should be create user")
    public ResponseEntity<Object> createdUser(@Valid @RequestBody User employee){
       User saveUsers=  usersService.save(employee);
       //Created
        // /User/5=/user/user.getid(),=/user/{id}=savedEmployee.getId()

      URI location=  ServletUriComponentsBuilder.
                fromCurrentRequest().
                path("/{id}").
                buildAndExpand(saveUsers.getId()).toUri();

      return ResponseEntity.created(location).build();
    }
    //Q7   delete a user
    @DeleteMapping("/users/Q5/{id}")
    @ApiModelProperty(notes = "Uri should be delete user")
    public void deleteEmployee(@PathVariable int id){
        User list = usersService.deleteById(id);
        if(list==null)
            throw new EmployeeNotFound("id - "+id);
    }
    @PutMapping("/users/put/{id}")
    @ApiModelProperty(notes = "Uri should be update user details")
            public void update(@RequestBody User employee, @PathVariable int id){

               usersService.updateById(id,employee);
    }


}
