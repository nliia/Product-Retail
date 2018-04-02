package com.pm.productretail.service;

import com.pm.productretail.dto.OrderedItemDto;

import java.util.List;

public interface OrderService {
	void createNewOrder(List<OrderedItemDto> orderedItemDtoList);
}
