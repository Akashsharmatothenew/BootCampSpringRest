package com.project.ecommerce.projectEcommerce.Entity.Product;


import com.project.ecommerce.projectEcommerce.Entity.Users.Customer;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
public class ProductReview implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "sequence_generator")
    @SequenceGenerator(name = "sequence_generator",sequenceName = "sequence_table",allocationSize = 1)
    @Column(name="product_review_id")
    private Long productReviewId;

    @NotNull
    private String review;

    @NotNull
    private Integer rating;

    @NotNull
    @Column(name="is_deleted")
    private Boolean deleted=false;

    @ManyToOne
    @JoinColumn(name = "customer_user_id",referencedColumnName = "user_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "product_id",referencedColumnName = "product_id")
    private Product product;

    public Long getProductReviewId() {
        return productReviewId;
    }

    public String getReview() {
        return review;
    }

    public Integer getRating() {
        return rating;
    }

    public Boolean getIsDeleted() {
        return deleted;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Product getProduct() {
        return product;
    }

    @Override
    public String toString() {
        return "ProductReview{" +
                "productReviewId=" + productReviewId +
                ", review='" + review + '\'' +
                ", rating=" + rating +
                ", deleted=" + deleted +
                ", customer=" + customer +
                ", product=" + product +
                '}';
    }
}
