package com.cg.hims.exceptions;

public class ErrorDetails {
	
	private String message;
	
	public ErrorDetails() {
		super();
	}

	public ErrorDetails(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "ErrorDetails [message=" + message + "]";
	}

	
	
}