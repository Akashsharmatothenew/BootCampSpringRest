package com.project.ecommerce.projectEcommerce.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ttn on 24/3/21.
 */
@RestController
public class UserController {
    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/admin/home")
    public String adminHome(){
        return "Admin home";
    }

    @GetMapping("/user/home")
    public String userHome(){
        return "User home";
    }

}
