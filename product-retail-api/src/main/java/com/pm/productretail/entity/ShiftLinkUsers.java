package com.pm.productretail.entity;


import javax.persistence.*;

@Entity
public class ShiftLinkUsers extends AbstractEntity {

    @ManyToOne
    @JoinColumn
    private Shift shift;

    @OneToOne
    @JoinColumn
    private User user;

    public Shift getShift() {
        return shift;
    }

    public void setShift(Shift shift) {
        this.shift = shift;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
