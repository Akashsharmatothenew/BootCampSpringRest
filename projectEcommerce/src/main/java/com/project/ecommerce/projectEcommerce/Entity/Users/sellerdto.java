package com.project.ecommerce.projectEcommerce.Entity.Users;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embedded;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

//select s.id,s.firstName,s.middleName, s.lastName,s.emailId,s.isActive,s.companyName,s.address
@Getter
@Setter
@NoArgsConstructor

@Data

public class sellerdto {
    private Long id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String emailId;
    private Boolean isActive;
    private String companyName;
   // @Embedded
    private Address address;

    public sellerdto(Long id, String firstName, String middleName, String lastName, String emailId, Boolean isActive, String companyName, Address address) {
        this.id = id;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.emailId = emailId;
        this.isActive = isActive;
        this.companyName = companyName;
        this.address = address;
    }
}
