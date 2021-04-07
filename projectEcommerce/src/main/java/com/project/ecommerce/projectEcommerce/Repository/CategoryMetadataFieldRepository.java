package com.project.ecommerce.projectEcommerce.Repository;


import com.project.ecommerce.projectEcommerce.entities.CategoryMetadataField;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryMetadataFieldRepository extends CrudRepository<CategoryMetadataField,Long> {

    CategoryMetadataField findByName(String fieldName);

    Page<CategoryMetadataField> findAll(Pageable pageable);
}
