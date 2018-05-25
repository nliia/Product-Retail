package com.pm.productretail.dto;

public class ShipItemDto {

    Long itemId;
    Long itemCount;
    Long destinationDepartmentId;

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Long getItemCount() {
        return itemCount;
    }

    public void setItemCount(Long itemCount) {
        this.itemCount = itemCount;
    }

    public Long getDestinationDepartmentId() {
        return destinationDepartmentId;
    }

    public void setDestinationDepartmentId(Long destinationDepartmentId) {
        this.destinationDepartmentId = destinationDepartmentId;
    }
}
