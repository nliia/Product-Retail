package com.pm.productretail.service.impl;

import com.pm.productretail.dto.AppUserDto;
import com.pm.productretail.dto.DepartmentDto;
import com.pm.productretail.dto.response.AppUserResponseDto;
import com.pm.productretail.entity.AppUser;
import com.pm.productretail.repository.AppUserRepository;
import com.pm.productretail.repository.DepartmentRepository;
import com.pm.productretail.service.DepartmentService;
import com.pm.productretail.service.SecurityService;
import com.pm.productretail.service.UserService;
import com.pm.productretail.util.Errors;
import com.pm.productretail.util.Role;
import com.pm.productretail.util.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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

    private static final int PAGE_SIZE = 10;
    @Autowired
    private AppUserRepository appUserRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private Validator validator;
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private SecurityService securityService;

    @Override
    public void createUser(AppUserDto appUserDto) throws Exception {
        if (validator.isValidSignUpData(appUserDto)) {
            if (appUserRepository.findOneByUsername(appUserDto.getUsername()) != null)
                throw new Exception(Errors.USER_ALREADY_EXISTS);
            AppUser user = new AppUser();
            user.setUsername(appUserDto.getUsername());
            user.setPassword(bCryptPasswordEncoder.encode(appUserDto.getPassword()));
            user.setRole(appUserDto.getRole());
            user.setName(appUserDto.getName());
            user.setSurname(appUserDto.getSurname());
            user.setPhoneNumber(appUserDto.getPhoneNumber());
            user.setStatus(appUserDto.getStatus());
            user.setSuperuser(appUserDto.getSuperuser());
            user.setDepartment(departmentService.getDepartment(appUserDto.getDepartment_id()));
            appUserRepository.save(user);
        }
    }

    @Override
    public List<AppUserResponseDto> getICanWrite() {
        AppUser user = securityService.getCurrentUser();

        List<AppUser> usersCanWrite = new ArrayList<>();

        if (user.getRole() == Role.SUPERUSER) {
            usersCanWrite.addAll(appUserRepository.findAllByRole(Role.SHOP_HEAD));
            usersCanWrite.addAll(appUserRepository.findAllByRole(Role.WAREHOUSE_HEAD));
        } else if (user.getRole() == Role.SHOP_HEAD) {
            usersCanWrite.addAll(appUserRepository.findAllByRoleAndDepartment(Role.STUFF_MANAGER, user.getDepartment()));
            usersCanWrite.addAll(appUserRepository.findAllByRole(Role.SUPERUSER));
        } else if (user.getRole() == Role.WAREHOUSE_HEAD) {
            usersCanWrite.addAll(appUserRepository.findAllByRoleAndDepartment(Role.WAREHOUSE_WORKER, user.getDepartment()));
            usersCanWrite.addAll(appUserRepository.findAllByRole(Role.SUPERUSER));
        } else if (user.getRole() == Role.STUFF_MANAGER) {
            usersCanWrite.addAll(appUserRepository.findAllByRoleAndDepartment(Role.SHOP_HEAD, user.getDepartment()));
            usersCanWrite.addAll(appUserRepository.findAllByRoleAndDepartment(Role.SELLER, user.getDepartment()));
        } else if (user.getRole() == Role.SELLER) {
            usersCanWrite.addAll(appUserRepository.findAllByRoleAndDepartment(Role.STUFF_MANAGER, user.getDepartment()));
        } else if (user.getRole() == Role.WAREHOUSE_WORKER) {
            usersCanWrite.addAll(appUserRepository.findAllByRoleAndDepartment(Role.WAREHOUSE_HEAD, user.getDepartment()));
        }

        return usersCanWrite.stream()
                .map(u -> new AppUserResponseDto(u))
                .collect(Collectors.toList());
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
        if (currentUser.getRole().toString().matches(".*_HEAD")) {
            return departmentService.getDepartmentAndParent(currentUser.getDepartment());
        }
        List<DepartmentDto> departmentDtoList = new ArrayList<>();
        departmentDtoList.add(new DepartmentDto(currentUser.getDepartment()));
        return departmentDtoList;
    }

    @Override
    public List<AppUserResponseDto> findAllByDepartment(Long depId) {
        return appUserRepository.findAllByDepartment(departmentRepository.getOne(depId))
                .stream()
                .map(AppUserResponseDto::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<AppUserResponseDto> findAllByName(String name) {
        return appUserRepository.findByName(name)
                .stream()
                .map(AppUserResponseDto::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<AppUserResponseDto> getPage(int page) {
        Page<AppUser> users = appUserRepository.findAll(PageRequest.of(page, PAGE_SIZE));
        return users.getContent()
                .stream()
                .map(AppUserResponseDto::new)
                .collect(Collectors.toList());
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser user = appUserRepository.findOneByUsername(username);
        if (user == null)
            throw new UsernameNotFoundException(username);
        return new User(user.getUsername(), user.getPassword(), emptyList());
    }

}
