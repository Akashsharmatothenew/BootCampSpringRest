package com.project.ecommerce.projectEcommerce.Controller;


import com.project.ecommerce.projectEcommerce.Service.CustomerService;
import com.project.ecommerce.projectEcommerce.Service.SellerService;
import com.project.ecommerce.projectEcommerce.Service.UserService;
import com.project.ecommerce.projectEcommerce.dto.CustomerResponseDTO;
import com.project.ecommerce.projectEcommerce.dto.SellerResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class AdminController {

    @Autowired
    SellerService sellerService;

    @Autowired
    CustomerService customerService;

    @Autowired
    UserService userService;

    @GetMapping("/admin/customers")
    public Page<CustomerResponseDTO> findAllCustomers(Pageable pageable) {
        return customerService.pagingCustomer(pageable);
    }


    @GetMapping("/admin/sellers")
    public Page<SellerResponseDTO> findAllSellers(Pageable pageable) {
        PageImpl<SellerResponseDTO> sellerResponseDTOS = sellerService.pagingSeller(pageable);
        return sellerResponseDTOS;
    }


    @PatchMapping("/admin/activate/customer")
    public ResponseEntity<String> activateCustomer(@RequestParam Long id) {
        if (userService.activate(id)) {
            return new ResponseEntity<>("Customer is activated with it's required id", HttpStatus.OK);
        } else
            return new ResponseEntity<>("Customer is already activated with the id used", HttpStatus.BAD_REQUEST);
    }

    @PatchMapping("/admin/deactivate/customer")
    public ResponseEntity<String> deactivateCustomer(@RequestParam Long id) {
        if (userService.deactivate(id)) {
            return new ResponseEntity<>("Customer is de-activated ", HttpStatus.OK);
        } else
            return new ResponseEntity<>("Customer is already de-activated", HttpStatus.BAD_REQUEST);
    }

    @PatchMapping("/admin/activate/seller")
    public ResponseEntity<String> activateSeller(@RequestParam Long id) {
        if (userService.activate(id))
            return new ResponseEntity<>("Seller is activated with it's required id", HttpStatus.OK);
        else
            return new ResponseEntity<>("Seller is already activated with the id used", HttpStatus.BAD_REQUEST);
    }

    @PatchMapping("/admin/deactivate/seller")
    public ResponseEntity<String> deactivateSeller(@RequestParam Long id) {
        if (userService.deactivate(id))
            return new ResponseEntity<>("Seller is de-activated ", HttpStatus.OK);
        else
            return new ResponseEntity<>("Seller is already de-activated", HttpStatus.BAD_REQUEST);
    }
}






