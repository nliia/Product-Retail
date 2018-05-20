package com.pm.productretail.controller;

import com.pm.productretail.dto.response.ImageResponseDto;
import com.pm.productretail.entity.Image;
import com.pm.productretail.service.ImageService;
import com.pm.productretail.service.ItemService;
import com.pm.productretail.service.UserService;
import com.pm.productretail.util.ApiResponse;
import com.pm.productretail.util.ResponseCreator;
import io.swagger.annotations.ApiImplicitParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class ImageController extends ResponseCreator {

    @Autowired
    ImageService imageService;

    @Autowired
    UserService userService;

    @Autowired
    ItemService itemService;

    @ApiImplicitParam(name = "Authorization", paramType = "header", required = true, dataType = "string")
    @RequestMapping(value = "/image", method = RequestMethod.POST)
    public ResponseEntity<ApiResponse<ImageResponseDto>> setUserImage(@RequestPart("image")MultipartFile image) {
        Image image1 = imageService.saveImage(image);
        return createGoodResponse(new ImageResponseDto(image1));
    }

    @ApiImplicitParam(name = "Authorization", paramType = "header", required = true, dataType = "string")
    @RequestMapping(value = "/image/{id}", method = RequestMethod.GET)
    public void getImage(@RequestParam("id") Long id, HttpServletResponse httpServletResponse) {
        byte[] response = imageService.getImageById(id);
        if(response!=null){
            try {
                httpServletResponse.getOutputStream().write(response);
                httpServletResponse.setStatus(200);
                return;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        httpServletResponse.setStatus(404);
    }
}
