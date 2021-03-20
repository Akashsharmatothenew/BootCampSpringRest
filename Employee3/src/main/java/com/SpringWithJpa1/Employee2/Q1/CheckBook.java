package com.SpringWithJpa1.Employee2.Q1;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by ttn on 17/3/21.
 */
@Entity
@DiscriminatorValue("ch")
public class CheckBook extends Payment {
    @Column(name = "checknumber")
    String checknumber;

    public String getChecknumber() {
        return checknumber;
    }

    public void setChecknumber(String checknumber) {
        this.checknumber = checknumber;
    }
}
