package com.pm.productretail.dto;

import com.pm.productretail.entity.Department;

public class DepartmentDto {
    private Long id;
    private String address;
    private String name;
    private Boolean is_warehouse;

    public DepartmentDto(Department department) {
        setAddress(department.getAddress());
        setName(department.getName());
        setWarehouse(department.getWarehouse());
        setId(department.getId());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getWarehouse() {
        return is_warehouse;
    }

    public void setWarehouse(Boolean warehouse) {
        is_warehouse = warehouse;
    }
}
