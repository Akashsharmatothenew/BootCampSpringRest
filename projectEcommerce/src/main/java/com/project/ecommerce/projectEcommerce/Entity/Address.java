package com.project.ecommerce.projectEcommerce.Entity;

import javax.persistence.*;

/**
 * Created by ttn on 23/3/21.
 */
@Entity
@Table(name = "address")
public class Address {
    @Id
    long id;
    String city;
    String country;
    String addressLine;
    int zipcode;
    String label;
    @OneToOne(cascade = CascadeType.ALL)
            @JoinColumn(name = "users_id")
    User user;
    

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAddressLine() {
        return addressLine;
    }

    public void setAddressLine(String addressLine) {
        this.addressLine = addressLine;
    }

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user){
        this.user=user;
    }
}
