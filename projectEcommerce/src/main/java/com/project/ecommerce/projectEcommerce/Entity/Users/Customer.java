package com.project.ecommerce.projectEcommerce.Entity.Users;

import com.project.ecommerce.projectEcommerce.Entity.Orders.Orders;
import com.project.ecommerce.projectEcommerce.Entity.Product.ProductReview;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@PrimaryKeyJoinColumn(name="user_id")
public class Customer extends User {
    @NotNull
    //@Pattern(regexp = "(\\+91|0)[0-9]{9}")
    @Size(max=10)
    private String contact;

    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<Orders> orders;

    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<ProductReview> productReviews;

    @OneToOne(mappedBy = "customer")
    private Cart cart;

    public Customer() {
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Set<Orders> getOrders() {
        return orders;
    }

    public void setOrders(Set<Orders> orders) {
        this.orders = orders;
    }

    public Set<ProductReview> getProductReviews() {
        return productReviews;
    }

    public void setProductReviews(Set<ProductReview> productReviews) {
        this.productReviews = productReviews;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public void setRole(List<Role> role) {
        this.role = role;
    }

    public void setIsActive(Boolean active) {
        active = active;
    }


}
