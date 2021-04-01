package com.project.ecommerce.projectEcommerce.dto;

import javax.validation.constraints.NotNull;

public class ProductVariationResponseDTO {

    @NotNull
    private Long productVariationId;

    @NotNull
    private Object metadata;

    @NotNull
    private String primaryImageName;

    @NotNull
    private Integer quantityAvailable;

    @NotNull
    private Float price;

    private ProductResponseDTO parentProduct;

    public ProductVariationResponseDTO() {
    }

    public Long getProductVariationId() {
        return productVariationId;
    }

    public void setProductVariationId(Long productVariationId) {
        this.productVariationId = productVariationId;
    }

    public Object getMetadata() {
        return metadata;
    }

    public void setMetadata(Object metadata) {
        this.metadata = metadata;
    }

    public String getPrimaryImageName() {
        return primaryImageName;
    }

    public void setPrimaryImageName(String primaryImageName) {
        this.primaryImageName = primaryImageName;
    }

    public Integer getQuantityAvailable() {
        return quantityAvailable;
    }

    public void setQuantityAvailable(Integer quantityAvailable) {
        this.quantityAvailable = quantityAvailable;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public ProductResponseDTO getParentProduct() {
        return parentProduct;
    }

    public void setParentProduct(ProductResponseDTO parentProduct) {
        this.parentProduct = parentProduct;
    }

}
