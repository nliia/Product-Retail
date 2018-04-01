package com.pm.productretail.service.impl;

import com.pm.productretail.dto.DepartmentDto;
import com.pm.productretail.entity.Department;
import com.pm.productretail.repository.DepartmentRepository;
import com.pm.productretail.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    DepartmentRepository departmentRepository;

    @Override
    public List<DepartmentDto> findAllDepartments() {
        List<DepartmentDto> departmentList = new ArrayList<>();
        List<Department> departments = departmentRepository.findAll();
        for(Department department: departments){
            departmentList.add(new DepartmentDto(department));
        }
        return departmentList;
    }

    @Override
    public List<DepartmentDto> getDepartmentAndParent(Department department) {
        List<DepartmentDto> departmentList = new ArrayList<>();
        departmentList.add(new DepartmentDto(department));
        if(department.getParent()!=null){
            departmentList.add(new DepartmentDto(department.getParent()));
        }
        return departmentList;
    }
}
