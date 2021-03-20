package com.SpringSecurityOauth2.SpringSecurity;

import org.springframework.security.core.GrantedAuthority;

/**
 * Created by ttn on 16/3/21.
 */
public class GrantAuthorityImpl implements GrantedAuthority {

    String authority;

    public GrantAuthorityImpl(String authority){
        this.authority=authority;
    }
    @Override
    public String getAuthority() {
        return authority;
    }
}
