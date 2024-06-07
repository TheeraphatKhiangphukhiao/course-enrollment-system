package com.example.ExampleAPI.student.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ExampleAPI.student.json.StudentListJson;
import com.example.ExampleAPI.student.model.Student;
import com.example.ExampleAPI.student.payload.StudentPayload;
import com.example.ExampleAPI.student.service.StudentService;
 
@Service
public class StudentBusiness {
	@Autowired
	StudentService studentService;
	
	public List<StudentListJson> getListStudent() {
		return StudentListJson.packJsons(studentService.getAllStudents());
	}
	
	public StudentListJson getStudentId(long id) {
		return StudentListJson.packJson(studentService.findById(id));
	}
	
	public StudentListJson getStudentByEmail(String email) {
		return StudentListJson.packJson(studentService.findByEmail(email));
	}
	
	public void saveStudent(StudentPayload std) {
		Student student = new Student(
				std.getFirstName(),
				std.getLastName(),
				std.getEmail(),
				std.getAge());
		studentService.save(student);
	}
	
	public void updateStudent(long id, StudentPayload payload) {
		Student studentData = studentService.findById(id);
		
		studentData.setFirstName(payload.getFirstName());
		studentData.setLastName(payload.getLastName());
		studentData.setAge(payload.getAge());
		studentData.setEmail(payload.getEmail());
		
		studentService.save(studentData);
	}
	
	public void deleteStudent(long id) {
		studentService.deleteById(id);
	}
}
