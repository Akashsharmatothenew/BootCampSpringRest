package com.project.ecommerce.projectEcommerce.Entity.Orders;

import com.project.ecommerce.projectEcommerce.Entity.JSONObjectConverter;
import lombok.Getter;
import lombok.Setter;
import org.json.JSONObject;

import javax.persistence.*;

@Entity
@Getter
@Setter

public class OrderProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private Long Quantity;
    private Double price;
    @Column(columnDefinition = "TEXT")
    @Convert(converter= JSONObjectConverter.class)
    private JSONObject productVariation;

    @ManyToOne
    @JoinColumn(name="order_id")
    private CustomerOrder customerOrder;



}
