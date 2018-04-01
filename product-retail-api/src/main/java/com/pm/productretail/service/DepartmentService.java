package com.pm.productretail.service;

import com.pm.productretail.dto.DepartmentDto;
import com.pm.productretail.entity.Department;

import java.util.List;

public interface DepartmentService {
    List<DepartmentDto> findAllDepartments();

    List<DepartmentDto> getDepartmentAndParent(Department department);
}
