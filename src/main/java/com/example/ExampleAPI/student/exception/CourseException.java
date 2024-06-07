package com.example.ExampleAPI.student.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ResponseStatus(value = HttpStatus.NOT_FOUND)

public class CourseException extends BaseException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CourseException(String code, HttpStatus status) {
		super("status" + code, status);
	}

	public static CourseException emptyCourse() {
		return new CourseException("findCourse.notFound", HttpStatus.BAD_REQUEST);
	}

}
