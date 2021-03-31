package com.project.ecommerce.projectEcommerce.Dto;

import javax.validation.constraints.NotNull;

public class AllProductVariationResponseDTO {

    private Long productVariationId;

    private Long productId;

    private String metadata;

    private String primaryImageName;

    private Integer quantityAvailable;

    private Float price;

    public AllProductVariationResponseDTO() {
    }

    public AllProductVariationResponseDTO(Long productVariationId, Long productId, String metadata, String primaryImageName, Integer quantityAvailable, Float price) {
        this.productVariationId = productVariationId;
        this.productId = productId;
        this.metadata = metadata;
        this.primaryImageName = primaryImageName;
        this.quantityAvailable = quantityAvailable;
        this.price = price;
    }

    public AllProductVariationResponseDTO(Long productVariationId, String metadata, Float price, Integer quantityAvailable, Long productId, String primaryImageName) {
    }

    public Long getProductVariationId() {
        return productVariationId;
    }

    public void setProductVariationId(Long productVariationId) {
        this.productVariationId = productVariationId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getMetadata() {
        return metadata;
    }

    public void setMetadata(String metadata) {
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
}
