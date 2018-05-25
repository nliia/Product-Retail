package com.pm.productretail.dto;

public class ItemDto {
    private String name;

    private Double price;

    private Long count;

    private Long itemImageId;

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Long getItemImageId() {
        return itemImageId;
    }

    public void setItemImageId(Long itemImageId) {
        this.itemImageId = itemImageId;
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
}
