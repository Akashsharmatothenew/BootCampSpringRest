package com.project.ecommerce.projectEcommerce.Dto;



import com.project.ecommerce.projectEcommerce.Entity.Catagories.Category;
import com.project.ecommerce.projectEcommerce.Entity.Users.Seller;

import javax.validation.constraints.NotNull;

public class ProductPagingResponseDTO {

    private String name;
    private Long productId;
    private Long categoryId;
    private String categoryName;
    private String description;
    private String brand;
    private Long sellerUserId;
    private Boolean cancellable = false;

    private Boolean returnable = false;


    public ProductPagingResponseDTO(String name, Long productId, Category category, String description, String brand, Seller seller, Category category1) {

        this.name=name;
        this.productId=productId;
        this.categoryId =category.getCategoryId();
        this.description=description;
        this.brand=brand;
        this.categoryName=category.getName();
        this.sellerUserId=seller.getId();

    }

    public ProductPagingResponseDTO() {
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Long getSellerUserId() {
        return sellerUserId;
    }

    public void setSellerUserId(Long sellerUserId) {
        this.sellerUserId = sellerUserId;
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
}
