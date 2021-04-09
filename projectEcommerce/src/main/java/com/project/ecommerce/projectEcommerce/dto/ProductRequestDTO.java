package com.project.ecommerce.projectEcommerce.dto;



import com.project.ecommerce.projectEcommerce.entities.Seller;

import javax.validation.constraints.NotNull;

public class ProductRequestDTO {

    @NotNull
    private String name;

    private String description;

    @NotNull
    private Long categoryId;


    private Boolean cancellable = false;

    private Boolean returnable = false;

    @NotNull
    private String brand;

    private Seller seller;

    public ProductRequestDTO() {
    }

    public ProductRequestDTO(@NotNull String name, String description, @NotNull Long categoryId, Boolean cancellable, Boolean returnable, @NotNull String brand, Seller seller) {
        this.name = name;
        this.description = description;
        this.categoryId = categoryId;
        this.cancellable = cancellable;
        this.returnable = returnable;
        this.brand = brand;
        this.seller = seller;
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

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }
}
