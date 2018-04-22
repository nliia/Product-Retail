package com.pm.productretail.service.impl;

import com.pm.productretail.dto.ItemDto;
import com.pm.productretail.dto.response.ItemInfoResponseDto;
import com.pm.productretail.dto.response.ItemResponseDto;
import com.pm.productretail.entity.Department;
import com.pm.productretail.entity.Item;
import com.pm.productretail.repository.ItemRepository;
import com.pm.productretail.service.DepartmentService;
import com.pm.productretail.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    DepartmentService departmentService;

    @Override
    public void addNewItem(ItemDto itemDto) {
        Item item = new Item();
        item.setName(itemDto.getName());
        item.setPrice(itemDto.getPrice());
        itemRepository.save(item);
    }

    @Override
    public void deleteItem(Long id) {
        itemRepository.delete(itemRepository.getOne(id));
    }

    @Override
    public List<ItemResponseDto> getAllItemsByName(String name, Integer page) {
        List<ItemResponseDto> departmentItemResponseDtoList = new ArrayList<>();
        List<Item> itemList = itemRepository.findAllByNameLikeIgnoreCaseOrderByName(name);
        Integer number = (page-1)*10;
        for(int i=number;i<number+10;i++){
            departmentItemResponseDtoList.add(new ItemResponseDto(itemList.get(i)));
        }
        return departmentItemResponseDtoList;
    }

    @Override
    public ItemInfoResponseDto getItemInfo(Long id, Department department) {
        Item item = itemRepository.getOne(id);
        ItemInfoResponseDto itemInfoResponseDto = new ItemInfoResponseDto(item);
        itemInfoResponseDto.setCurrentDepartmentCount(departmentService.getItemCountByDepartment(item,department));
        if(department.getParent()!=null){
            itemInfoResponseDto.setWarehouseCount(departmentService.getItemCountByDepartment(item,department.getParent()));
        }
        return itemInfoResponseDto;
    }
}
