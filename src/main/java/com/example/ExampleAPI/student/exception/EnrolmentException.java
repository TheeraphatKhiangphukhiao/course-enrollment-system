package com.example.ExampleAPI.student.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ResponseStatus(value = HttpStatus.NOT_FOUND)

public class EnrolmentException extends BaseException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EnrolmentException(String code, HttpStatus status) {
		super("status" + code);
	}

	public static EnrolmentException emptyEnrolment() {
		return new EnrolmentException("findEnrolment.notFound", HttpStatus.BAD_REQUEST);
	}
}
