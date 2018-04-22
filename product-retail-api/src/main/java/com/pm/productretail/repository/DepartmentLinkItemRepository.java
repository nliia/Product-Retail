package com.pm.productretail.repository;

import com.pm.productretail.entity.Department;
import com.pm.productretail.entity.DepartmentLinkItem;
import com.pm.productretail.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentLinkItemRepository extends JpaRepository<DepartmentLinkItem, Long> {
    List<DepartmentLinkItem> findAllByDepartment(Department department);

    DepartmentLinkItem findOneByItemAndDepartment(Item item, Department department);
}
