package com.SpringwithRest1.RestSpring.com.SpringwithRest1.RestSpring.versioning;

/**
 * Created by ttn on 11/3/21.
 */
public class PersonV2 {
    String name;
    String email;
    int age;
    String city;

    public PersonV2() {
    }

    public PersonV2(String name, String email, int age, String city) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.city = city;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
