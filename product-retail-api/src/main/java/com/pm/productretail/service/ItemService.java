package com.pm.productretail.service;

import com.pm.productretail.dto.ItemDto;
import com.pm.productretail.dto.response.ItemInfoResponseDto;
import com.pm.productretail.dto.response.ItemResponseDto;
import com.pm.productretail.entity.Department;

import java.util.List;

public interface ItemService {
    void addNewItem(ItemDto itemDto);

    void deleteItem(Long id);

    List<ItemResponseDto> getAllItemsByName(String name, Integer page);

    ItemInfoResponseDto getItemInfo(Long id, Department department);
}
