package com.pm.productretail.entity;


import javax.persistence.*;

@Entity
public class ShiftLinkUsers extends AbstractEntity {

    @ManyToOne
    @JoinColumn
    private Shift shift;

    @OneToOne
    @JoinColumn
    private AppUser appUser;

    public Shift getShift() {
        return shift;
    }

    public void setShift(Shift shift) {
        this.shift = shift;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }
}
