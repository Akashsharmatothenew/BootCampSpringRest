package com.SpringWithJpa1.Employee2;

import javax.persistence.Embeddable;

@Embeddable
public class Address {

    private String streetnumber;
    private String location;
    private String state;

    public Address() {
    }

    public Address(String streetnumber, String location, String state) {
        this.streetnumber = streetnumber;
        this.location = location;
        this.state = state;
    }

    public String getStreetnumber() {
        return streetnumber;
    }

    public void setStreetnumber(String streetnumber) {
        this.streetnumber = streetnumber;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
