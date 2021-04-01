package com.project.ecommerce.projectEcommerce.configurations;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class AppUser implements UserDetails {

    private String username;
    private String password;
    List<GrantedAuthority> grantedAuthorities;
    private Boolean AccountNonLocked;
    private Boolean Enabled;

    public AppUser(String username, String password, List<GrantedAuthority> grantedAuthorities, Boolean accountNonLocked, Boolean enabled) {
        this.username = username;
        this.password = password;
        this.grantedAuthorities = grantedAuthorities;
        this.AccountNonLocked = accountNonLocked;
        this.Enabled = enabled;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        System.out.println("In app user");
        System.out.println(grantedAuthorities);
        System.out.println("Out of app user");
        return grantedAuthorities;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return AccountNonLocked;
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
