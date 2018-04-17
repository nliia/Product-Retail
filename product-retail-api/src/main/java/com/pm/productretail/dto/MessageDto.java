package com.pm.productretail.dto;

public class MessageDto {
	private Long recipient_id;
	private String text;

	public Long getRecipient_id() {
		return recipient_id;
	}

	public void setRecipient_id(Long recipient_id) {
		this.recipient_id = recipient_id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
