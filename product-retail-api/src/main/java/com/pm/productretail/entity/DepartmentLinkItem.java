package com.pm.productretail.entity;

import javax.persistence.*;

@Entity
@SequenceGenerator(name = "departmentLinkItemSeq", sequenceName = "departmentLinkItemSeq", initialValue = 50)
public class DepartmentLinkItem {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "departmentLinkItemSeq")
    private Long id;

    @OneToOne
    @JoinColumn
    private Department department;

    @OneToOne
    @JoinColumn
    private Item item;
    private Long count;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
