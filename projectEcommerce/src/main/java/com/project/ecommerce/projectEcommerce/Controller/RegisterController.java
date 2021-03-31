package com.project.ecommerce.projectEcommerce.Controller;


import com.project.ecommerce.projectEcommerce.Dto.CustomerRegisterDTO;
import com.project.ecommerce.projectEcommerce.Dto.SellerRegisterDTO;
import com.project.ecommerce.projectEcommerce.Services.CustomerService;
import com.project.ecommerce.projectEcommerce.Services.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
public class RegisterController {

    @Autowired
    private MessageSource messageSource;

    @Autowired
    SellerService sellerService;

    @Autowired
    CustomerService customerService;

    @GetMapping("/welcome")
    public String helloWorldBeanInternationalized() {
        return messageSource.getMessage("hello.message", null, LocaleContextHolder.getLocale());
    }

    @PostMapping("/register/seller")
    public ResponseEntity<String> registerSeller(@Valid @RequestBody SellerRegisterDTO sellerRegisterDto, HttpServletRequest request) {

        if (sellerService.registerSeller(sellerRegisterDto)) {
            return new ResponseEntity<>("Seller is registered", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Seller is  not registered", HttpStatus.BAD_REQUEST);
        }

    }

    @PostMapping("/register/customer")
    public ResponseEntity<String> registerCustomer(@Valid @RequestBody CustomerRegisterDTO customerRegisterDTO, HttpServletRequest request) {

        if (customerService.registerCustomer(customerRegisterDTO, request)) {
            return new ResponseEntity<>("Customer is registered", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Customer is  not registered", HttpStatus.BAD_REQUEST);
        }

    }

    @PutMapping("/confirm/customer")
    public ResponseEntity<String> confirmToken(@Valid @RequestParam String token, HttpServletRequest request) {

        if (customerService.confirmToken(token, request)) {
            return new ResponseEntity<>("Customer is  confirmed", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Customer is  not confirmed", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/reactivate/link/customer")
    public ResponseEntity<String> reactivateTokenForCustomer(@Valid @RequestParam String email, HttpServletRequest request) {
        if (customerService.reactivateToken(email, request)) {
            return new ResponseEntity<>("Reactivation link is sent", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Reactivation link is not sent", HttpStatus.BAD_REQUEST);
        }
    }
}
