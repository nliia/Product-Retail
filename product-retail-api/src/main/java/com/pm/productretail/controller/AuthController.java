package com.pm.productretail.controller;

import com.pm.productretail.dto.AppUserDto;
import com.pm.productretail.service.UserService;
import com.pm.productretail.util.ApiResponse;
import com.pm.productretail.util.ResponseCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController extends ResponseCreator {

    @Autowired
    UserService userService;

    @CrossOrigin
    @RequestMapping(value = "/sign_up", method = RequestMethod.POST)
    public ResponseEntity<ApiResponse<String>> signUp(@RequestBody AppUserDto appUserDto) {
        try {
            userService.createUser(appUserDto);
        } catch (Exception e) {
            return createBadResponse(e.getMessage());
        }
        return createGoodResponse();
    }

}
