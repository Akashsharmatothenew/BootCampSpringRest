package com.project.ecommerce.projectEcommerce.Repository;


import com.project.ecommerce.projectEcommerce.Entity.Orders.Orders;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersRepository extends CrudRepository<Orders,Long> {
}
