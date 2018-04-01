package com.pm.productretail.repository;

import com.pm.productretail.entity.DepartmentLinkItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentLinkItemRepository extends JpaRepository<DepartmentLinkItem, Long> {
}
