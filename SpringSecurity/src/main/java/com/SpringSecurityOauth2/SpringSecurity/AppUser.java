package com.SpringSecurityOauth2.SpringSecurity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/**
 * Created by ttn on 16/3/21.
 */
public class AppUser implements UserDetails {

    String username;
    String password;


    List<GrantedAuthority> grantedAuthorityList;

    public AppUser(String username, String password, List<GrantedAuthority> grantedAuthorityList) {
        this.username = username;
        this.password = password;
        this.grantedAuthorityList = grantedAuthorityList;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
