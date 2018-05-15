package com.pm.productretail.service.impl;

import com.pm.productretail.dto.MessageDto;
import com.pm.productretail.dto.response.MessageResponseDto;
import com.pm.productretail.entity.AppUser;
import com.pm.productretail.entity.Message;
import com.pm.productretail.repository.AppUserRepository;
import com.pm.productretail.repository.MessageRepository;
import com.pm.productretail.service.MessageService;
import com.pm.productretail.service.SecurityService;
import com.pm.productretail.util.Errors;
import com.pm.productretail.util.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
		AppUser sender = securityService.getCurrentUser();

		if (validateRecipient(sender.getRole(), recipient.getRole())) {
			Message message = new Message();
			message.setText(messageDto.getText());
			message.setSender(sender);

			messageRepository.save(message);
		} else {
			throw new Exception(Errors.INCORRECT_RECIPIENT);
		}
	}

	@Override
	public List<MessageResponseDto> findMessagesForCurrentUser() {
		AppUser currentUser = securityService.getCurrentUser();
		return messageRepository.findAllByRecipient(currentUser).stream()
				.map(message -> new MessageResponseDto(message.getText(), message.getSender()))
				.collect(Collectors.toList());
	}

	private boolean validateRecipient(Role senderRole, Role recipientRole) {
		if (senderRole == Role.SELLER && (recipientRole == senderRole || recipientRole == Role.STUFF_MANAGER)) {
			return true;
		} else if (senderRole == Role.STUFF_MANAGER && (recipientRole == Role.SELLER || recipientRole == Role.SHOP_HEAD)) {
			return true;
		} else if (senderRole == Role.SHOP_HEAD && (recipientRole == Role.STUFF_MANAGER || recipientRole == Role.SUPERUSER)) {
			return true;
		} else if (senderRole == Role.WAREHOUSE_WORKER && (recipientRole == Role.WAREHOUSE_HEAD || recipientRole == senderRole)) {
			return true;
		} else if (senderRole == Role.WAREHOUSE_HEAD && (recipientRole == Role.WAREHOUSE_WORKER || recipientRole == Role.SUPERUSER)) {
			return true;
		} else if (senderRole == Role.SUPERUSER && (recipientRole == Role.WAREHOUSE_HEAD || recipientRole == Role.SHOP_HEAD)) {
			return true;
		}
		return false;
	}
}
