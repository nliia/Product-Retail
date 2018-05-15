package com.pm.productretail.dto.response;

import com.pm.productretail.dto.DepartmentDto;
import com.pm.productretail.entity.AppUser;
import com.pm.productretail.util.Role;

import java.util.List;

/**
 * @author lnurullina
 */
public class SignInResponseDto {
    private String token;
    private Long id;
    private String username;
    private String name;
    private String surname;
    private Boolean is_superuser;
    private String phone_number;
    private String role;
    private List<DepartmentDto> accessible_departments;

    public SignInResponseDto(AppUser appUser, List<DepartmentDto> departments, String jwtToken) {
        accessible_departments = departments;
        token = jwtToken;
        id = appUser.getId();
        username = appUser.getUsername();
        name = appUser.getName();
        surname = appUser.getSurname();
        is_superuser = appUser.getSuperuser();
        phone_number = appUser.getPhoneNumber();
        Role role = appUser.getRole();
        if(role != null) {
            this.role = role.getName();
        }
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Boolean getIs_superuser() {
        return is_superuser;
    }

    public void setIs_superuser(Boolean is_superuser) {
        this.is_superuser = is_superuser;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<DepartmentDto> getAccessible_departments() {
        return accessible_departments;
    }

    public void setAccessible_departments(List<DepartmentDto> accessible_departments) {
        this.accessible_departments = accessible_departments;
    }
}
