package com.example.ExampleAPI.student.payload;
import com.example.ExampleAPI.student.model.Student;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BookPayload {
	private Student studentId; 
	private String bookName;
}
