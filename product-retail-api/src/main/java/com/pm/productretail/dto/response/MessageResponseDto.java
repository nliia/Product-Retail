package com.pm.productretail.dto.response;

import com.pm.productretail.entity.AppUser;

public class MessageResponseDto {
	private String text;
	private AppUser sender;
	private AppUser recipient;

	public MessageResponseDto(String text, AppUser sender, AppUser recipient) {
		this.text = text;
		this.sender = sender;
		this.recipient = recipient;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public AppUser getSender() {
		return sender;
	}

	public void setSender(AppUser sender) {
		this.sender = sender;
	}

	public AppUser getRecipient() {
		return recipient;
	}

	public void setRecipient(AppUser recipient) {
		this.recipient = recipient;
	}
}
