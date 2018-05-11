package com.pm.productretail.entity;


import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.List;

@Entity
public class Shift extends AbstractEntity {
    @Temporal(TemporalType.DATE)
    private Date shiftDate;

    @ManyToMany
    private List<AppUser> users;

    public Shift() {

    }

    public Shift(Date shiftDate, List<AppUser> users) {
        this.shiftDate = shiftDate;
        this.users = users;
    }

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
