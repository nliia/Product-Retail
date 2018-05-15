package com.pm.productretail.service;

import com.pm.productretail.dto.MessageDto;
import com.pm.productretail.dto.response.MessageResponseDto;

import java.util.List;

public interface MessageService {
	void save(MessageDto messageDto) throws Exception;

	List<MessageResponseDto> findMessagesForCurrentUser();
}
