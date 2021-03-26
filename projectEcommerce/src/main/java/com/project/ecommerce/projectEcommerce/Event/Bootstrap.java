package com.project.ecommerce.projectEcommerce.Event;

import com.project.ecommerce.projectEcommerce.Entity.Address;
import com.project.ecommerce.projectEcommerce.Entity.Role;
import com.project.ecommerce.projectEcommerce.Entity.User;
import com.project.ecommerce.projectEcommerce.Services.RoleRepository;
import com.project.ecommerce.projectEcommerce.Services.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by ttn on 24/3/21.
 */
@Component
public class Bootstrap implements ApplicationRunner{
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        if (userRepository.count() < 1) {
            PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            User admin = new User();
            admin.setFirstName("Akash");
            admin.setLastName("Sharma");
            admin.setEmail("xyz@gmial.com");
            admin.setPassword(passwordEncoder.encode("pass"));
            admin.isActivate(true);
            admin.isDelete(false);

            Set<Role> roles = new HashSet<>();
            Role role1 =new Role();
            role1.setAuthority("ROLE_ADMIN");
            roles.add(role1);
            admin.setRoles(roles);

            userRepository.save(admin);
        }
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<Bootstrap"+userRepository.count());

    }
}
