package com.project.ecommerce.projectEcommerce.Services;

import com.project.ecommerce.projectEcommerce.Entity.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by ttn on 24/3/21.
 */
@Repository
public interface UserRepository extends PagingAndSortingRepository<User,Long> {
    User findByFirstName(String name);
}
