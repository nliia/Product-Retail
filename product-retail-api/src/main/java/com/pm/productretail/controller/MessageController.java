package com.pm.productretail.controller;

import com.pm.productretail.dto.MessageDto;
import com.pm.productretail.service.MessageService;
import com.pm.productretail.util.ApiResponse;
import com.pm.productretail.util.ResponseCreator;
import io.swagger.annotations.ApiImplicitParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController extends ResponseCreator {

	@Autowired
	private MessageService messageService;

	@ApiImplicitParam(name = "Authorization", paramType = "header", required = true, dataType = "string")
	@RequestMapping(value = "/send", method = RequestMethod.POST)
	public ResponseEntity<ApiResponse<String>> saveMessage(@RequestBody MessageDto messageDto) {
		try {
			messageService.save(messageDto);
		} catch (Exception e) {
			return createBadResponse(e.getMessage());
		}
		return createGoodResponse();
	}
}
