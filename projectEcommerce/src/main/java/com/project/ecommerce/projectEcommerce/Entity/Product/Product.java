package com.project.ecommerce.projectEcommerce.Entity.Product;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.project.ecommerce.projectEcommerce.AuditingInfo.AuditingInfo;
import com.project.ecommerce.projectEcommerce.Entity.Catagories.Category;
import com.project.ecommerce.projectEcommerce.Entity.Users.Seller;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="productId")
public class Product extends AuditingInfo<String>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "sequence_generator")
    @SequenceGenerator(name = "sequence_generator",sequenceName = "sequence_table",allocationSize = 1)
    @Column(name = "product_id")
    private Long productId;
    @NotNull
    private String name;

    private String description;

    @Column(name="is_cancellable")
    private Boolean cancellable=false;

    @Column(name="is_returnable")
    private Boolean returnable=false;

    @NotNull
    private String brand;

    @Column(name = "is_active")
    private Boolean active=false;

    @Column(name="is_deleted")
    private Boolean deleted=false;

    @ManyToOne
    @JoinColumn(name = "seller_user_id")
    private Seller seller;

    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;

    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<ProductVariation> productVariations;

    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<ProductReview> productReviews;

    public Product() {
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getIsCancellable() {
        return cancellable;
    }

    public void setIsCancellable(Boolean cancellable) {
        this.cancellable = cancellable;
    }

    public Boolean getIsReturnable() {
        return returnable;
    }

    public void setIsReturnable(Boolean returnable) {
        this.returnable = returnable;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Boolean getIsActive() {
        return active;
    }

    public void setIsActive(Boolean active) {
        this.active = active;
    }

    public Boolean getIsDeleted() {
        return deleted;
    }

    public void setIsDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Set<ProductVariation> getProductVariations() {
        return productVariations;
    }

    public void setProductVariations(Set<ProductVariation> productVariations) {
        this.productVariations = productVariations;
    }

    public Set<ProductReview> getProductReviews() {
        return productReviews;
    }

    public void setProductReviews(Set<ProductReview> productReviews) {
        this.productReviews = productReviews;
    }

    public void insertProductVariation(ProductVariation productVariation)
    {
        if(productVariations==null)
        {
            productVariations=new HashSet<>();
        }
        productVariations.add(productVariation);
        productVariation.setProduct(this);
        this.setProductVariations(productVariations);
    }

}
