package com.example.ExampleAPI.student.json;

import java.util.ArrayList;
import java.util.List;

import com.example.ExampleAPI.student.model.Student;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class StudentListJson {

	private long id;
	private String firstName;
	private String lastName;
	private String email;
	private int age;
	
	public static StudentListJson packJson(Student student) {
		
		StudentListJson slj = new StudentListJson();
		
		slj.setId(student.getId());
		slj.setFirstName(student.getFirstName());
		slj.setLastName(student.getLastName());
		slj.setEmail(student.getEmail());
		slj.setAge(student.getAge());
		
		return slj;
	}
	
	
	public static List<StudentListJson> packJsons(List<Student> students) {
		
		List<StudentListJson> studentListJson = new ArrayList<StudentListJson>();
		
		for (Student student : students) {
			studentListJson.add(packJson(student));
		}
		
		return studentListJson;
	}
	
}
