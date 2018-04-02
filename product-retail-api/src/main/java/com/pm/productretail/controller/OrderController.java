package com.pm.productretail.controller;

import com.pm.productretail.dto.OrderedItemDto;
import com.pm.productretail.service.OrderService;
import com.pm.productretail.util.ApiResponse;
import com.pm.productretail.util.ResponseCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController extends ResponseCreator {

	@Autowired
	private OrderService orderService;

	@RequestMapping(value = "/order", method = RequestMethod.POST)
	public ResponseEntity<ApiResponse<String>> createOrder(@RequestBody List<OrderedItemDto> orderedItemDtoList) {
		orderService.createNewOrder(orderedItemDtoList);
		return createGoodResponse();
	}
}
