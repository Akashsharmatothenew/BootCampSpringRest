package com.project.ecommerce.projectEcommerce.Entity.Orders;


import com.project.ecommerce.projectEcommerce.AuditingInfo.AuditingInfo;
import com.project.ecommerce.projectEcommerce.Enums.FromStatus;
import com.project.ecommerce.projectEcommerce.Enums.ToStatus;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;



@Entity
public class OrderStatus extends AuditingInfo<String> implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "sequence_generator")
    @SequenceGenerator(name = "sequence_generator",sequenceName = "sequence_table",allocationSize = 1)
    private Long orderStatusId;

    @MapsId
    @OneToOne
    @JoinColumn(name = "order_product_id")
    private OrderProduct orderProduct;

    @Enumerated(EnumType.STRING)
    private FromStatus fromStatus;

    @Enumerated(EnumType.STRING)
    private ToStatus toStatus;

    @Column(name="transition_notes_comment")
    private String transitionNotesComment;

    @NotNull
    @Column(name="is_deleted")
    private Boolean deleted=false;


    public OrderStatus() {
    }

    public Long getOrderStatusId() {
        return orderStatusId;
    }

    public void setOrderStatusId(Long orderStatusId) {
        this.orderStatusId = orderStatusId;
    }

    public OrderProduct getOrderProduct() {
        return orderProduct;
    }

    public void setOrderProduct(OrderProduct orderProduct) {
        this.orderProduct = orderProduct;
    }

    public FromStatus getFromStatus() {
        return fromStatus;
    }

    public void setFromStatus(FromStatus fromStatus) {
        this.fromStatus = fromStatus;
    }

    public ToStatus getToStatus() {
        return toStatus;
    }

    public void setToStatus(ToStatus toStatus) {
        this.toStatus = toStatus;
    }

    public String getTransitionNotesComment() {
        return transitionNotesComment;
    }

    public void setTransitionNotesComment(String transitionNotesComment) {
        this.transitionNotesComment = transitionNotesComment;
    }

    public Boolean getIsDeleted() {
        return deleted;
    }

    public void setIsDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "OrderStatus{" +
                "orderStatusId=" + orderStatusId +
                ", orderProduct=" + orderProduct +
                ", fromStatus=" + fromStatus +
                ", toStatus=" + toStatus +
                ", transitionNotesComment='" + transitionNotesComment + '\'' +
                ", deleted=" + deleted +
                '}';
    }
}
