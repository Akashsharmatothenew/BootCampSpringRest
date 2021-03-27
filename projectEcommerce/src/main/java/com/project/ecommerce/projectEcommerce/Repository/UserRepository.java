package com.project.ecommerce.projectEcommerce.Repository;

import com.project.ecommerce.projectEcommerce.Entity.Users.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ttn on 24/3/21.
 */
@Repository
public interface UserRepository extends PagingAndSortingRepository<User,Long> {
    User findByEmailId(String Email);
    List<User> findAllBy();

}
