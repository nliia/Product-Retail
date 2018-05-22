package com.pm.productretail.repository;

import com.pm.productretail.entity.AppUser;
import com.pm.productretail.entity.Department;
import com.pm.productretail.util.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    AppUser findOneByUsername(String username);

    AppUser findOneByPhoneNumber(String phoneNumber);

    List<AppUser> findAllByDepartment(Department department);

    @Query(value = "SELECT * FROM users WHERE UPPER(concat(name, ' ', surname)) LIKE UPPER(concat('%', :name, '%')) ORDER BY ID", nativeQuery = true)
    List<AppUser> findByName(@Param("name") String name);

    @Override
    Page<AppUser> findAll(Pageable pageable);

    List<AppUser> findAllByRole(Role role);
}
