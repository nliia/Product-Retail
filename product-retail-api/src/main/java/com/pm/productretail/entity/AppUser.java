package com.pm.productretail.entity;

import com.pm.productretail.util.Role;

import javax.persistence.*;

@Entity
@Table(name = "users")
@SequenceGenerator(name = "userSeq", sequenceName = "userSeq", initialValue = 50)
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userSeq")
    private Long id;
    private String username;
    private String password;
    private String name;
    private String surname;
    private String phoneNumber;
    private String status;

    @ManyToOne
    @JoinColumn
    private Department department;

    @Enumerated(EnumType.STRING)
    private Role role;
    private Boolean isSuperuser;

    @PrePersist
    void preInsert() {
        if (this.isSuperuser == null)
            this.isSuperuser = false;
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

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setRole(String role) { this.role = Role.findByValue(role); }

    public Boolean getSuperuser() {
        return isSuperuser;
    }

    public void setSuperuser(Boolean superuser) {
        isSuperuser = superuser;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
