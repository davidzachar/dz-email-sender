package com.email.sender.api.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class SendRequest {

	@Email
	private String from;
	@Email
	private String to;
	@Email
	private String cc;
	@Email
	private String bcc;
	@NotBlank
	private String subject;
	@NotBlank
	private String body;
	
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getCc() {
		return cc;
	}
	public void setCc(String cc) {
		this.cc = cc;
	}
	public String getBcc() {
		return bcc;
	}
	public void setBcc(String bcc) {
		this.bcc = bcc;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	
}
