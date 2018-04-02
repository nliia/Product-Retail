package com.pm.productretail.dto.response;

/**
 * @author lnurullina
 */
public class AppUserResponseDto {

    private String username;
    private String name;
    private String surname;
    private String phoneNumber;
    private Long department_id;
    private String role;
    private Boolean is_superuser;

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
}
