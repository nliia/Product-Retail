package com.pm.productretail.controller;


import com.pm.productretail.dto.SignInDto;
import com.pm.productretail.dto.SignUpDto;
import com.pm.productretail.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/sign_up", method = RequestMethod.POST)
    public String signUp(@RequestBody SignUpDto signUpDto){
        userService.createUser(signUpDto);
        return "Success";
    }

    @RequestMapping(value = "/sign_in", method = RequestMethod.POST)
    public String signIn(@RequestBody SignInDto signInDto){
        return userService.findUserAndGetUsername(signInDto);
    }

}
