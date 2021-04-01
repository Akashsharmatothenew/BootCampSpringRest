package com.project.ecommerce.projectEcommerce.entities;



import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Set;

@Entity
public class Cart implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "sequence_generator")
    @SequenceGenerator(name = "sequence_generator",sequenceName = "sequence_table",allocationSize = 1)
    private Long cartId;

    @NotNull
    private Integer quantity;

    @NotNull
    @Column(name="is_wishlist_item")
    private Boolean wishlistItem;

    @NotNull
    @Column(name="is_deleted")
    private Boolean deleted=false;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinTable(
            name = "cart_product_variation",
            joinColumns = @JoinColumn(
                    name = "cart_id", referencedColumnName = "cartId"),
            inverseJoinColumns = @JoinColumn(
                    name = "product_variation_id", referencedColumnName = "productVariationId"))
    private Set<ProductVariation> productVariations;

    @OneToOne
    @JoinColumn(name = "customer_user_id")
    private Customer customer;

    public Cart() {
    }

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Boolean getIsWishlistItem() {
        return wishlistItem;
    }

    public void setIsWishlistItem(Boolean wishlistItem) {
        this.wishlistItem = wishlistItem;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Set<ProductVariation> getProductVariations() {
        return productVariations;
    }

    public void setProductVariations(Set<ProductVariation> productVariations) {
        this.productVariations = productVariations;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cartId=" + cartId +
                ", quantity=" + quantity +
                ", wishlistItem=" + wishlistItem +
                ", deleted=" + deleted +
                ", productVariations=" + productVariations +
                ", customer=" + customer +
                '}';
    }
}
