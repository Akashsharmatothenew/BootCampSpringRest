package com.springsecurity.demo.springsecurityoauth2bootcampmaven.service;

import com.springsecurity.demo.springsecurityoauth2bootcampmaven.domain.Users;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by ttn on 20/3/21.
 */
public interface UserRepository extends CrudRepository<Users ,Integer> {

  Users findByUsername(String name);

}
