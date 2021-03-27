package com.project.ecommerce.projectEcommerce.UserDetails;

import org.springframework.security.core.GrantedAuthority;

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
