package com.project.ecommerce.projectEcommerce.Event;

import com.project.ecommerce.projectEcommerce.Entity.Users.Address;
import com.project.ecommerce.projectEcommerce.Entity.Users.Admin;
import com.project.ecommerce.projectEcommerce.Entity.Users.Role;
import com.project.ecommerce.projectEcommerce.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by ttn on 24/3/21.
 */
@Component
public class Bootstrap implements ApplicationRunner {

    @Autowired
    UserRepository userRepository;
    @Override
    public void run(ApplicationArguments args) throws Exception {
       /* PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
          Admin admin = new Admin();
          admin.setId(1l);
          admin.setEmail("admin321@gmail.com");
          admin.setFirstName("Iron");
          admin.setMiddleName("");
          admin.setLastName("Man");
          admin.setIsActive(true);
          admin.setIsDeleted(false);
          admin.setNonLocked(true);
          admin.setPassword(passwordEncoder.encode("pass@1234"));
          List<Role> roles = new ArrayList<>();
          roles.add(new Role("ROLE_ADMIN"));
         admin.setRole(roles);

          userRepository.save(admin);
          System.out.println("Total users saved::" + userRepository.count());*/

    }
}

