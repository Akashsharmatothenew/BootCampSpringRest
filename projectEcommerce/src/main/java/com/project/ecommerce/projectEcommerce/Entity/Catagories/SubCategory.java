package com.project.ecommerce.projectEcommerce.Entity.Catagories;

import com.project.ecommerce.projectEcommerce.Entity.Product.Product;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
public class SubCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String subCategoryName;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="subCategories_categoryMetaDataFields",
            joinColumns = @JoinColumn(name="subcategory_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name="categoryMetaDataField_id",referencedColumnName = "id"))
    private Set<CategoryMetaDataField> categoryMetaDataFields;


    @OneToMany(mappedBy = "subCategory",cascade = CascadeType.ALL)
    private Set<Product> products;

}
