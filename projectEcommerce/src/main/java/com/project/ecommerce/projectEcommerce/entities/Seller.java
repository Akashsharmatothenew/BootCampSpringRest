package com.project.ecommerce.projectEcommerce.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@PrimaryKeyJoinColumn(name="user_id")
public class Seller extends User implements Serializable {

    @NotNull
    @Column(unique = true)
  //  @Pattern(regexp="(^[0-9]{2}[A-Z]{5}[0-9]{4}[A-Z]{1}[1-9A-Z]{1}Z[0-9A-Z]{1}$)",message="Password must be 8 characters long")
    private String gst;

    @NotNull
    @Column(name="company_contact")
    private String companyContact;

    @NotNull
    @Column(name = "company_name")
    //@Pattern(regexp = "(\\+91|0)[0-9]{9}")
    private String companyName;

    @OneToMany(mappedBy = "seller",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<Product>productSets;

    public Seller() {

    }

    public String getGst() {
        return gst;
    }

    public void setGst(String gst) {
        this.gst = gst;
    }

    public String getCompanyContact() {
        return companyContact;
    }

    public void setCompanyContact(String companyContact) {
        this.companyContact = companyContact;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Set<Product> getProductSets() {
        return productSets;
    }

    public void setProductSets(Set<Product> productSets) {
        this.productSets = productSets;
    }

    public void setRole(List<Role> role) {
        this.role = role;
    }

    public void setIsActive(Boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Seller{" +
                "gst=" + gst +
                ", companyContact='" + companyContact + '\'' +
                ", companyName='" + companyName + '\'' +
                ", productSets=" + productSets +
                '}';
    }

}
