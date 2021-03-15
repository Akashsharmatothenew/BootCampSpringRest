package com.SpringwithRest1.RestSpring.flitering;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by ttn on 11/3/21.
 */
@RestController
public class FilteringController {
    @Autowired
    FilteringUsersService1 filteringUsersService1;


    @GetMapping("/Q8")
    public List<FilteringUser1> retrieveAllDetailes(){
        return filteringUsersService1.findAll();
    }
    @PostMapping("/Q8")
    public FilteringUser1 createdUser(@RequestBody FilteringUser1 users){
        FilteringUser1 saveUsers = filteringUsersService1.save(users);
        return saveUsers;
    }

}
