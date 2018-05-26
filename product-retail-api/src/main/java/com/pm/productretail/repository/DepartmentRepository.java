package com.pm.productretail.repository;

import com.pm.productretail.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
	Department findByIsWarehouseTrue();
}
