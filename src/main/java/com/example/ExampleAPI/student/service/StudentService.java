package com.example.ExampleAPI.student.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.ExampleAPI.student.model.Student;
import com.example.ExampleAPI.student.repository.StudentRepository;
import com.example.ExampleAPI.student.service.impl.IStudent;

@Service

public class StudentService implements IStudent{

	StudentRepository studentRepository;
	
	public StudentService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}
	
	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return studentRepository.findAll();
	}
	
	@Override
	public Student findById(long id) {
		// TODO Auto-generated method stub
		return studentRepository.findById(id);
	}
	
	@Override
	public Student findByEmail(String email) {
		// TODO Auto-generated method stub
		return studentRepository.findByEmail(email);
	}
	
	@Override
	public Student save(Student std) {
		// TODO Auto-generated method stub
		return studentRepository.save(std);
	}
	
	@Override
	public void deleteById(long id) {
		// TODO Auto-generated method stub
		studentRepository.deleteById(id);
	}
	
	public Optional<Student> findOptionalById(long id) {
		return studentRepository.findOptionalById(id);
	}

}

