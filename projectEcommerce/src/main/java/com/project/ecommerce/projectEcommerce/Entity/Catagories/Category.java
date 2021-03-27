package com.project.ecommerce.projectEcommerce.Entity.Catagories;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String categoryName;

    @OneToMany(mappedBy ="category",cascade = CascadeType.ALL)
    private Set<SubCategory> subCategories;
}
