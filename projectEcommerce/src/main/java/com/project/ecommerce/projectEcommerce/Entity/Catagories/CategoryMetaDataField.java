package com.project.ecommerce.projectEcommerce.Entity.Catagories;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
public class CategoryMetaDataField {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String metaName;
    @ManyToMany(mappedBy ="categoryMetaDataFields")
    private Set<SubCategory> subCategories;
}
