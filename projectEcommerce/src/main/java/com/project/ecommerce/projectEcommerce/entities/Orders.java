package com.project.ecommerce.projectEcommerce.entities;


import com.project.ecommerce.projectEcommerce.auditinginfo.AuditingInfo;
import com.project.ecommerce.projectEcommerce.embeddableclasses.AddressCopy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;

@Entity
public class Orders extends AuditingInfo<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "sequence_generator")
    @SequenceGenerator(name = "sequence_generator",sequenceName = "sequence_table",allocationSize = 1)
    @NotNull
    private Long ordersId;

    @NotNull
    @Column(name="amount_paid")
    private Float amountPaid;

    @NotNull
    @Column(name = "date_created")
    @Temporal(value = TemporalType.DATE)
    private Date dateCreated;

    @NotNull
    @Column(name="payment_method")
    private String paymentMethod;

    @NotNull
    @Column(name="is_deleted")
    private Boolean deleted=false;

    @Embedded
    private AddressCopy addressCopy;

    @OneToMany(mappedBy = "orders",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<OrderProduct> orderProduct;

    @ManyToOne
    @JoinColumn(name = "customer_user_id")
    private Customer customer;

    public Orders() {
    }

    public Long getOrdersId() {
        return ordersId;
    }

    public void setOrdersId(Long ordersId) {
        this.ordersId = ordersId;
    }

    public Float getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(Float amountPaid) {
        this.amountPaid = amountPaid;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Boolean getIsDeleted() {
        return deleted;
    }

    public void setIsDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public AddressCopy getAddressCopy() {
        return addressCopy;
    }

    public void setAddressCopy(AddressCopy addressCopy) {
        this.addressCopy = addressCopy;
    }

    public Set<OrderProduct> getOrderProduct() {
        return orderProduct;
    }

    public void setOrderProduct(Set<OrderProduct> orderProduct) {
        this.orderProduct = orderProduct;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "ordersId=" + ordersId +
                ", amountPaid=" + amountPaid +
                ", dateCreated=" + dateCreated +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", deleted=" + deleted +
                ", addressCopy=" + addressCopy +
                ", orderProduct=" + orderProduct +
                ", customer=" + customer +
                '}';
    }
}
