package com.project.ecommerce.projectEcommerce.Entity.Catagories;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;



@Entity
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="categoryMetadataFieldId")
public class CategoryMetaDataField {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "sequence_generator")
    @SequenceGenerator(name = "sequence_generator",sequenceName = "sequence_table",allocationSize = 1)
    @Column(name="category_metadata_field_id")
    private Long categoryMetadataFieldId;

    @Column(unique = true)
    private String name;

    @NotNull
    @Column(name = "is_deleted")
    private Boolean deleted=false;

    @JsonIgnore
    @OneToMany(mappedBy = "categoryMetadataField",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<CategoryMetadataFieldValue> categoryMetadataFieldValue;

    public CategoryMetaDataField() {
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

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Set<CategoryMetadataFieldValue> getCategoryMetadataFieldValue() {
        return categoryMetadataFieldValue;
    }

    public void setCategoryMetadataFieldValue(Set<CategoryMetadataFieldValue> categoryMetadataFieldValue) {
        this.categoryMetadataFieldValue = categoryMetadataFieldValue;
    }

    @Override
    public String toString() {
        return "CategoryMetaDataField{" +
                "categoryMetadataFieldId=" + categoryMetadataFieldId +
                ", name='" + name + '\'' +
                ", deleted=" + deleted +
                ", categoryMetadataFieldValue=" + categoryMetadataFieldValue +
                '}';
    }
}
