package com.SpringwithRest1.RestSpring.com.SpringwithRest1.RestSpring.versioning;

/**
 * Created by ttn on 11/3/21.
 */
public class PersonV1 {
    String Name;

    public PersonV1() {
    }

    public PersonV1(String name) {
        Name = name;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
