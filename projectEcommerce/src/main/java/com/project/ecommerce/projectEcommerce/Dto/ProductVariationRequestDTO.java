package com.project.ecommerce.projectEcommerce.Dto;




import net.minidev.json.JSONArray;

import javax.validation.constraints.NotNull;

public class ProductVariationRequestDTO {

    @NotNull
    private Long productId;

    @NotNull
    private Long categoryId;

    @NotNull
    private JSONArray metadataValues;

    @NotNull
    private String metadata;

    @NotNull
    private String primaryImageName;

    @NotNull
    private Integer quantityAvailable = 0;

    @NotNull
    private Float price = 0.0f;

    public ProductVariationRequestDTO() {
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

    @Override
    public String toString() {
        return "ProductVariationRequestDTO{" +
                "productId=" + productId +
                ", categoryId=" + categoryId +
                ", metadataValues=" + metadataValues +
                ", metadata='" + metadata + '\'' +
                ", primaryImageName='" + primaryImageName + '\'' +
                ", quantityAvailable=" + quantityAvailable +
                ", price=" + price +
                '}';
    }

    public JSONArray getMetadataValues() {
        return metadataValues;
    }

    public void setMetadataValues(JSONArray metadataValues) {
        this.metadataValues = metadataValues;
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
