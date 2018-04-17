package com.pm.productretail.service.impl;

import com.pm.productretail.dto.MessageDto;
import com.pm.productretail.entity.AppUser;
import com.pm.productretail.entity.Message;
import com.pm.productretail.repository.AppUserRepository;
import com.pm.productretail.repository.MessageRepository;
import com.pm.productretail.service.MessageService;
import com.pm.productretail.service.SecurityService;
import com.pm.productretail.util.Errors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService {

	@Autowired
	private AppUserRepository appUserRepository;

	@Autowired
	private SecurityService securityService;

	@Autowired
	private MessageRepository messageRepository;

	@Override
	public void save(MessageDto messageDto) throws Exception {
		AppUser recipient = appUserRepository.getOne(messageDto.getRecipient_id());
		if (!recipient.getSuperuser())
			throw new Exception(Errors.INCORRECT_RECIPIENT);
		Message message = new Message();
		message.setText(messageDto.getText());
		message.setSender(securityService.getCurrentUser());

		messageRepository.save(message);
	}
}
