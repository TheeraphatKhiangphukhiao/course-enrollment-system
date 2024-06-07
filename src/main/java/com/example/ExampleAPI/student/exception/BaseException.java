package com.example.ExampleAPI.student.exception;

import org.springframework.http.HttpStatus;

public abstract class BaseException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4342352339788058650L;
	
	private final HttpStatus status;

	public BaseException(String code) {
		super(code);
		this.status = HttpStatus.EXPECTATION_FAILED;
	}

	public BaseException(String code, HttpStatus status) {
		super(code);
		this.status = status;
	}
	
	public HttpStatus getHttpStatus() {
		return status;
	}
	
}
