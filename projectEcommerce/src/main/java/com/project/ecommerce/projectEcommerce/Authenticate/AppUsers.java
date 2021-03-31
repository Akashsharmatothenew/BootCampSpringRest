package com.project.ecommerce.projectEcommerce.Authenticate;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/**
 * Created by ttn on 24/3/21.
 */
public class AppUsers implements UserDetails {

    private String username;
    private String password;
    List<GrantedAuthority> authority;
    private Boolean AccountNonLocked;
    private Boolean Enabled;

    public AppUsers() {
    }

    public AppUsers(String username, String password, List<GrantedAuthority> authority, Boolean accountNonLocked, Boolean enabled) {
        this.username = username;
        this.password = password;
        this.authority = authority;
        AccountNonLocked = accountNonLocked;
        Enabled = enabled;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        System.out.println("In app User");
        System.out.println(authority);
        System.out.println("Out of app user");
        return authority;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return Enabled;
    }
}
