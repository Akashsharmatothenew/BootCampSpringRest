package com.SpringWithJpa1.Employee2;

import javax.persistence.*;

/**
 * Created by ttn on 17/3/21.
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "payment3")
public abstract class Payment3 {
    @Id
    int id;
    int amount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
