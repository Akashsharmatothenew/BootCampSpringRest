package com.project.ecommerce.projectEcommerce.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.project.ecommerce.projectEcommerce.embeddableclasses.CategoryMetadataCategory;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="fieldId")
public class CategoryMetadataFieldValue implements Serializable {

    @NotNull
    @Column(name = "is_deleted")
    private Boolean deleted=false;

    @EmbeddedId
    CategoryMetadataCategory fieldId;

    @JsonIgnore
    @MapsId("categoryCategoryId")
    @ManyToOne
    @JoinColumn(name = "category_id")
    Category category;

    @MapsId("categoryMetadataFieldCategoryId")
    @ManyToOne
    @JoinColumn(name = "category_metadata_field_id")
    CategoryMetadataField categoryMetadataField;

    @Convert(converter = StringListConverter.class)
    List<String> metadataValues = new ArrayList<String>();

    public CategoryMetadataFieldValue() {
    }

    public CategoryMetadataFieldValue(Category category, CategoryMetadataField categoryMetadataField) {
        this.fieldId = new CategoryMetadataCategory(category.getCategoryId(),categoryMetadataField.getCategoryMetadataFieldId());
        this.category = category;
        this.categoryMetadataField = categoryMetadataField;
    }

    public CategoryMetadataCategory getFieldId() {
        return fieldId;
    }

    public void setFieldId(CategoryMetadataCategory fieldId) {
        this.fieldId = fieldId;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public CategoryMetadataField getCategoryMetadataField() {
        return categoryMetadataField;
    }

    public void setCategoryMetadataField(CategoryMetadataField categoryMetadataField) {
        this.categoryMetadataField = categoryMetadataField;
    }

    public List<String> getMetadataValues() {
        return metadataValues;
    }

    public void setMetadataValues(List<String> metadataValues) {
        this.metadataValues = metadataValues;
    }

    public Boolean getIsDeleted() {
        return deleted;
    }

    public void setIsDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}