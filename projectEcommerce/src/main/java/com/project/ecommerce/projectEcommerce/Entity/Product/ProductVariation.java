package com.project.ecommerce.projectEcommerce.Entity.Product;


import com.project.ecommerce.projectEcommerce.Entity.JSONObjectConverter;
import lombok.Getter;
import lombok.Setter;
import org.json.JSONObject;

import javax.persistence.*;
@Entity
@Getter
@Setter
public class ProductVariation {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product;
    private Long quantityAvailable;
    private Long price;

    @Column(columnDefinition = "TEXT")
    @Convert(converter= JSONObjectConverter.class)
    private JSONObject metadata;

}
