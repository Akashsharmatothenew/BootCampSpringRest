package com.project.ecommerce.projectEcommerce.Entity.Users;


import com.project.ecommerce.projectEcommerce.Entity.Product.ProductVariation;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Cart {

    @Id
    private Long id;
    private Long quantity;
    @ManyToOne
    @JoinColumn(name="customer_id")
    private Customer customer;

    @OneToOne
    @JoinColumn(name="productvariation_id")
    private ProductVariation productVariation;
}
