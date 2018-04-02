package com.pm.productretail.repository;

import com.pm.productretail.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    AppUser findOneByUsername(String username);

    AppUser findOneByPhoneNumber(String phoneNumber);

    List<AppUser> findAllByDepartment(Long depId);
}
