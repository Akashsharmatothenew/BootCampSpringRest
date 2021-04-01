package com.project.ecommerce.projectEcommerce.dto;


import java.util.List;

public class CategoryMetadataFieldValueRequestDTO {

    private Long categoryId;

    private Long[] metadataFieldId;

    private List<String>[] metadataValues;

    public CategoryMetadataFieldValueRequestDTO() {
    }

    public Integer countArray() {
        return metadataFieldId.length;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getMetadataFieldId(int i) {
        return metadataFieldId[i];
    }

    public void setMetadataFieldId(Long[] metadataFieldId) {
        this.metadataFieldId = metadataFieldId;
    }

    public List<String> getMetadataValues(int j) {
        return metadataValues[j];
    }

    public void setMetadataValues(List<String>[] metadataValues) {
        this.metadataValues = metadataValues;
    }

    public String convertToString(List<String> values) {
        String metadataValues = String.join(", ", values);
        return metadataValues;
    }

}
