package com.project.ecommerce.projectEcommerce.Entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by ttn on 23/3/21.
 */
@Entity
@Table(name = "users")
public class User {
    @Id
            @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    String email;
    String firstName;
    String middleName;
    String lastName;
    @Column(name = "userPassword")
    String password;
    @Column(name = "isDeleted")
    boolean isDelete;
    @Column(name = "isActivate")
    boolean isActivate;
    @ManyToMany
    @JoinTable(name ="users_roles",
             joinColumns =@JoinColumn(name = "users_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "roles_id", referencedColumnName = "id"))
    private Set<Role> roles;
/*
    @OneToOne(mappedBy = "User",cascade = CascadeType.ALL)
    Address address;

    @OneToOne(mappedBy = "User",cascade = CascadeType.ALL)
    private Seller seller;

    @OneToOne(mappedBy = "User",cascade = CascadeType.ALL)
    private Customer customer;*/

    public User() {
    }

    public User(String email, String firstName, String middleName, String lastName, String password, boolean isDelete, boolean isActivate, Set<Role> roles) {
        this.email = email;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.password = password;
        this.isDelete = isDelete;
        this.isActivate = isActivate;
        this.roles = roles;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isDelete(boolean b) {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    public boolean isActivate(boolean b) {
        return isActivate;
    }

    public void setActivate(boolean activate) {
        isActivate = activate;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

   /*public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }*/
}
