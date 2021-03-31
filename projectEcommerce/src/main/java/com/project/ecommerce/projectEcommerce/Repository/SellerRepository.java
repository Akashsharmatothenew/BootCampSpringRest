package com.project.ecommerce.projectEcommerce.Repository;


import com.project.ecommerce.projectEcommerce.Entity.Users.Seller;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface SellerRepository extends PagingAndSortingRepository<Seller,Long> {

    Optional<Seller> findById(Long address_id);

    Seller findByEmail(String email);

    Seller findByConfirmationToken(String confirmationToken);

    @Override
    Page<Seller> findAll(Pageable pageable);

    Seller findByUsername(String username);

}
