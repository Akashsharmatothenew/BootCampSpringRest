package com.project.ecommerce.projectEcommerce.Entity.Orders;
import com.project.ecommerce.projectEcommerce.Entity.Product.ProductVariation;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class OrderProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "sequence_generator")
    @SequenceGenerator(name = "sequence_generator",sequenceName = "sequence_table",allocationSize = 1)
    private Long orderProductId;

    @NotNull
    private Integer quantity;

    @NotNull
    private Float price;

    @NotNull
    @Column(name="is_deleted")
    private Boolean deleted=false;

    @OneToOne(mappedBy = "orderProduct")
    private OrderStatus orderStatus;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Orders orders;

    @OneToOne
    @JoinColumn(name = "product_variation_id")
    private ProductVariation productVariation;

    @NotNull
    private String product_variation_metadata;

    public OrderProduct() {
    }

    public Long getOrderProductId() {
        return orderProductId;
    }

    public void setOrderProductId(Long orderProductId) {
        this.orderProductId = orderProductId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Boolean getIsDeleted() {
        return deleted;
    }

    public void setIsDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public ProductVariation getProductVariation() {
        return productVariation;
    }

    public void setProductVariation(ProductVariation productVariation) {
        this.productVariation = productVariation;
    }

    public String getProduct_variation_metadata() {
        return product_variation_metadata;
    }

    public void setProduct_variation_metadata(String product_variation_metadata) {
        this.product_variation_metadata = product_variation_metadata;
    }

    @Override
    public String toString() {
        return "OrderProduct{" +
                "orderProductId=" + orderProductId +
                ", quantity=" + quantity +
                ", price=" + price +
                ", deleted=" + deleted +
                ", orderStatus=" + orderStatus +
                ", orders=" + orders +
                ", productVariation=" + productVariation +
                ", product_variation_metadata='" + product_variation_metadata + '\'' +
                '}';
    }
}
