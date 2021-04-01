package com.project.ecommerce.projectEcommerce.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.ecommerce.projectEcommerce.entities.Category;
import com.project.ecommerce.projectEcommerce.entities.CategoryMetadataFieldValue;


import java.util.List;
import java.util.Set;

public class CategoryResponseDTO {

    private Long categoryId;

    private String name;

    @JsonIgnore
    private Set<CategoryResponseDTO> childCategory;

    private List<Category> nextCategory;

    private CategoryResponseDTO parentCategory;

    private Set<CategoryMetadataFieldValue> categoryMetadataFieldValue;

    public CategoryResponseDTO() {
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

    public Set<CategoryResponseDTO> getChildCategory() {
        return childCategory;
    }

    public void setChildCategory(Set<CategoryResponseDTO> childCategory) {
        this.childCategory = childCategory;
    }

    public List<Category> getNextCategory() {
        return nextCategory;
    }

    public void setNextCategory(List<Category> nextCategory) {
        this.nextCategory = nextCategory;
    }

    public CategoryResponseDTO getParentCategory() {
        return parentCategory;
    }

    public void setParentCategory(CategoryResponseDTO parentCategory) {
        this.parentCategory = parentCategory;
    }

    public Set<CategoryMetadataFieldValue> getCategoryMetadataFieldValue() {
        return categoryMetadataFieldValue;
    }

    public void setCategoryMetadataFieldValue(Set<CategoryMetadataFieldValue> categoryMetadataFieldValue) {
        this.categoryMetadataFieldValue = categoryMetadataFieldValue;
    }
}
