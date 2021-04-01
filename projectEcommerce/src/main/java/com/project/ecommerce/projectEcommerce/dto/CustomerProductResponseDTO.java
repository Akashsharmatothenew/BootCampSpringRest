package com.project.ecommerce.projectEcommerce.dto;



import com.project.ecommerce.projectEcommerce.entities.Category;
import com.project.ecommerce.projectEcommerce.entities.ProductVariation;

import javax.validation.constraints.NotNull;
import java.util.Set;

public class CustomerProductResponseDTO {

    private Long productId;

    private String name;

    private String description;

    private Boolean cancellable;

    private Boolean active;

    private Boolean returnable;

    private String brand;

    private Category category;

    private Set<ProductVariation> productVariation;

    public CustomerProductResponseDTO() {
    }

    public CustomerProductResponseDTO(Long productId, String name, String description, Boolean cancellable, Boolean active, Boolean returnable, String brand, Category category, Set<ProductVariation> productVariation) {
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.cancellable = cancellable;
        this.active = active;
        this.returnable = returnable;
        this.brand = brand;
        this.category = category;
        this.productVariation = productVariation;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getCancellable() {
        return cancellable;
    }

    public void setCancellable(Boolean cancellable) {
        this.cancellable = cancellable;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Boolean getReturnable() {
        return returnable;
    }

    public void setReturnable(Boolean returnable) {
        this.returnable = returnable;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Set<ProductVariation> getProductVariation() {
        return productVariation;
    }

    public void setProductVariation(Set<ProductVariation> productVariation) {
        this.productVariation = productVariation;
    }
}
