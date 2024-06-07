package com.example.ExampleAPI.student.payload;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class StudentPayload {

	private String firstName;
	private String lastName;
	private String email;
	private int age;
	
}
