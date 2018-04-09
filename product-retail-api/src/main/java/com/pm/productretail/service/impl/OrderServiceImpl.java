package com.pm.productretail.service.impl;

import com.pm.productretail.dto.OrderedItemDto;
import com.pm.productretail.entity.Item;
import com.pm.productretail.entity.Order;
import com.pm.productretail.entity.OrderLinkItem;
import com.pm.productretail.repository.DepartmentRepository;
import com.pm.productretail.repository.ItemRepository;
import com.pm.productretail.repository.OrderLinkItemRepository;
import com.pm.productretail.repository.OrderRepository;
import com.pm.productretail.service.OrderService;
import com.pm.productretail.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private ItemRepository itemRepository;

	@Autowired
	private OrderLinkItemRepository orderLinkItemRepository;

	@Autowired
	private SecurityService securityService;

	@Autowired
	private DepartmentRepository departmentRepository;

	@Override
	public void createNewOrder(List<OrderedItemDto> orderedItemDtoList) {
		Order order = new Order();
		order.setOrderCreator(securityService.getCurrentUser());
		order.setOrderReciever(departmentRepository.findByIsWarehouseTrue());
		order.setStatus("In process");
		order = orderRepository.save(order);
		for (OrderedItemDto itemDto : orderedItemDtoList) {
			Item item = itemRepository.getOne(itemDto.getItem_id());
			OrderLinkItem orderLinkItem = new OrderLinkItem();
			orderLinkItem.setOrder(order);
			orderLinkItem.setItem(item);
			orderLinkItem.setCount(itemDto.getCount());
			orderLinkItemRepository.save(orderLinkItem);
		}
	}
}
