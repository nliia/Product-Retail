package com.pm.productretail.dto.response;

import com.pm.productretail.entity.AppUser;

import java.util.Date;

public class MessageResponseDto {
	private String text;
	private AppUserResponseDto sender;
	private AppUserResponseDto recipient;
	private Date date;

	public MessageResponseDto(String text, AppUser sender, AppUser recipient, Date date) {
		this.text = text;
		this.sender = new AppUserResponseDto(sender);
		this.recipient = new AppUserResponseDto(recipient);
		this.date = date;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public AppUserResponseDto getSender() {
		return sender;
	}

	public void setSender(AppUserResponseDto sender) {
		this.sender = sender;
	}

	public AppUserResponseDto getRecipient() {
		return recipient;
	}

	public void setRecipient(AppUserResponseDto recipient) {
		this.recipient = recipient;
	}
}
