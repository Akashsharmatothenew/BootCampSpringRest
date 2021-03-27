package com.project.ecommerce.projectEcommerce.Repository;

import com.project.ecommerce.projectEcommerce.Entity.Users.Role;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by ttn on 26/3/21.
 */
public interface RoleRepository extends CrudRepository<Role,Long> {
}
