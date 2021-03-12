package com.SpringwithRest1.RestSpring.flitering;

import com.fasterxml.jackson.annotation.JsonFilter;

/**
 * Created by ttn on 11/3/21.
 */
@JsonFilter("Password")
public class FiltreingUser2 {
    String name;
    String email;
    String password;

    public FiltreingUser2() {
    }

    public FiltreingUser2(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
