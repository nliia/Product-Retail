package com.pm.productretail.controller;

import com.pm.productretail.dto.MessageDto;
import com.pm.productretail.dto.response.MessageResponseDto;
import com.pm.productretail.service.MessageService;
import com.pm.productretail.util.ApiResponse;
import com.pm.productretail.util.ResponseCreator;
import io.swagger.annotations.ApiImplicitParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

	@ApiImplicitParam(name = "Authorization", paramType = "header", required = true, dataType = "string")
	@RequestMapping(value = "/messages/{userId}", method = RequestMethod.GET)
	public ResponseEntity<ApiResponse<List<MessageResponseDto>>> getMessages(@PathVariable Long userId) {
		return createGoodResponse(messageService.findMessagesForCurrentUser(userId));
	}
}
