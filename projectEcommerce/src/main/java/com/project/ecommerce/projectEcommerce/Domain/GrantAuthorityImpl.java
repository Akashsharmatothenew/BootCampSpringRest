package com.project.ecommerce.projectEcommerce.Domain;

import com.project.ecommerce.projectEcommerce.Entity.Role;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;
import java.util.Set;

/**
 * Created by ttn on 24/3/21.
 */
public class GrantAuthorityImpl implements GrantedAuthority {
    String authority;

    public GrantAuthorityImpl(String authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return authority;
    }
}
