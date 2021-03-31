package com.project.ecommerce.projectEcommerce.Repository;


import com.project.ecommerce.projectEcommerce.Entity.Orders.OrderStatus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderStatusRepository extends CrudRepository<OrderStatus,Long> {
}
