package com.project.ecommerce.projectEcommerce.Dto;

import javax.validation.constraints.NotNull;

public class ProductUpdateRequestDTO {

    @NotNull
    private Long productId;

    @NotNull
    private String name;

    @NotNull
    private String description;

    @NotNull
    private Boolean cancellable;

    @NotNull
    private Boolean returnable;

    public ProductUpdateRequestDTO() {
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

    public Boolean getIsCancellable() {
        return cancellable;
    }

    public void setIsCancellable(Boolean cancellable) {
        this.cancellable = cancellable;
    }

    public Boolean getIsReturnable() {
        return returnable;
    }

    public void setIsReturnable(Boolean returnable) {
        this.returnable = returnable;
    }
}
