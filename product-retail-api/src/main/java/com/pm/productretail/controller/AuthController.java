package com.pm.productretail.controller;


import com.pm.productretail.SignInJson;
import com.pm.productretail.SignUpJson;
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
    public String signUp(@RequestBody SignUpJson signUpJson){
        userService.createUser(signUpJson);
        return "Success";
    }

    @RequestMapping("/sign_in")
    public String signIn(@RequestBody SignInJson signInJson){
        return userService.findUserAndGetUsername(signInJson);
    }

}
