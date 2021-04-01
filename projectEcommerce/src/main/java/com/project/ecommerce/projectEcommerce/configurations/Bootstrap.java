package com.project.ecommerce.projectEcommerce.configurations;//package com.example.ecommerceProject.configurations;
//
//import com.example.ecommerceProject.entities.Admin;
//import com.example.ecommerceProject.entities.Role;
//import com.example.ecommerceProject.entities.User;
//import com.example.ecommerceProject.repos.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.ApplicationArguments;
//import org.springframework.boot.ApplicationRunner;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Component
//public class Bootstrap implements ApplicationRunner {
//
//    @Autowired
//    UserRepository userRepository;
//
//    @Override
//    public void run(ApplicationArguments args) throws Exception {
//        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        Admin admin = new Admin();
//        admin.setId(1l);
//        admin.setEmail("admin321@gmail.com");
//        admin.setFirstName("Iron");
//        admin.setMiddleName("");
//        admin.setLastName("Man");
//        admin.setIsActive(true);
//        admin.setUsername("Admin");
//        admin.setIsDeleted(false);
//        admin.setNonLocked(true);
//        admin.setPassword(passwordEncoder.encode("pass@1234"));
//        List<Role> roles = new ArrayList<>();
//        roles.add(new Role("ROLE_ADMIN"));
//        admin.setRole(roles);
//
//        userRepository.save(admin);
//        System.out.println("Total users saved::" + userRepository.count());
//    }
//}
