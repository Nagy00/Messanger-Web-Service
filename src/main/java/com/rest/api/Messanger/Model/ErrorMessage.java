package com.rest.api.Messanger.Model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ErrorMessage {
	
	private String message;
	
	private int stausCode;
	
	private String reference;
	

	public ErrorMessage() {
		super();
	}

	public ErrorMessage(String message, int stausCode, String reference) {
		super();
		this.message = message;
		this.stausCode = stausCode;
		this.reference = reference;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getStausCode() {
		return stausCode;
	}

	public void setStausCode(int stausCode) {
		this.stausCode = stausCode;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}
}
