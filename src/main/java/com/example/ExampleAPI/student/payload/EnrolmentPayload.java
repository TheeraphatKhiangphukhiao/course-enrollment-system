package com.example.ExampleAPI.student.payload;
import com.example.ExampleAPI.student.model.Course;
import com.example.ExampleAPI.student.model.Student;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EnrolmentPayload {
	private Student studentId;
	private Course courseId;
}
