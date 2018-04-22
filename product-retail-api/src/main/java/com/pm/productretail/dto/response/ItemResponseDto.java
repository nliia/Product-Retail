package com.pm.productretail.dto.response;

import com.pm.productretail.entity.Item;

public class ItemResponseDto {

    private Long id;
    private String name;

    public ItemResponseDto(Item item) {
        setId(item.getId());
        setName(item.getName());
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
}
