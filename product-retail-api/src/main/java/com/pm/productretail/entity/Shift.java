package com.pm.productretail.entity;


import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.Date;
import java.util.List;

@Entity
public class Shift extends AbstractEntity {

    private Date shiftDate;

    @ManyToMany
    private List<AppUser> users;

    public Date getShiftDate() {
        return shiftDate;
    }

    public void setShiftDate(Date shiftDate) {
        this.shiftDate = shiftDate;
    }

    public List<AppUser> getUsers() {
        return users;
    }

    public void setUsers(List<AppUser> users) {
        this.users = users;
    }
}
