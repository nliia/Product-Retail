package com.pm.productretail.service;

import com.pm.productretail.dto.DepartmentDto;
import com.pm.productretail.dto.DepartmentItemDto;
import com.pm.productretail.dto.response.ItemResponseDto;
import com.pm.productretail.entity.Department;
import com.pm.productretail.entity.Item;

import java.util.List;

public interface DepartmentService {
    List<DepartmentDto> findAllDepartments();

    List<DepartmentDto> getDepartmentAndParent(Department department);

    List<ItemResponseDto> getItemsByDepartment(Long depId);
    Long getItemCountByDepartment(Item item, Department department);

    void addItemToDepartment(DepartmentItemDto departmentLinkItem);
}
