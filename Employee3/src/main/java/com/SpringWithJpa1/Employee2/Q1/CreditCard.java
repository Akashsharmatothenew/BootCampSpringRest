package com.SpringWithJpa1.Employee2.Q1;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by ttn on 17/3/21.
 */
@Entity
@DiscriminatorValue("cc")
public class CreditCard extends Payment {
    @Column(name = "cardnumber")
    String creditnumber;

    public String getCreditnumber() {
        return creditnumber;
    }

    public void setCreditnumber(String creditnumber) {
        this.creditnumber = creditnumber;
    }
}
