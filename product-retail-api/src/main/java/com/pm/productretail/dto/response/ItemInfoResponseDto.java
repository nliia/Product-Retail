package com.pm.productretail.dto.response;

import com.pm.productretail.entity.Item;

public class ItemInfoResponseDto {

    private Long id;
    private String name;
    private Double price;
    private Long warehouseCount;
    private Long currentDepartmentCount;

    public ItemInfoResponseDto(Item item) {
        setId(item.getId());
        setName(item.getName());
        setPrice(item.getPrice());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getWarehouseCount() {
        return warehouseCount;
    }

    public void setWarehouseCount(Long warehouseCount) {
        this.warehouseCount = warehouseCount;
    }

    public Long getCurrentDepartmentCount() {
        return currentDepartmentCount;
    }

    public void setCurrentDepartmentCount(Long currentDepartmentCount) {
        this.currentDepartmentCount = currentDepartmentCount;
    }
}
