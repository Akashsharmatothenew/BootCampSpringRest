package com.project.ecommerce.projectEcommerce.Controller;


import com.project.ecommerce.projectEcommerce.Service.CustomerService;
import com.project.ecommerce.projectEcommerce.Service.UserService;
import com.project.ecommerce.projectEcommerce.dto.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import java.security.Principal;
import java.util.HashSet;
import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @Autowired
    UserService userService;


    @GetMapping("/customer/profile")
    public CustomerProfileResponseDTO viewProfile(Principal principal) {
        return customerService.viewProfile(principal);
    }


    @PatchMapping("/customer/update/profile")
    public ResponseEntity<String> updateProfile(Principal principal, @Valid @RequestBody UpdateProfileDTO updateProfileDTO) {
        String username = principal.getName();
        if (customerService.updateProfile(username, updateProfileDTO))
            return new ResponseEntity("Profile is updated", HttpStatus.OK);
        else
            return new ResponseEntity("Sorry...Profile is not updated", HttpStatus.EXPECTATION_FAILED);
    }


    @PatchMapping("/customer/update/password")
    public ResponseEntity<String> updatePassword(Principal principal, @Valid @RequestBody PasswordUpdateDTO passwordUpdateDTO) {
        String username = principal.getName();
        if (userService.updatePassword(username, passwordUpdateDTO))
            return new ResponseEntity("Password is updated", HttpStatus.OK);
        else
            return new ResponseEntity("Sorry...Password is not updated", HttpStatus.EXPECTATION_FAILED);
    }


    @PostMapping("/customer/add/address")
    public ResponseEntity<String> addAddress(Principal principal, @Valid @RequestBody AddressDTO addressDTO) {
        String username = principal.getName();
        if (customerService.addAddress(username, addressDTO)) {
            return new ResponseEntity<String>("The address is added for the buyer", HttpStatus.OK);
        } else
            return new ResponseEntity<String>("The address is not added for the given id", HttpStatus.BAD_REQUEST);
    }


    @DeleteMapping("/customer/delete/address")
    public ResponseEntity<String> deleteAddress(@Valid @RequestParam Long address_id) {
        if (customerService.deleteAddress(address_id)) {
            return new ResponseEntity<String>("The address is deleted for the given id", HttpStatus.OK);
        } else
            return new ResponseEntity<String>("The address is not deleted for the given id", HttpStatus.EXPECTATION_FAILED);
    }


    @GetMapping("customer/address")
    public List<AddressResponseDTO> addressProfile(Principal principal) {
        String username = principal.getName();
        return customerService.getAddressList(username);
    }


    @PostMapping("/customer/update/address")
    public ResponseEntity<String> updateAddress(@Valid @RequestParam Long id, @RequestBody AddressUpdateDTO addressUpdateDTO) {
        if (userService.updateAddress(id, addressUpdateDTO)) {
            return new ResponseEntity<String>("The address is updated for the given id", HttpStatus.OK);
        } else
            return new ResponseEntity<String>("The address is not updated for the given id", HttpStatus.EXPECTATION_FAILED);
    }
}
