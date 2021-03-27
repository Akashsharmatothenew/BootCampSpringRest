package com.project.ecommerce.projectEcommerce.Repository;

import com.project.ecommerce.projectEcommerce.Entity.Users.Seller;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ttn on 27/3/21.
 */
@Repository
public interface SellerRepository extends CrudRepository<Seller,Long> {
    List<Seller> findAllByEmailId(String Email);
}
