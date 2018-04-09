package com.pm.productretail.dto.response;

import com.pm.productretail.entity.DepartmentLinkItem;

public class ItemResponseDto {

    private String name;
    private Long count;

    public ItemResponseDto(DepartmentLinkItem departmentLinkItem) {
        setName(departmentLinkItem.getItem().getName());
        setCount(departmentLinkItem.getCount());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
