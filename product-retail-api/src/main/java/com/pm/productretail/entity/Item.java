package com.pm.productretail.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@SequenceGenerator(name = "itemSeq", sequenceName = "itemSeq", initialValue = 10)
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "itemSeq")
    private Long id;
    private String name;
    private Double price;

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "item")
    private List<DepartmentLinkItem> departmentLinkItems;

    public List<DepartmentLinkItem> getDepartmentLinkItems() {
        return departmentLinkItems;
    }

    public void setDepartmentLinkItems(List<DepartmentLinkItem> departmentLinkItems) {
        this.departmentLinkItems = departmentLinkItems;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
