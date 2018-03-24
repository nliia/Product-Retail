package com.pm.productretail.controller;


import com.pm.productretail.dto.SignInDto;
import com.pm.productretail.dto.SignUpDto;
import com.pm.productretail.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    UserService userService;

    @RequestMapping("/sign_up")
    public String signUp(@RequestBody SignUpDto signUpDto){
        userService.createUser(signUpDto);
        return "Success";
    }

    @RequestMapping("/sign_in")
    public String signIn(@RequestBody SignInDto signInDto){
        return userService.findUserAndGetUsername(signInDto);
    }

}
