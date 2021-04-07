package com.project.ecommerce.projectEcommerce.Repository;


import com.project.ecommerce.projectEcommerce.entities.Product;
import com.project.ecommerce.projectEcommerce.entities.ProductVariation;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductVariationRepository extends CrudRepository<ProductVariation,Long> {

    List<ProductVariation> findByProduct(Product product, Pageable pageable);

    @Query(value = "select metadata from product_variation",nativeQuery = true)
    List<Object> fetchMetadata();

    @Query(value = "select MIN(price) from product_variation where product_id IN (select product_id from product where category_id=:category_id)",nativeQuery = true)
    Float getMinPrice(@Param("category_id") Long categoryId);

    @Query(value = "select MAX(price) from product_variation where product_id IN (select product_id from product where category_id=:category_id)",nativeQuery = true)
    Float getMaxPrice(@Param("category_id") Long categoryId);


}
