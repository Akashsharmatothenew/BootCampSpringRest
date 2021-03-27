package com.project.ecommerce.projectEcommerce.Controller;

import com.project.ecommerce.projectEcommerce.Entity.Users.User;
import com.project.ecommerce.projectEcommerce.Services.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by ttn on 27/3/21.
 */
@RestController
public class SellerController {
    @Autowired
    SellerService sellerService;
    @GetMapping("/seller/home/{email}")
    public List<User> getSellerEamilId(@PathVariable String email){
        return sellerService.getSellerEamilId(email);
    }
}
