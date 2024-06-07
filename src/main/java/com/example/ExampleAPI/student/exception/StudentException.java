package com.example.ExampleAPI.student.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ResponseStatus(value = HttpStatus.NOT_FOUND)

public class StudentException extends BaseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public StudentException(String code, HttpStatus status) {
		super("status." + code, status);
	}

	public static StudentException emptyStudent() {
		return new StudentException("findStudent.notFound", HttpStatus.BAD_REQUEST);
	}

}
