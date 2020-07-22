package com.dineshtech.multiplex.exception;

public class RequiredFieldsMissingException extends Exception {

	public RequiredFieldsMissingException() {
		super();
	}

	public RequiredFieldsMissingException(final String message) {
		super(message);
	}

}
