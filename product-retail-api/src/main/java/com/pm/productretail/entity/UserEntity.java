package com.pm.productretail.entity;

import javax.persistence.Entity;

@Entity
public class UserEntity extends AbstractEntity {

    private String usename;
    private String password;

    public String getUsename() {
        return usename;
    }

    public void setUsename(String usename) {
        this.usename = usename;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
