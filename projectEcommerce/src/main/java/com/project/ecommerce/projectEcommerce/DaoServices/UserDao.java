package com.project.ecommerce.projectEcommerce.DaoServices;

import com.project.ecommerce.projectEcommerce.Domain.AppUers;
import com.project.ecommerce.projectEcommerce.Domain.GrantAuthorityImpl;
import com.project.ecommerce.projectEcommerce.Entity.Role;
import com.project.ecommerce.projectEcommerce.Entity.User;
import com.project.ecommerce.projectEcommerce.Services.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Created by ttn on 24/3/21.
 */
@Repository
public class UserDao {
    @Autowired
    UserRepository userRepository;
    public AppUers loadUserByUsername(String username){
        User users = userRepository.findByFirstName(username);
        System.out.println(users);
        if(username!=null){
            return new AppUers(users.getEmail(),users.getPassword(),
                    users.getRoles().stream().
                            map(role->new GrantAuthorityImpl(role.getAuthority())).
                            collect(Collectors.toList()));
        }else {
            throw new RuntimeException();
        }
    }
}
