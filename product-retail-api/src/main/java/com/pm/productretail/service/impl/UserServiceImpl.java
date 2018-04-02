package com.pm.productretail.service.impl;

import com.pm.productretail.dto.AppUserDto;
import com.pm.productretail.dto.DepartmentDto;
import com.pm.productretail.dto.response.AppUserResponseDto;
import com.pm.productretail.entity.AppUser;
import com.pm.productretail.repository.AppUserRepository;
import com.pm.productretail.service.DepartmentService;
import com.pm.productretail.service.UserService;
import com.pm.productretail.util.Errors;
import com.pm.productretail.util.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private AppUserRepository appUserRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private Validator validator;
    @Autowired
    private DepartmentService departmentService;

    @Override
    public void createUser(AppUserDto appUserDto) throws Exception {
        if (validator.isValidSignUpData(appUserDto)) {
            if (appUserRepository.findOneByUsername(appUserDto.getUsername()) != null)
                throw new Exception(Errors.USER_ALREADY_EXISTS);
            AppUser user = new AppUser();
            user.setUsername(appUserDto.getUsername());
            user.setPassword(bCryptPasswordEncoder.encode(appUserDto.getPassword()));
            appUserRepository.save(user);
        }
    }

    @Override
    public AppUser findOneByPhoneNumber(String phone) {
        return appUserRepository.findOneByPhoneNumber(phone);
    }

    @Override
    public AppUser findOneByUsername(String username) {
        return appUserRepository.findOneByUsername(username);
    }

    @Override
    public List<DepartmentDto> findUserDepartments(AppUser currentUser) {
        if (currentUser.getSuperuser())
            return departmentService.findAllDepartments();
        if (currentUser.getRole().matches(".*_HEAD")) {
            return departmentService.getDepartmentAndParent(currentUser.getDepartment());
        }
        List<DepartmentDto> departmentDtoList = new ArrayList<>();
        departmentDtoList.add(new DepartmentDto(currentUser.getDepartment()));
        return departmentDtoList;
    }

    @Override
    public List<AppUserResponseDto> findAllByDepartment(Long depId) {
        return appUserRepository.findAllByDepartment(depId)
                .stream()
                .map(this::toAppUserResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser user = appUserRepository.findOneByUsername(username);
        if (user == null)
            throw new UsernameNotFoundException(username);
        return new User(user.getUsername(), user.getPassword(), emptyList());
    }

    private AppUserResponseDto toAppUserResponseDto(AppUser appUser) {
        AppUserResponseDto dto = new AppUserResponseDto();
        dto.setName(appUser.getName());
        dto.setSurname(appUser.getSurname());
        dto.setDepartment_id(appUser.getDepartment().getId());
        dto.setPhoneNumber(appUser.getPhoneNumber());
        dto.setRole(appUser.getRole());
        dto.setSuperuser(appUser.getSuperuser());
        dto.setUsername(appUser.getUsername());
        return dto;
    }
}
