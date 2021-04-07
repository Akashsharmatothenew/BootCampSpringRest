package com.project.ecommerce.projectEcommerce.Repository;


import com.project.ecommerce.projectEcommerce.entities.Category;
import com.project.ecommerce.projectEcommerce.entities.Product;
import com.project.ecommerce.projectEcommerce.entities.Seller;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {

    Product findByName(String name);

    Product findByNameAndSellerAndBrandAndCategory(String name, Seller seller, String brand, Category category);


    Page<Product> findAllBySellerAndDeleted(Seller seller, Boolean deleted, Pageable pageable);

    Product findByProductIdAndSeller(Long productId, Seller seller);


    @Query(value = "from Product p where p.category.categoryId=:category_id")
    List<Product> fetchSimilarProducts(@Param("category_id") Long category_id, Pageable pageable);

    @Query(value = "from Product p where p.category.categoryId=:category_id AND p.deleted=0")
    List<Product> fetchSimilarProductsAndDeleted(@Param("category_id") Long category_id, Pageable pageable);

    Page<Product> findAll(Pageable pageable);

    List<Product> findByCategory(Category category);

    List<Product> findByCategoryAndDeleted(Category category, Boolean deleted);
}
