package com.springsecurity.demo.springsecurityoauth2bootcampmaven.dao;


import com.springsecurity.demo.springsecurityoauth2bootcampmaven.domain.GrantAuthorityImpl;
import com.springsecurity.demo.springsecurityoauth2bootcampmaven.domain.User;
import com.springsecurity.demo.springsecurityoauth2bootcampmaven.domain.Users;
import com.springsecurity.demo.springsecurityoauth2bootcampmaven.service.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public class UserDao {
    @Autowired
    UserRepository userRepository;

   public User loadUserByUsername(String username){
        Users users = userRepository.findByUsername(username);
        System.out.println(users);
        if(username!=null){
            return new User(users.getUsername(),users.getUserpassword(),Arrays.asList(new GrantAuthorityImpl(users.getRole())));
        }else {
            throw new RuntimeException();
        }
    }
}
