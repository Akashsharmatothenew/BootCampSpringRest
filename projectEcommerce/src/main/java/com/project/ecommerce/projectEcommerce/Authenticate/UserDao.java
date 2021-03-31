package com.project.ecommerce.projectEcommerce.Authenticate;


import com.project.ecommerce.projectEcommerce.Entity.Users.Role;
import com.project.ecommerce.projectEcommerce.Entity.Users.User;
import com.project.ecommerce.projectEcommerce.Entity.Users.UserAttempts;
import com.project.ecommerce.projectEcommerce.Repository.UserAttemptsRepository;
import com.project.ecommerce.projectEcommerce.Repository.UserRepository;
import com.project.ecommerce.projectEcommerce.Services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Repository
public class UserDao {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserAttemptsRepository userAttemptsRepository;

    @Autowired
    EmailService emailService;

    private static final int MAX_ATTEMPTS = 3;


    AppUsers loadUserByUsername(String username) {
        System.out.println("In User dao");
        User user = userRepository.findByUsername(username);
        List<GrantedAuthority> grantedAuthorities = new LinkedList<>();
        for (Role role : user.getRole()) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getAuthority()));
        }
        System.out.println("Out of user dao");
        System.out.println(user);
        if (username != null) {
            return new AppUsers(user.getEmail(), user.getPassword(), grantedAuthorities, user.getNonLocked(),user.getIsActive());
        } else {
            throw new RuntimeException();
        }
    }

    public void updateFailAttempts(String username) {
        UserAttempts userAttemptExists=userAttemptsRepository.findByUsername(username);

        if(userAttemptExists!=null) {
            User user = userRepository.findByUsername(username);
            if (user != null) {
                userAttemptExists.setAttempts(userAttemptExists.getAttempts() + 1);
                userAttemptExists.setLastModified(new Date());
                userAttemptsRepository.save(userAttemptExists);
            }
            if (userAttemptExists.getAttempts() >= MAX_ATTEMPTS) {

                User userFound=userRepository.findByUsername(username);
                userFound.setNonLocked(false);
                userRepository.save(user);
                emailService.sendEmail(user.getEmail(),"Account Locked","Your Account has been locked as you have used the three attempts");
            }
        }
        else {
            User user = userRepository.findByUsername(username);
            if (user != null) {
                UserAttempts userAttempts = new UserAttempts();
                userAttempts.setUsername(username);
                userAttempts.setAttempts(1);
                userAttempts.setLastModified(new Date());
                userAttemptsRepository.save(userAttempts);
            }
        }
    }

    public void resetFailAttempts(String username) {
        UserAttempts userAttempts=userAttemptsRepository.findByUsername(username);
        if(userAttempts!=null){
            userAttempts.setAttempts(0);
            userAttempts.setLastModified(new Date());
            userAttemptsRepository.save(userAttempts);
        }
    }

}
