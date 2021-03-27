package com.project.ecommerce.projectEcommerce.Services;

import com.project.ecommerce.projectEcommerce.Entity.Users.User;
import com.project.ecommerce.projectEcommerce.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ttn on 26/3/21.
 */
@Service
public class UserService {

    @Autowired
    UserRepository userRepository;


    public List<User> getUserEamilId(String email){
        return userRepository.findByEmailId(email);
    }
    public List<User> getUser(){
        return userRepository.findAllBy();
    }

}
