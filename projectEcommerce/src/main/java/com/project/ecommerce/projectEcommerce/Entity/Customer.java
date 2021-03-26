package com.project.ecommerce.projectEcommerce.Entity;

import javax.persistence.*;

/**
 * Created by ttn on 24/3/21.
 */
@Entity
@Table(name = "customer")
public class Customer {
    @Column(name = "contact")
    String contact;
    @Id
    long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "users_id")
    User user;

    public Customer() {
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
