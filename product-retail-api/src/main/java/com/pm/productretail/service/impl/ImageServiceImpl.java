package com.pm.productretail.service.impl;

import com.pm.productretail.entity.Image;
import com.pm.productretail.repository.ImageRepository;
import com.pm.productretail.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    ImageRepository imageRepository;

    @Override
    public byte[] getImageById(Long id) {
        Image image = imageRepository.getOne(id);
        if(image.getImagePath()!=null) {
            try {
                byte[] imageBytes = Files.readAllBytes(Paths.get(image.getImagePath()));
                return imageBytes;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public Image saveImage(MultipartFile image) {
        try {
        byte[] bytes = image.getBytes();
        File file = new File(System.getProperty("user.dir")+File.separator+"image"+Math.random());
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
        bufferedOutputStream.write(bytes);
        bufferedOutputStream.close();
        String path = file.getAbsolutePath();
        Image image1 = new Image();
        image1.setImagePath(path);
        image1 = imageRepository.save(image1);
        return image1;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Image getOneById(Long itemImageId) {
        return imageRepository.getOne(itemImageId);
    }
}
