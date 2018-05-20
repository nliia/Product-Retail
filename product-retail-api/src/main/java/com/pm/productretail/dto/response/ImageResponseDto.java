package com.pm.productretail.dto.response;

import com.pm.productretail.entity.Image;

public class ImageResponseDto {

    Long id;

    public ImageResponseDto(Image image1) {
        this.id = image1.getId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
