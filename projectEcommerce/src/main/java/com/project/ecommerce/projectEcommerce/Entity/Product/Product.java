package com.project.ecommerce.projectEcommerce.Entity.Product;


import com.project.ecommerce.projectEcommerce.Entity.Catagories.SubCategory;
import com.project.ecommerce.projectEcommerce.Entity.Users.Seller;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String description;
    private String brand;
    private Boolean isActive;
    private Boolean isCancellable;
    private Boolean isReturnable;
    @ManyToOne
    @JoinColumn(name="seller_id")
    private Seller seller;

    @ManyToOne
    @JoinColumn(name="subcategory_id")
    private SubCategory subCategory;

    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
    private Set<ProductVariation> productVariations;

    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
    private Set<ProductReview>productReviews;
}
