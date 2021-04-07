package com.project.ecommerce.projectEcommerce.dto;

import javax.validation.constraints.NotNull;

public class SellerResponseDTO {

    @NotNull
    private Long id;

    @NotNull
    private String email;

    @NotNull
    private String firstName;

    @NotNull
    private String middleName;

    @NotNull
    private String lastName;

    @NotNull
    private Boolean active;

    @NotNull
    private String companyName;

    @NotNull
    private String companyContact;

    @NotNull
    private String  gst;

    public SellerResponseDTO(@NotNull Long id, @NotNull String email, @NotNull String firstName, @NotNull String middleName, @NotNull String lastName, @NotNull Boolean active, @NotNull String companyName, @NotNull String companyContact, @NotNull String gst) {
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.active = active;
        this.companyName = companyName;
        this.companyContact = companyContact;
        this.gst = gst;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public Boolean getIsActive() {
        return active;
    }

    public void setIsActive(Boolean active) {
        this.active = active;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyContact() {
        return companyContact;
    }

    public void setCompanyContact(String companyContact) {
        this.companyContact = companyContact;
    }

    public String getGst() {
        return gst;
    }

    public void setGst(String gst) {
        this.gst = gst;
    }
}
