package com.project.ecommerce.projectEcommerce.Entity.Catagories;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.project.ecommerce.projectEcommerce.EmbeddableClasses.CategoryMetadataCategory;
import com.project.ecommerce.projectEcommerce.Entity.StringListConverter;

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
    CategoryMetaDataField categoryMetadataField;

    @Convert(converter = StringListConverter.class)
    List<String> metadataValues = new ArrayList<String>();

    public CategoryMetadataFieldValue() {
    }

    public CategoryMetadataFieldValue(CategoryMetadataCategory fieldId, Category category, CategoryMetaDataField categoryMetadataField) {
        this.fieldId = fieldId;
        this.category = category;
        this.categoryMetadataField = categoryMetadataField;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
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

    public CategoryMetaDataField getCategoryMetadataField() {
        return categoryMetadataField;
    }

    public void setCategoryMetadataField(CategoryMetaDataField categoryMetadataField) {
        this.categoryMetadataField = categoryMetadataField;
    }

    public List<String> getMetadataValues() {
        return metadataValues;
    }

    public void setMetadataValues(List<String> metadataValues) {
        this.metadataValues = metadataValues;
    }
}
