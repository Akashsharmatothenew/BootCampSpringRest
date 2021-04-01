package com.project.ecommerce.projectEcommerce.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UpdateProfileDTO {

    @NotNull
    private String firstName;

    private String middleName;

    @NotNull
    private String lastName;

    @Size(max=10)
    //@Pattern(regexp = "(\\+91|0)[0-9]{9}")
    private String contact;

    public UpdateProfileDTO() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
