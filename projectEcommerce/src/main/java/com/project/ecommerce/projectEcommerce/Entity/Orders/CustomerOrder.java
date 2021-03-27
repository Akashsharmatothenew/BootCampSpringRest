package com.project.ecommerce.projectEcommerce.Entity.Orders;


import com.project.ecommerce.projectEcommerce.Entity.Users.Address;
import com.project.ecommerce.projectEcommerce.Entity.Users.Customer;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
public class CustomerOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String amountPaid;
    private Date orderCreated;
    private String paymentMethod;

    @ManyToOne
    @JoinColumn(name ="customer_id")
    private Customer customer;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "customerOrder")
    private Set<OrderProduct> orderProducts;



}
