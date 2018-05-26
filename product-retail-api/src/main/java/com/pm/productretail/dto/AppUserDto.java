package com.pm.productretail.dto;

import com.pm.productretail.util.Role;

public class AppUserDto {

    private String username;
    private String password;
    private String name;
    private String surname;
    private String phoneNumber;
    private Long department_id;
    private Role role;
    private Boolean is_superuser;

    private String status;

    public Boolean getIs_superuser() {
        return is_superuser;
    }

    public void setIs_superuser(Boolean is_superuser) {
        this.is_superuser = is_superuser;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Long getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(Long department_id) {
        this.department_id = department_id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Boolean getSuperuser() {
        return is_superuser;
    }

    public void setSuperuser(Boolean superuser) {
        is_superuser = superuser;
    }
}
