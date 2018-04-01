package com.pm.productretail.controller;

import com.pm.productretail.dto.SignUpDto;
import com.pm.productretail.service.UserService;
import com.pm.productretail.util.ApiResponse;
import com.pm.productretail.util.ResponseCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController extends ResponseCreator {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/sign_up", method = RequestMethod.POST)
    public ResponseEntity<ApiResponse<String>> signUp(@RequestBody SignUpDto signUpDto) {
        try {
            userService.createUser(signUpDto);
        } catch (Exception e) {
            return createBadResponse(e.getMessage());
        }
        return createGoodResponse();
    }

}
