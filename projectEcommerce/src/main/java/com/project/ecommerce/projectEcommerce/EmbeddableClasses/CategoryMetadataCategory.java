package com.project.ecommerce.projectEcommerce.EmbeddableClasses;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by ttn on 30/3/21.
 */
@Embeddable
public class CategoryMetadataCategory implements Serializable{
    private Long categoryCategoryId;
    private Long categoryMetadataFieldCategoryId;

    public CategoryMetadataCategory() {
    }

    public Long getCategoryCategoryId() {
        return categoryCategoryId;
    }

    public void setCategoryCategoryId(Long categoryCategoryId) {
        this.categoryCategoryId = categoryCategoryId;
    }

    public Long getCategoryMetadataFieldCategoryId() {
        return categoryMetadataFieldCategoryId;
    }

    public void setCategoryMetadataFieldCategoryId(Long categoryMetadataFieldCategoryId) {
        this.categoryMetadataFieldCategoryId = categoryMetadataFieldCategoryId;
    }

    @Override
    public String toString() {
        return "CategoryMetadataCategory{" +
                "categoryCategoryId=" + categoryCategoryId +
                ", categoryMetadataFieldCategoryId=" + categoryMetadataFieldCategoryId +
                '}';
    }
}
