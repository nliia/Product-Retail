package com.pm.productretail.dto.response;

import com.pm.productretail.entity.AppUser;
import com.pm.productretail.util.Role;

/**
 * @author lnurullina
 */
public class AppUserResponseDto {
    private Long id;
    private String username;
    private String name;
    private String surname;
    private String phone_number;
    private Long department_id;
    private String role;
    private Boolean is_superuser;

    public AppUserResponseDto(AppUser appUser) {
        this.id = appUser.getId();
        this.username = appUser.getUsername();
        this.name = appUser.getName();
        this.surname = appUser.getSurname();
        this.phone_number = appUser.getPhoneNumber();
        if (appUser.getDepartment() != null)
            this.department_id = appUser.getDepartment().getId();
        Role role = appUser.getRole();
        if (role != null) {
            this.role = role.getName();
        }
        this.is_superuser = appUser.getSuperuser();

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

    public String getPhoneNumber() {
        return phone_number;
    }

    public void setPhoneNumber(String phone_number) {
        this.phone_number = phone_number;
    }

    public Long getDepartmentId() {
        return department_id;
    }

    public void setDepartmentId(Long department_id) {
        this.department_id = department_id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Boolean getSuperuser() {
        return is_superuser;
    }

    public void setSuperuser(Boolean superuser) {
        is_superuser = superuser;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
