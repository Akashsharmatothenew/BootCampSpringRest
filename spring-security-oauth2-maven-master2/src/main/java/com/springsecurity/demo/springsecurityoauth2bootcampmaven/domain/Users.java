package com.springsecurity.demo.springsecurityoauth2bootcampmaven.domain;

import javax.persistence.*;

/**
 * Created by ttn on 20/3/21.
 */
@Entity
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String username;
    String userpassword;
    String role;

    public Users(String username, String userpassword, String role) {
        this.username = username;
        this.userpassword = userpassword;
        this.role = role;
    }

    public Users() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", userpassword='" + userpassword + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
