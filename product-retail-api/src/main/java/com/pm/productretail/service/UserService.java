package com.pm.productretail.service;

import com.pm.productretail.dto.SignUpDto;
import com.pm.productretail.entity.AppUser;

public interface UserService {
    void createUser(SignUpDto signUpDto) throws Exception;

    AppUser findOneByEmail(String email);
}
