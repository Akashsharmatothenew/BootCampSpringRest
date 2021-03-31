package com.project.ecommerce.projectEcommerce.Authenticate;

import com.project.ecommerce.projectEcommerce.Entity.Users.Role;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;

/**
 * Created by ttn on 24/3/21.
 */
public class GrantAuthorityImpl implements GrantedAuthority {
   private List<Role> authority;

    public GrantAuthorityImpl(List<Role> authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        for(Role auth:authority){
            System.out.println("<<<<<<<<<<<<<<<<<"+auth.getAuthority());
            return String.valueOf(auth.getAuthority());
        }
        return null;
    }
}
