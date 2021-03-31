package com.project.ecommerce.projectEcommerce.Repository;

import com.project.ecommerce.projectEcommerce.Entity.Users.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {
    User findByUsername(String username);

    User findByEmail(String email);

    User findByConfirmationToken(String confirmationToken);

}
