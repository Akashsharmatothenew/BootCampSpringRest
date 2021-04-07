package com.project.ecommerce.projectEcommerce.Controller;


import com.project.ecommerce.projectEcommerce.Repository.CategoryRepository;
import com.project.ecommerce.projectEcommerce.Repository.ProductVariationRepository;
import com.project.ecommerce.projectEcommerce.Service.CategoryService;
import com.project.ecommerce.projectEcommerce.dto.*;
import com.project.ecommerce.projectEcommerce.entities.Category;
import com.project.ecommerce.projectEcommerce.exception.CategoryNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    CategoryService categoryService;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ProductVariationRepository productVariationRepository;

    @PostMapping("/admin/add/category")
    public ResponseEntity<String> addCategory(@Valid @RequestParam String name, @RequestParam(required = false) Long parent_id) {
        if (categoryService.addCategory(name, parent_id))
            return new ResponseEntity<String>("Category is added to the database for use", HttpStatus.OK);
        else
            return new ResponseEntity<String>("Category is not added to the database for use", HttpStatus.NOT_ACCEPTABLE);
    }


    @GetMapping("/admin/view/category")
    public CategoryResponseDTO viewCategory(@RequestParam Long category_id) {
        return categoryService.viewCategory(category_id);
    }


    @GetMapping("/admin/all/categories")
    public Page<CategoryResponseDTO> allCategories(Pageable pageable) {
        return categoryService.allCategories(pageable);
    }


    @PatchMapping("/admin/update/category")
    public ResponseEntity<String> updateCategory(@RequestParam Long category_id, @RequestParam String name) {
        if (categoryService.updateCategory(category_id, name))
            return new ResponseEntity<String>("Category is updated to the database", HttpStatus.OK);
        else
            return new ResponseEntity<String>("Category is not updated to the database", HttpStatus.EXPECTATION_FAILED);
    }


    @PostMapping("/admin/add/metadata")
    public ResponseEntity<String> addMetadata(@Valid @RequestParam String fieldName) {
        if (categoryService.addMetadata(fieldName))
            return new ResponseEntity<String>("Category Metadata Field is added to the database", HttpStatus.OK);
        else
            return new ResponseEntity<String>("Category Metadata Field is not added to the database", HttpStatus.BAD_REQUEST);
    }


    @GetMapping("/admin/view/metadata")
    public Page<CategoryMetadataFieldResponseDTO> viewMetadataField(Pageable pageable) {
        return categoryService.viewMetadataField(pageable);
    }


    @PostMapping("/admin/add/metadatavalue")
    public ResponseEntity<String> addMetadataFieldValue(@RequestBody CategoryMetadataFieldValueRequestDTO categoryMetadataFieldValueRequestDTO) {
        if (categoryService.addMetadataFieldValue(categoryMetadataFieldValueRequestDTO))
            return new ResponseEntity<String>("Category Metadata Field value is added to the database", HttpStatus.OK);
        else
            return new ResponseEntity<String>("Category Metadata Field value is not added to the database", HttpStatus.EXPECTATION_FAILED);
    }


    @PutMapping("/admin/update/metadatavalue")
    public ResponseEntity<String> updateMetadataFieldValue(@RequestBody CategoryMetadataFieldValueRequestDTO categoryMetadataFieldValueRequestDTO) {
        if (categoryService.updateMetadataFieldValue(categoryMetadataFieldValueRequestDTO))
            return new ResponseEntity<String>("Category Metadata Field value is updated to the database", HttpStatus.OK);
        else
            return new ResponseEntity<String>("Category Metadata Field value is not updated to the database", HttpStatus.EXPECTATION_FAILED);
    }


    @GetMapping("/seller/all/categories")
    public List<CategoryResponseDTO> sellerListCategories() {
        return categoryService.sellerListCategories();
    }


    @GetMapping("customer/all/categories")
    public List<CustomerCategoryResponseDTO> customerAllCategories(@RequestParam(required = false) Long categoryId, Pageable pageable) {
        return categoryService.customerAllCategories(categoryId, pageable);
    }


    @GetMapping("/customer/filter/category")
    public CustomerFilterCategoryResponseDTO customerFilterCategory(@RequestParam Long categoryId) {
        Category category = categoryRepository.findById(categoryId).orElse(null);
        if (category == null) {
            throw new CategoryNotFoundException("There is no category with the given id");
        } else {
            CustomerFilterCategoryResponseDTO customerFilterCategoryResponseDTO = modelMapper.map(category, CustomerFilterCategoryResponseDTO.class);
            List<String> brandList = categoryRepository.fetchBrandList(categoryId);
            Float minPrice = productVariationRepository.getMinPrice(categoryId);
            Float maxPrice = productVariationRepository.getMaxPrice(categoryId);
            customerFilterCategoryResponseDTO.setMinPrice(minPrice);
            customerFilterCategoryResponseDTO.setMaxPrice(maxPrice);
            customerFilterCategoryResponseDTO.setBrands(brandList);
            List<Object> metadata = productVariationRepository.fetchMetadata();
            System.out.println(metadata);
            return customerFilterCategoryResponseDTO;
        }
    }


}
