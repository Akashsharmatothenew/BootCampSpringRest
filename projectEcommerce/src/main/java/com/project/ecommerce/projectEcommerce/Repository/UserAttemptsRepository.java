package com.project.ecommerce.projectEcommerce.Repository;


import com.project.ecommerce.projectEcommerce.entities.UserAttempts;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAttemptsRepository extends CrudRepository<UserAttempts,Long> {

    UserAttempts findByUsername(String username);
}
