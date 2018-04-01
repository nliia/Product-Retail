package com.pm.productretail.repository;

import com.pm.productretail.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    AppUser findOneByUsername(String username);
    AppUser findOneByPhoneNumber(String phoneNumber);
    AppUser findOneById(Long id);
}
