package com.project.ecommerce.projectEcommerce.Dto;



import com.project.ecommerce.projectEcommerce.Entity.Catagories.CategoryMetadataFieldValue;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;

public class CustomerFilterCategoryResponseDTO {

    private Long categoryId;

    private String name;

    private Set<CategoryMetadataFieldValue> categoryMetadataFieldValue;

    private List<String> brands;

    private Float maxPrice;

    private Float minPrice;

    public CustomerFilterCategoryResponseDTO() {
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

    public Set<CategoryMetadataFieldValue> getCategoryMetadataFieldValue() {
        return categoryMetadataFieldValue;
    }

    public void setCategoryMetadataFieldValue(Set<CategoryMetadataFieldValue> categoryMetadataFieldValue) {
        this.categoryMetadataFieldValue = categoryMetadataFieldValue;
    }

    public List<String> getBrands() {
        return brands;
    }

    public void setBrands(List<String> brands) {
        this.brands = brands;
    }

    public Float getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(Float maxPrice) {
        this.maxPrice = maxPrice;
    }

    public Float getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(Float minPrice) {
        this.minPrice = minPrice;
    }
}
