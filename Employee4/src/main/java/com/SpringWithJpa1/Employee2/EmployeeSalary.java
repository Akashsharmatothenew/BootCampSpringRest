package com.SpringWithJpa1.Employee2;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Created by ttn on 17/3/21.
 */
@Embeddable
public class EmployeeSalary {
    @Column(name = "basicSalary")
    int basicSalary;
    @Column(name = "bonusSalary")
    int bonusSalary;
    @Column(name ="taxAmount")
    int taxAmount;
    @Column(name = "specialAllowanceSalary")
    int specialAllowanceSalary;

    public int getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(int basicSalary) {
        this.basicSalary = basicSalary;
    }

    public int getBonusSalary() {
        return bonusSalary;
    }

    public void setBonusSalary(int bonusSalary) {
        this.bonusSalary = bonusSalary;
    }

    public int getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(int taxAmount) {
        this.taxAmount = taxAmount;
    }

    public int getSpecialAllowanceSalary() {
        return specialAllowanceSalary;
    }

    public void setSpecialAllowanceSalary(int specialAllowanceSalary) {
        this.specialAllowanceSalary = specialAllowanceSalary;
    }
}
