package com.pm.productretail.service;

import com.pm.productretail.dto.MessageDto;

public interface MessageService {
	void save(MessageDto messageDto) throws Exception;
}
