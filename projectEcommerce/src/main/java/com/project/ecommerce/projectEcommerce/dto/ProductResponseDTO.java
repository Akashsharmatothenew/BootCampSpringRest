package com.project.ecommerce.projectEcommerce.dto;


import javax.validation.constraints.NotNull;

public class ProductResponseDTO {

    @NotNull
    private Long productId;

    @NotNull
    private String name;

    @NotNull
    private String description;

    @NotNull
    private Long categoryId;

    @NotNull
    private Boolean cancellable;

    @NotNull
    private Boolean active;

    @NotNull
    private Boolean returnable;

    @NotNull
    private String brand;

    public ProductResponseDTO() {
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

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Boolean getIsActive() {
        return active;
    }

    public void setIsActive(Boolean active) {
        this.active = active;
    }

    public Boolean getCancellable() {
        return cancellable;
    }

    public void setCancellable(Boolean cancellable) {
        this.cancellable = cancellable;
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
}
