package com.project.ecommerce.projectEcommerce.Entity.Product;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.project.ecommerce.projectEcommerce.Entity.Users.Cart;
import org.hibernate.annotations.Type;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;


@Entity
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="productVariationId")
public class ProductVariation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "sequence_generator")
    @SequenceGenerator(name = "sequence_generator",sequenceName = "sequence_table",allocationSize = 1)
    private Long productVariationId;

    @Column(name = "quantity_available")
    private Integer quantityAvailable;

    private Float price;

    @Type(type = "json")
    @Column(columnDefinition = "JSON")
    private String metadata;

    @Column(name = "primary_image_name")
    private String primaryImageName;

    @NotNull
    @Column(name = "is_deleted")
    private Boolean deleted=false;

    @NotNull
    @Column(name = "is_active")
    private Boolean active=false;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @JsonIgnore
    @ManyToMany(mappedBy = "productVariations")
    private Set<Cart> cart;


    public ProductVariation() {
    }

    public Long getProductVariationId() {
        return productVariationId;
    }

    public void setProductVariationId(Long productVariationId) {
        this.productVariationId = productVariationId;
    }

    public Integer getQuantityAvailable() {
        return quantityAvailable;
    }

    public void setQuantityAvailable(Integer quantityAvailable) {
        this.quantityAvailable = quantityAvailable;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getMetadata() {
        return metadata;
    }

    public void setMetadata(String metadata) {
        this.metadata = metadata;
    }

    public String getPrimaryImageName() {
        return primaryImageName;
    }

    public void setPrimaryImageName(String primaryImageName) {
        this.primaryImageName = primaryImageName;
    }

    public Boolean getIsDeleted() {
        return deleted;
    }

    public void setIsDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Boolean getIsActive() {
        return active;
    }

    public void setIsActive(Boolean active) {
        this.active = active;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Set<Cart> getCart() {
        return cart;
    }

    public void setCart(Set<Cart> cart) {
        this.cart = cart;
    }

    @Override
    public String toString() {
        return "ProductVariation{" +
                "productVariationId=" + productVariationId +
                ", quantityAvailable=" + quantityAvailable +
                ", price=" + price +
                ", metadata='" + metadata + '\'' +
                ", primaryImageName='" + primaryImageName + '\'' +
                ", deleted=" + deleted +
                ", active=" + active +
                ", product=" + product +
                ", cart=" + cart +
                '}';
    }
}
