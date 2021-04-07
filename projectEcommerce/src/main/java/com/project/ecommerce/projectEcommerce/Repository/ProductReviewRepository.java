package com.project.ecommerce.projectEcommerce.Repository;


import com.project.ecommerce.projectEcommerce.entities.ProductReview;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductReviewRepository extends PagingAndSortingRepository<ProductReview,Long> {
}
