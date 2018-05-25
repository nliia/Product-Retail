package com.pm.productretail.dto.response;

import com.pm.productretail.entity.DepartmentLinkItem;
import com.pm.productretail.entity.Item;

public class ItemResponseDto {

    private Long id;
    private String name;
    private Long count;
    private Double price;
    private Long itemImageId;

    public ItemResponseDto(Item item) {
        this.id = item.getId();
        this.name = item.getName();
        this.count = 0L;
        this.price = item.getPrice();
        if(item.getImage()!=null) {
            this.itemImageId = item.getImage().getId();
        }
    }

    public ItemResponseDto(DepartmentLinkItem departmentLinkItem) {
        Item item = departmentLinkItem.getItem();
        this.id = item.getId();
        this.name = item.getName();
        this.count = departmentLinkItem.getCount();
        this.price = item.getPrice();
        if(item.getImage()!=null) {
            this.itemImageId = item.getImage().getId();
        }
    }

    public Long getItemImageId() {
        return itemImageId;
    }

    public void setItemImageId(Long itemImageId) {
        this.itemImageId = itemImageId;
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

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
