package com.hospisoft.store.controller;

public class MyResourceNotFoundException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3774273064505171697L;

	public MyResourceNotFoundException() {
		super();
	}

	public MyResourceNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public MyResourceNotFoundException(String message) {
		super(message);
	}

	public MyResourceNotFoundException(Throwable cause) {
		super(cause);
	}
}
