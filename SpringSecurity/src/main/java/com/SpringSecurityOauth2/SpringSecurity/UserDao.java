package com.SpringSecurityOauth2.SpringSecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Arrays;

/**
 * Created by ttn on 16/3/21.
 */
@Repository
public class UserDao {
    @Autowired
    UserRepository userRepository;

    AppUser loadUserByUsername(String name){
        User user = userRepository.findByUsername(name);
        System.out.println(user);
        if (name!= null){
            return new AppUser(user.getUsername(),user.getPassword(), Arrays.asList(new GrantAuthorityImpl(user.getRole())));
        }else {
            throw new RuntimeException();
        }
    }
}
