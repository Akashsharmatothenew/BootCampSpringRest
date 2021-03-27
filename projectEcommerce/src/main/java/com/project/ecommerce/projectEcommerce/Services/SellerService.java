package com.project.ecommerce.projectEcommerce.Services;

import com.project.ecommerce.projectEcommerce.Entity.Users.User;
import com.project.ecommerce.projectEcommerce.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ttn on 27/3/21.
 */
@Service
public class SellerService {
    @Autowired
    SellerService sellerService;


    public List<User> getSellerEamilId(String email){
        return sellerService.getSellerEamilId(email);
    }
}
