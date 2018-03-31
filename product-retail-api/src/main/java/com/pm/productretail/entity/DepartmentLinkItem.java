package com.pm.productretail.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class DepartmentLinkItem extends AbstractEntity {

    @OneToOne
    @JoinColumn
    private Department department;

    @OneToOne
    @JoinColumn
    private Item item;
    private Long count;

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
