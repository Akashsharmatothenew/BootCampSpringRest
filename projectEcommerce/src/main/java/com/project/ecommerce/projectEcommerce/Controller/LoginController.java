package com.project.ecommerce.projectEcommerce.Controller;


import com.project.ecommerce.projectEcommerce.Service.UserService;
import com.project.ecommerce.projectEcommerce.entities.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.endpoint.TokenEndpoint;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class LoginController {

    @Autowired
    TokenStore tokenStore;

    @Autowired
    UserService userService;


    @PostMapping("/doLogout")
    public String logout(@RequestParam String token) {

        OAuth2AccessToken accessToken = tokenStore.readAccessToken(token);
        tokenStore.removeAccessToken(accessToken);

        return "Logged out successfully";
    }

    @GetMapping("/user/role")
    public ResponseEntity<Object> getRole(@RequestParam String username){
        List<Role> roleList = new ArrayList<>();
        roleList = userService.getRole(username);
        if(roleList==null){
            return new ResponseEntity<>("no user found", HttpStatus.BAD_REQUEST);
        } else return new ResponseEntity<>(roleList,HttpStatus.OK);
    }

}