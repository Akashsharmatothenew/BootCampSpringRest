package com.project.ecommerce.projectEcommerce.Controller;


import com.project.ecommerce.projectEcommerce.Service.UserService;
import com.project.ecommerce.projectEcommerce.dto.ResetPasswordDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
public class ForgotPasswordController {

    @Autowired
    UserService userService;


    @PostMapping("/receive/token")
    public ResponseEntity<String> receiveTokenBasedUrl(@Valid @RequestParam String email, HttpServletRequest request) {
        if (userService.receiveToken(email, request)) {
            return new ResponseEntity<String>("Token is sent for reset password", HttpStatus.OK);
        } else
            return new ResponseEntity<>("Token is not sent for reset Password", HttpStatus.BAD_REQUEST);
    }


    @PutMapping("/reset/password")
    public ResponseEntity<String> resetPassword(@RequestBody ResetPasswordDTO resetPasswordDTO) {
        if (userService.resetPassword(resetPasswordDTO)) {
            return new ResponseEntity<>("Password has been changed", HttpStatus.OK);
        } else
            return new ResponseEntity<>("Password has been not changed", HttpStatus.BAD_REQUEST);
    }
}
