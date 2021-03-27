package com.project.ecommerce.projectEcommerce.Entity.Users;

import com.project.ecommerce.projectEcommerce.Entity.Orders.CustomerOrder;
import com.project.ecommerce.projectEcommerce.Entity.Product.ProductReview;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@PrimaryKeyJoinColumn(name="id")
public class Customer extends User {
    @Size(min=10,max = 10,message = "Contact must be of 10 number")
    private String Contact;
    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)//mappedbyuser
    private Set<CustomerOrder> customerOrders;

    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    private Set<ProductReview>productReviews;

    @OneToMany(mappedBy ="customer",cascade = CascadeType.ALL)
    private Set<Cart>carts;

}
