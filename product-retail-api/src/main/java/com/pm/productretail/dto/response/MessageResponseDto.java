package com.pm.productretail.dto.response;

import com.pm.productretail.entity.AppUser;

public class MessageResponseDto {
	private String text;
	private AppUser sender;

	public MessageResponseDto(String text, AppUser sender) {
		this.text = text;
		this.sender = sender;
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
}
