package com.SpringWithJpa1.Employee2;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * Created by ttn on 17/3/21.
 */
@Entity
@PrimaryKeyJoinColumn(name = "id")
@Table(name = "creditcard3")
public class Creditcard3 extends Payment3{
    @Column(name = "cardnumber")
    String cardnumber;

    public String getCardnumber() {
        return cardnumber;
    }

    public void setCardnumber(String cardnumber) {
        this.cardnumber = cardnumber;
    }
}
