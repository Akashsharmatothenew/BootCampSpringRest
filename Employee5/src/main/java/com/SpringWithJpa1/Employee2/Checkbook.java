package com.SpringWithJpa1.Employee2;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by ttn on 17/3/21.
 */
@Entity
@Table(name = "checkbook")
public class Checkbook extends Payment2 {
    @Column(name = "checknumber")
    String checknumber;

    public String getChecknumber() {
        return checknumber;
    }

    public void setChecknumber(String checknumber) {
        this.checknumber = checknumber;
    }
}
