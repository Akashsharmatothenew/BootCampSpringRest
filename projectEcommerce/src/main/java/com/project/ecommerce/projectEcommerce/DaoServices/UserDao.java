package com.project.ecommerce.projectEcommerce.DaoServices;

import com.project.ecommerce.projectEcommerce.UserDetails.AppUers;
import com.project.ecommerce.projectEcommerce.UserDetails.GrantAuthorityImpl;
import com.project.ecommerce.projectEcommerce.Entity.Users.User;
import com.project.ecommerce.projectEcommerce.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.stream.Collectors;

/**
 * Created by ttn on 24/3/21.
 */
@Repository
public class UserDao {
    @Autowired
    UserRepository userRepository;
    public AppUers loadUserByUsername(String username){
        User user = userRepository.findByEmailId(username).get(0);//check exception
        System.out.println(user);
        if(username!=null){
            return new AppUers(user.getEmailId(),user.getPassword(),
                    user.getRoles().stream().
                            map(role->new GrantAuthorityImpl(role.getAuthority())).
                            collect(Collectors.toList()));
        }else {
            throw new RuntimeException();
        }
    }
}
