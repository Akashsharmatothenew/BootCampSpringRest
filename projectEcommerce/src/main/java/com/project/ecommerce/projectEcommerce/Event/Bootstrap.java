package com.project.ecommerce.projectEcommerce.Event;

import com.project.ecommerce.projectEcommerce.Entity.Users.Address;
import com.project.ecommerce.projectEcommerce.Entity.Users.Admin;
import com.project.ecommerce.projectEcommerce.Entity.Users.Role;
import com.project.ecommerce.projectEcommerce.Repository.AdminRepository;
import com.project.ecommerce.projectEcommerce.Repository.RoleRepository;
import com.project.ecommerce.projectEcommerce.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ttn on 24/3/21.
 */
@Component
public class Bootstrap implements ApplicationRunner {

    @Autowired
    AdminRepository adminRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("new role ");
        if(roleRepository.count()==0)
        {
            System.out.println("new role generated");
            Role role1=new Role();
            Role role2=new Role();
            Role role3=new Role();
            role1.setAuthority("ROLE_CUSTOMER");
            role2.setAuthority("ROLE_ADMIN");
            role3.setAuthority("ROLE_SELLER");
            roleRepository.save(role1);
            roleRepository.save(role2);
            roleRepository.save(role3);
        }
        if(adminRepository.count()<1){

            PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


            Admin admin = new Admin();
            admin.setFirstName("pawan");

            admin.setMiddleName("kk");
            admin.setLastName("Gupta");
            admin.setEmailId("akash@gmail.com");
            admin.setIsActive(true);
            admin.setIsDelete(false);
            //admin.setPassword("Pass@134");
            admin.setContactnumber("9953781231");
            Address address=new Address();
            address.setHouseNumber("545B");
            address.setArea("Najafgarh");
            address.setState("delhi");
            address.setCity("new delhi");
            address.setPinCode(123546l);
            address.setLandmark("near hosptial");
            address.setAddressType("Home");
            address.setCountry("India");
            admin.setAddress(address);
            admin.setPassword(passwordEncoder.encode("Pawan@1234"));

            Set<Role> roles=new HashSet<>();
//            System.out.println(">>>>"+roleRepository.findByAuthority("ROLE_ADMIN").get(1));
//         Role role =roleRepository.findByAuthority("ROLE_ADMIN").get(0);
//System.out.println(role);
            Role role=new Role();
            role.setAuthority("ROLE_ADMIN");
            roles.add(role);
            admin.setRoles(roles);
            adminRepository.save(admin);

        }
    }
}

