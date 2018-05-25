package com.pm.productretail.dto.response;

import com.pm.productretail.entity.AppUser;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class MessageResponseDto {
	private String text;
	private AppUserResponseDto sender;
	private AppUserResponseDto recipient;
	private String date;

	public MessageResponseDto(String text, AppUser sender, AppUser recipient, Date date) {
		this.text = text;
		this.sender = new AppUserResponseDto(sender);
		this.recipient = new AppUserResponseDto(recipient);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
		dateFormat.setTimeZone(TimeZone.getTimeZone("GMT+03"));
		this.date = dateFormat.format(date);
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
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
