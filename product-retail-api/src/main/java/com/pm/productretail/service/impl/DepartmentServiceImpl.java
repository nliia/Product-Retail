package com.pm.productretail.service.impl;

import com.pm.productretail.dto.DepartmentDto;
import com.pm.productretail.dto.DepartmentItemDto;
import com.pm.productretail.dto.response.ItemResponseDto;
import com.pm.productretail.entity.Department;
import com.pm.productretail.entity.DepartmentLinkItem;
import com.pm.productretail.entity.Item;
import com.pm.productretail.repository.DepartmentLinkItemRepository;
import com.pm.productretail.repository.DepartmentRepository;
import com.pm.productretail.repository.ItemRepository;
import com.pm.productretail.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    DepartmentRepository departmentRepository;
    @Autowired
    DepartmentLinkItemRepository departmentLinkItemRepository;
    @Autowired
    ItemRepository itemRepository;

    @Override
    public List<DepartmentDto> findAllDepartments() {
        List<DepartmentDto> departmentList = new ArrayList<>();
        List<Department> departments = departmentRepository.findAll();
        for (Department department : departments) {
            departmentList.add(new DepartmentDto(department));
        }
        return departmentList;
    }

    @Override
    public List<DepartmentDto> getDepartmentAndParent(Department department) {
        List<DepartmentDto> departmentList = new ArrayList<>();
        departmentList.add(new DepartmentDto(department));
        if (department.getParent() != null) {
            departmentList.add(new DepartmentDto(department.getParent()));
        }
        return departmentList;
    }

    @Override
    public List<ItemResponseDto> getItemsByDepartment(Long depId) {
        List<ItemResponseDto> items = new ArrayList<>();
        List<DepartmentLinkItem> tempItems = departmentLinkItemRepository.findAllByDepartment(departmentRepository.getOne(depId));
        for (DepartmentLinkItem item : tempItems) {
            items.add(new ItemResponseDto(item));
        }
        return items;
    }

    @Override
    public Long getItemCountByDepartment(Item item, Department department) {
        DepartmentLinkItem departmentLinkItem = departmentLinkItemRepository.findOneByItemAndDepartment(item, department);
        if (departmentLinkItem != null) {
            return departmentLinkItem.getCount();
        }
        return 0L;
    }

    @Override
    public void addItemToDepartment(DepartmentItemDto departmentItem) {
        Department department = departmentRepository.getOne(departmentItem.getDepartmnetId());
        Item item = itemRepository.getOne(departmentItem.getItemId());
        DepartmentLinkItem departmentLinkItem = new DepartmentLinkItem();
        departmentLinkItem.setDepartment(department);
        departmentLinkItem.setItem(item);
        departmentLinkItem.setCount(departmentItem.getCount());
        departmentLinkItemRepository.save(departmentLinkItem);
    }
}
