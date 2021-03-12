package com.SpringwithRest1.RestSpring.flitering;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Created by ttn on 11/3/21.
 */
public class FilteringUser1 {
    String name;
    String Email;
    @JsonIgnore
    String password;

    public FilteringUser1() {
    }

    public FilteringUser1(String name, String Email, String password) {
        this.name = name;
        this.Email = Email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
