package com.pm.productretail.service;

import com.pm.productretail.dto.DepartmentDto;
import com.pm.productretail.dto.AppUserDto;
import com.pm.productretail.dto.response.AppUserResponseDto;
import com.pm.productretail.entity.AppUser;

import java.util.List;

public interface UserService {
    void createUser(AppUserDto appUserDto) throws Exception;

    AppUser findOneByPhoneNumber(String phone);

    AppUser findOneByUsername(String username);

    List<DepartmentDto> findUserDepartments(AppUser currentUser);

    List<AppUserResponseDto> findAllByDepartment(Long depId);

    List<AppUserResponseDto> findAllByName(String name);
}
