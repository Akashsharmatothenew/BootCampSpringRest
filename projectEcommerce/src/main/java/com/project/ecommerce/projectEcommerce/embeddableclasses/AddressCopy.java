package com.project.ecommerce.projectEcommerce.embeddableclasses;

import javax.persistence.Embeddable;

@Embeddable
public class AddressCopy {

    private String city;

    private String state;

    private String country;

    private String addressLabel;

    private Integer zipCode;

    private String label;

    public AddressCopy(String city, String state, String country, String addressLabel, Integer zipCode, String label) {
        this.city = city;
        this.state = state;
        this.country = country;
        this.addressLabel = addressLabel;
        this.zipCode = zipCode;
        this.label = label;
    }
}
