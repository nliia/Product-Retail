package com.pm.productretail.service;

import com.pm.productretail.dto.DepartmentDto;
import com.pm.productretail.dto.SignUpDto;
import com.pm.productretail.entity.AppUser;

import java.util.List;

public interface UserService {
    void createUser(SignUpDto signUpDto) throws Exception;

    AppUser findOneByPhoneNumber(String phone);

    AppUser findOneByUsername(String username);

    List<DepartmentDto> findUserDepartments(AppUser currentUser);
}
