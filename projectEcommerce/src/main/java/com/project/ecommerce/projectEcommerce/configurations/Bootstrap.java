package com.project.ecommerce.projectEcommerce.configurations;



import com.project.ecommerce.projectEcommerce.Repository.UserRepository;
import com.project.ecommerce.projectEcommerce.entities.Admin;
import com.project.ecommerce.projectEcommerce.entities.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Bootstrap implements ApplicationRunner {

    @Autowired
    UserRepository userRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        Admin admin = new Admin();
        admin.setId(1l);
        admin.setEmail("Akashsharma1@gmail.com");
        admin.setFirstName("Akash");
        admin.setMiddleName("Saitiya");
        admin.setLastName("Sharma");
        admin.setIsActive(true);
        admin.setUsername("Akashsharma");
        admin.setIsDeleted(false);
        admin.setNonLocked(true);
        admin.setPassword(passwordEncoder.encode("Akash@1234"));
       List<Role> roles = new ArrayList<>();
        roles.add(new Role("ROLE_ADMIN"));
        admin.setRole(roles);

        userRepository.save(admin);
        System.out.println("Total users saved::" + userRepository.count());
    }
}

