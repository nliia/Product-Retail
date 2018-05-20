package com.pm.productretail.service;

import com.pm.productretail.entity.Image;
import org.springframework.web.multipart.MultipartFile;

public interface ImageService {
    byte[] getImageById(Long id);

    Image saveImage(MultipartFile image);

    Image getOneById(Long itemImageId);
}
