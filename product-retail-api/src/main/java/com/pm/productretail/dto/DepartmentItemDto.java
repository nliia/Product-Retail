package com.pm.productretail.dto;

public class DepartmentItemDto {
    private Long departmnetId;
    private Long itemId;
    private Long count;

    public Long getDepartmnetId() {
        return departmnetId;
    }

    public void setDepartmnetId(Long departmnetId) {
        this.departmnetId = departmnetId;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
