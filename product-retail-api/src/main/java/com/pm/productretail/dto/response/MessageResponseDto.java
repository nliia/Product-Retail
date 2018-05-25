package com.pm.productretail.dto.response;

import com.pm.productretail.entity.AppUser;

import java.util.Date;

public class MessageResponseDto {
	private String text;
	private AppUser sender;
	private AppUser recipient;
	private Date date;

	public MessageResponseDto(String text, AppUser sender, AppUser recipient, Date date) {
		this.text = text;
		this.sender = sender;
		this.recipient = recipient;
		this.date = date;
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
