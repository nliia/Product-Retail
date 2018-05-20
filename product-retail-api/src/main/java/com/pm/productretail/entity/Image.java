package com.pm.productretail.entity;

import javax.persistence.Entity;

@Entity
public class Image extends AbstractEntity {

    String imagePath;

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
