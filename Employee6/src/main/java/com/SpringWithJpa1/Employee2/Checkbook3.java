package com.SpringWithJpa1.Employee2;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * Created by ttn on 17/3/21.
 */
@Entity
@PrimaryKeyJoinColumn(name = "id")
@Table(name = "checkbook3")
public class Checkbook3 extends Payment3{
    String checknumber;

    public String getChecknumber() {
        return checknumber;
    }

    public void setChecknumber(String checknumber) {
        this.checknumber = checknumber;
    }
}
