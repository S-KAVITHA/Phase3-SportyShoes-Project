package com.example.demo.exception.handling;

public class BookNotFoundException extends Exception {

	
	private static final long serialVersionUID = -9079454849611061074L;

	public BookNotFoundException() {
		super();
	}

	public BookNotFoundException(final String message) {
		super(message);
	}

	
	
}
