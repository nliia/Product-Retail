package com.pm.productretail.service;

import com.pm.productretail.SignInJson;
import com.pm.productretail.SignUpJson;

public interface UserService {
    void createUser(SignUpJson signUpJson);

    String findUserAndGetUsername(SignInJson signInJson);
}
