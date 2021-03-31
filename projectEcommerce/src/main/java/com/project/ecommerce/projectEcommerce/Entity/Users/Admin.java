package com.project.ecommerce.projectEcommerce.Entity.Users;

import javax.persistence.*;

@Entity
@PrimaryKeyJoinColumn(name="user_id")
public class Admin extends User {
    public Admin() {
    }

    @Override
    public Boolean getNonLocked() {
        return super.getNonLocked();
    }

    @Override
    public void setNonLocked(Boolean nonLocked) {
        super.setNonLocked(nonLocked);
    }


}
