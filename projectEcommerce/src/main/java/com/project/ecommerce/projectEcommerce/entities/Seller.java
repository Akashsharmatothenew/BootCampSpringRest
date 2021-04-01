package com.project.ecommerce.projectEcommerce.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@PrimaryKeyJoinColumn(name="user_id")
public class Seller extends User implements Serializable {

    @NotNull
    private Float gst;

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

    public Float getGst() {
        return gst;
    }

    public void setGst(Float gst) {
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
