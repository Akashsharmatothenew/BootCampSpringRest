package com.SpringSecurityOauth2.SpringSecurity;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by ttn on 16/3/21.
 */
public interface UserRepository extends CrudRepository<User,Integer> {
    User findByUsername(String name);
}
