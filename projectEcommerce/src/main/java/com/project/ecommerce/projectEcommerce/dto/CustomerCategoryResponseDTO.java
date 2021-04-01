package com.project.ecommerce.projectEcommerce.dto;


import com.project.ecommerce.projectEcommerce.entities.CategoryMetadataFieldValue;
import org.codehaus.jackson.annotate.JsonIgnore;

import javax.validation.constraints.NotNull;
import java.util.Set;
public class CustomerCategoryResponseDTO {

    private Long categoryId;
    private String name;

    private Set<CustomerCategoryResponseDTO> childCategory;
    private Set<CategoryMetadataFieldValue> categoryMetadataFieldValue;
    @JsonIgnore
    private CategoryResponseDTO parentCategory;

    public CustomerCategoryResponseDTO()
    {
    }

    public CategoryResponseDTO getParentCategory() {
        return parentCategory;
    }

    public void setParentCategory(CategoryResponseDTO parentcategory) {
        this.parentCategory = parentcategory;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<CustomerCategoryResponseDTO> getChildCategory() {
        return childCategory;
    }

    public void setChildCategory(Set<CustomerCategoryResponseDTO> childCategory) {
        this.childCategory = childCategory;
    }

    public Set<CategoryMetadataFieldValue> getCategoryMetadataFieldValue() {
        return categoryMetadataFieldValue;
    }

    public void setCategoryMetadataFieldValue(Set<CategoryMetadataFieldValue> categoryMetadataFieldValue) {
        this.categoryMetadataFieldValue = categoryMetadataFieldValue;
    }
}


