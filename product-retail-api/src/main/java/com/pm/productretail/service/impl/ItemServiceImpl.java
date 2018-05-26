package com.pm.productretail.service.impl;

import com.pm.productretail.dto.ItemDto;
import com.pm.productretail.dto.response.ItemInfoResponseDto;
import com.pm.productretail.dto.response.ItemResponseDto;
import com.pm.productretail.entity.Department;
import com.pm.productretail.entity.DepartmentLinkItem;
import com.pm.productretail.entity.Image;
import com.pm.productretail.entity.Item;
import com.pm.productretail.repository.DepartmentLinkItemRepository;
import com.pm.productretail.repository.ItemRepository;
import com.pm.productretail.service.DepartmentService;
import com.pm.productretail.service.ImageService;
import com.pm.productretail.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemService {

    private static final int PAGE_SIZE = 10;
    @Autowired
    ItemRepository itemRepository;

    @Autowired
    DepartmentService departmentService;

    @Autowired
    DepartmentLinkItemRepository departmentLinkItemRepository;

    @Autowired
    ImageService imageService;

    @Override
    public void addNewItem(ItemDto itemDto) {
        Item item = new Item();
        item.setName(itemDto.getName());
        item.setPrice(itemDto.getPrice());
        if (itemDto.getItemImageId() != null) {
            Image image = imageService.getOneById(itemDto.getItemImageId());
            item.setImage(image);
        }
        itemRepository.save(item);
        DepartmentLinkItem departmentLinkItem = new DepartmentLinkItem();
        Department department = departmentService.getDepartment(1L);
        departmentLinkItem.setCount(itemDto.getCount());
        departmentLinkItem.setItem(itemRepository.getByName(item.getName()));
        departmentLinkItem.setDepartment(department);
        departmentLinkItemRepository.save(departmentLinkItem);
    }

    @Override
    public void deleteItem(Long id) {
        itemRepository.delete(itemRepository.getOne(id));
    }

    @Override
    public List<ItemResponseDto> getAllItemsByName(String name, Integer page) {
        List<ItemResponseDto> departmentItemResponseDtoList = new ArrayList<>();
        List<Item> itemList = itemRepository.findAllByNameLikeIgnoreCaseOrderByName(name);
        Integer number = (page - 1) * 10;
        for (int i = number; i < number + 10; i++) {
            departmentItemResponseDtoList.add(new ItemResponseDto(itemList.get(i)));
        }
        return departmentItemResponseDtoList;
    }

    @Override
    public ItemInfoResponseDto getItemInfo(Long id, Department department) {
        Item item = itemRepository.getOne(id);
        ItemInfoResponseDto itemInfoResponseDto = new ItemInfoResponseDto(item);
        itemInfoResponseDto.setCurrentDepartmentCount(departmentService.getItemCountByDepartment(item, department));
        if (department.getParent() != null) {
            itemInfoResponseDto.setWarehouseCount(departmentService.getItemCountByDepartment(item, department.getParent()));
        }
        return itemInfoResponseDto;
    }

    @Override
    public List<ItemResponseDto> getPage(int page) {
        Page<Item> items = itemRepository.findAll(PageRequest.of(page, PAGE_SIZE, Sort.Direction.ASC, "name"));
        return items.getContent()
                .stream()
                .map(ItemResponseDto::new)
                .collect(Collectors.toList());
    }

    @Override
    public void shipItem(Long itemId, Long itemCount, Long departmentId, Long destinationDepartmentId) {
        Item item = itemRepository.getOne(itemId);
        Department department = departmentService.getDepartment(departmentId);
        Department destinationDepartment = departmentService.getDepartment(destinationDepartmentId);
        DepartmentLinkItem departmentLinkItem = departmentLinkItemRepository.findOneByItemAndDepartment(item, department);
        departmentLinkItem.setCount(departmentLinkItem.getCount() - itemCount);
        DepartmentLinkItem destinationDepartmentLinkItem = departmentLinkItemRepository.findOneByItemAndDepartment(item, destinationDepartment);
        if (destinationDepartmentLinkItem != null) {
            destinationDepartmentLinkItem.setCount(destinationDepartmentLinkItem.getCount() + itemCount);
        } else {
            destinationDepartmentLinkItem = new DepartmentLinkItem();
            destinationDepartmentLinkItem.setDepartment(destinationDepartment);
            destinationDepartmentLinkItem.setItem(item);
            destinationDepartmentLinkItem.setCount(itemCount);
        }
        departmentLinkItemRepository.save(destinationDepartmentLinkItem);
        departmentLinkItemRepository.save(departmentLinkItem);
    }

    @Override
    public void sellItem(Long itemId, Long itemCount, Long departmentId) {
        Item item = itemRepository.getOne(itemId);
        Department department = departmentService.getDepartment(departmentId);
        DepartmentLinkItem departmentLinkItem = departmentLinkItemRepository.findOneByItemAndDepartment(item, department);
        departmentLinkItem.setCount(departmentLinkItem.getCount() - itemCount);
        departmentLinkItemRepository.save(departmentLinkItem);
    }
}
