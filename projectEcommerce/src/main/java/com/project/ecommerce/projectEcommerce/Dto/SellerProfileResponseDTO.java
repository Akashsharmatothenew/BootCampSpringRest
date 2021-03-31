package com.project.ecommerce.projectEcommerce.Dto;


import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;

public class SellerProfileResponseDTO {

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
    private Float gst;

    private List<AddressResponseDTO> addressResponseDTOList;

    public SellerProfileResponseDTO() {
    }

    public Float getGst() {
        return gst;
    }

    public void setGst(Float gst) {
        this.gst = gst;
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

    public List<AddressResponseDTO> getAddressResponseDTOList() {
        return addressResponseDTOList;
    }

    public void setAddressResponseDTOList(List<AddressResponseDTO> addressResponseDTOList) {
        this.addressResponseDTOList = addressResponseDTOList;
    }

    @Override
    public String toString() {
        return "SellerProfileResponseDTO{" +
                "email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", active=" + active +
                ", companyName='" + companyName + '\'' +
                ", companyContact='" + companyContact + '\'' +
                ", gst=" + gst +
                ", addressResponseDTOList=" + addressResponseDTOList +
                '}';
    }
}
