package com.project.ecommerce.projectEcommerce.dto;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

public class CategoryMetadataFieldResponseDTO {


    private Long categoryMetadataFieldId;

    @NotNull
    @Column(unique = true)
    private String name;

    public CategoryMetadataFieldResponseDTO() {
    }

    public CategoryMetadataFieldResponseDTO(Long categoryMetadataFieldId, String name) {
        this.categoryMetadataFieldId = categoryMetadataFieldId;
        this.name = name;
    }

    public Long getCategoryMetadataFieldId() {
        return categoryMetadataFieldId;
    }

    public void setCategoryMetadataFieldId(Long categoryMetadataFieldId) {
        this.categoryMetadataFieldId = categoryMetadataFieldId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
