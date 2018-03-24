package com.pm.productretail.service;

import com.pm.productretail.dto.SignInDto;
import com.pm.productretail.dto.SignUpDto;
import com.pm.productretail.entity.User;

public interface UserService {
    void createUser(SignUpDto signUpDto);

    String findUserAndGetUsername(SignInDto signInDto);
    User findOneByEmail(String email);
}
