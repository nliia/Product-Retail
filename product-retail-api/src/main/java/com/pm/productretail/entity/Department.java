package com.pm.productretail.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class Department extends AbstractEntity {

    private String address;
    private String name;
    private Boolean isWarehouse;

    @ManyToOne
    @JoinColumn
    private Department parent;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Department getParent() {
        return parent;
    }

    public void setParent(Department parent) {
        this.parent = parent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getWarehouse() {
        return isWarehouse;
    }

    public void setWarehouse(Boolean warehouse) {
        isWarehouse = warehouse;
    }
}
