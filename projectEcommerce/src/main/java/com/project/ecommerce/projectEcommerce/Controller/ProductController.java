package com.project.ecommerce.projectEcommerce.Controller;


import com.fasterxml.jackson.core.io.JsonEOFException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.ecommerce.projectEcommerce.Service.ProductService;
import com.project.ecommerce.projectEcommerce.dto.*;
import com.project.ecommerce.projectEcommerce.exception.MetadataFieldValueNotFoundException;
import com.project.ecommerce.projectEcommerce.exception.ProductVariationNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.security.Principal;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/seller/add/product")
    public ResponseEntity<String> addProduct(Principal principal, @Valid @RequestBody ProductRequestDTO productRequestDTO) {
        if (productService.addProduct(principal, productRequestDTO))
            return new ResponseEntity<String>("Product is added to the database", HttpStatus.OK);
        else
            return new ResponseEntity<String>("Product is not added to the database", HttpStatus.EXPECTATION_FAILED);
    }


    @GetMapping("/seller/view/product")///changes in this
    public ProductResponseDTO viewProduct(Principal principal, @RequestParam Long productId) {
        ProductResponseDTO productResponseDTO = productService.viewProduct(principal, productId);
        return productResponseDTO;
    }


    @GetMapping("/seller/view/all/products")
    public Page<ProductPagingResponseDTO> viewAllProducts(Principal principal, Pageable pageable) {
        return productService.viewAllProduct(principal, pageable);
    }


    @DeleteMapping("/seller/delete/product")
    public ResponseEntity<String> deleteProduct(Principal principal, @RequestParam Long productId) {
        if (productService.deleteProduct(principal, productId))
            return new ResponseEntity<String>("Product is deleted from the database", HttpStatus.OK);
        else
            return new ResponseEntity<String>("Product is not deleted to the database", HttpStatus.EXPECTATION_FAILED);
    }


    @PutMapping("/seller/update/product")
    public ResponseEntity<String> updateProduct(Principal principal, @RequestBody ProductUpdateRequestDTO productUpdateRequestDTO) {
        if (productService.updateProduct(principal, productUpdateRequestDTO))
            return new ResponseEntity<String>("Product is updated from the database", HttpStatus.OK);
        else
            return new ResponseEntity<String>("Product is not updated to the database", HttpStatus.EXPECTATION_FAILED);
    }


    @PutMapping("/admin/activate/product")
    public ResponseEntity<String> activateProduct(@RequestParam @Valid Long productId) {
        if (productService.activateProduct(productId))
            return new ResponseEntity<String>("Product is activated", HttpStatus.OK);
        else
            return new ResponseEntity<String>("Product is not activated", HttpStatus.EXPECTATION_FAILED);
    }


    @PutMapping("/admin/deactivate/product")
    public ResponseEntity<String> deactivateProduct(@RequestParam @Valid Long productId) {
        if (productService.deactivateProduct(productId))
            return new ResponseEntity<String>("Product is de-activated", HttpStatus.OK);
        else
            return new ResponseEntity<String>("Product is not de-activated", HttpStatus.EXPECTATION_FAILED);
    }


    @PostMapping("/seller/add/product/variation")
    public ResponseEntity<String> addProductVariation(@RequestBody MultipartFile image, Principal principal, String productVariationRequestDTO) throws JsonEOFException, MetadataFieldValueNotFoundException, IOException {
        ProductVariationRequestDTO productVariationRequestDTO1 = new ObjectMapper().readValue(productVariationRequestDTO, ProductVariationRequestDTO.class);
        if (productService.addProductVariation(image, principal, productVariationRequestDTO1))
            return new ResponseEntity<String>("Product Variation is added to product ", HttpStatus.OK);
        else
            return new ResponseEntity<String>("Product Variation is added to product", HttpStatus.EXPECTATION_FAILED);
    }


    @GetMapping("/seller/view/product/variation")//changes in this
    public ProductVariationResponseDTO viewProductVariation(Principal principal, @RequestParam Long productVariationId) throws ProductVariationNotFoundException {
        return productService.viewProductVariation(principal, productVariationId);
    }


    @GetMapping("/seller/view/all/product/variations")
    public Page<AllProductVariationResponseDTO> viewAllProductVariations(Principal principal, @RequestParam Long productId, Pageable pageable) {
        return productService.viewAllProductVariations(principal, productId, pageable);
    }


    @PutMapping("/seller/update/product/variation")
    public ResponseEntity<String> updateProductVariation(@RequestBody MultipartFile image, Principal principal,String updateVariationDTO) throws IOException {
        UpdateVariationDTO updateVariationDTO1=new ObjectMapper().readValue(updateVariationDTO,UpdateVariationDTO.class);
        if(productService.updateProductVariation(principal,updateVariationDTO1))
            return new ResponseEntity<String>("Product Variation is updated ", HttpStatus.OK);
        else
            return new ResponseEntity<String>("Product Variation is not updated", HttpStatus.EXPECTATION_FAILED);
    }


    @GetMapping("/customer/view/product")
    public CustomerProductResponseDTO viewProductCustomer(@RequestParam Long productId) {
        return productService.viewProductCustomer(productId);
    }


    @GetMapping("/customer/view/all/products")//changes but not fully right cant check the product variation set
    public Page<CustomerProductResponseDTO> viewAllProductBuyer(@RequestParam Long categoryId) {
        return productService.viewAllProductCustomer(categoryId);
    }


    @GetMapping("/admin/view/product")
    public CustomerProductResponseDTO viewProductAdmin(@RequestParam Long productId) {
        return productService.viewProductAdmin(productId);
    }


    @GetMapping("/admin/view/all/products")
    public Page<CustomerProductResponseDTO> viewAllProductAdmin(Pageable pageable) {
        return productService.viewAllProductAdmin(pageable);
    }


    @GetMapping("/customer/similar/products")
    public Page<CustomerProductResponseDTO> viewSimilarProductsCustomer(@RequestParam Long productId, Pageable pageable) {
        return productService.viewSimilarProductsCustomer(productId, pageable);
    }

}
