package com.SpringWithJpa1.Employee2;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by ttn on 17/3/21.
 */
@Entity
@Table(name = "creditcard")
public class Creditcard extends Payment2 {
    @Column(name = "cardnumber")
  private String cardnumber;

    public String getCardnumber() {
        return cardnumber;
    }

    public void setCardnumber(String cardnumber) {
        this.cardnumber = cardnumber;
    }
}
