package com.project.ecommerce.projectEcommerce.Entity;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

/**
 * Created by ttn on 23/3/21.
 */
@Entity
@Table(name = "roles")
public class Role {
    @Id
            @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    String authority;
    @ManyToMany(mappedBy = "roles")
    List<User> users;


    public Role() {
    }

    public Role(long id, String authority) {
        this.id = id;
        this.authority = authority;
    }

    public Role(long id, String authority, List<User> users) {
        this.id = id;
        this.authority = authority;
        this.users = users;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public String getAuthority() {
        return authority;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
