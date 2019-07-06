package com.emp.crud.exception;

public class ApplicationException extends Exception {

	private static final long serialVersionUID = 1L;
	
	private String errorMessage;
	
	public ApplicationException(String errorMessage) {
		super(errorMessage);
		this.setErrorMessage(errorMessage);
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
