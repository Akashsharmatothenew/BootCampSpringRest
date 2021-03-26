package com.project.ecommerce.projectEcommerce.Services;

import com.project.ecommerce.projectEcommerce.Entity.Role;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by ttn on 24/3/21.
 */
public interface RoleRepository extends PagingAndSortingRepository<Role,Long> {
}
