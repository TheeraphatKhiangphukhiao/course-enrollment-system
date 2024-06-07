package com.example.ExampleAPI.student.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.ExampleAPI.student.model.StudentIDCard;
import com.example.ExampleAPI.student.repository.StudentIDCardRepository;
import com.example.ExampleAPI.student.service.impl.IStudentIDCard;

@Service
public class StudentIDCardService implements IStudentIDCard{
	@Autowired
	StudentIDCardRepository studentIDCardRepository;

	@Override
	public List<StudentIDCard> findAllStudentIdCards() {
		// TODO Auto-generated method stub
		return studentIDCardRepository.findAll();
	}

	@Override
	public StudentIDCard findById(long id) {
		// TODO Auto-generated method stub
		return studentIDCardRepository.findById(id);
	}

	@Override
	public StudentIDCard findByCardNumberContaining(String name) {
		// TODO Auto-generated method stub
		return studentIDCardRepository.findByCardNumberContaining(name);
	}

	@Override
	public StudentIDCard findByStudentId(long id) {
		// TODO Auto-generated method stub
		return studentIDCardRepository.findByStudentId(id);
	}

	@Override
	public StudentIDCard save(StudentIDCard std) {
		// TODO Auto-generated method stub
		return studentIDCardRepository.save(std);
	}

	@Override
	public void deleteById(long id) {
		// TODO Auto-generated method stub
		studentIDCardRepository.deleteById(id);
	}
	
	public Optional<StudentIDCard> findOptionalById(long id) {
		return studentIDCardRepository.findOptionalById(id);
	}
	
	
}
