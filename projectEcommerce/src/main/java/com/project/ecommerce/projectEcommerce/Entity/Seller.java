package com.project.ecommerce.projectEcommerce.Entity;

import javax.persistence.*;

/**
 * Created by ttn on 24/3/21.
 */
@Entity
public class Seller{
    @Id
    Long id;
    Long gst;
    String companyContact;
    String CompanyName;
     @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "users_id")
    User user;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGst() {
        return gst;
    }

    public void setGst(Long gst) {
        this.gst = gst;
    }

    public String getCompanyContact() {
        return companyContact;
    }

    public void setCompanyContact(String companyContact) {
        this.companyContact = companyContact;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String companyName) {
        CompanyName = companyName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
