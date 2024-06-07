package com.example.ExampleAPI.student.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.ExampleAPI.student.model.Enrolment;
import com.example.ExampleAPI.student.repository.EnrolmentRepository;
import com.example.ExampleAPI.student.service.impl.IEnrolment;

@Service
public class EnrolmentService implements IEnrolment{
	@Autowired
	EnrolmentRepository enrolmentRepository;

	@Override
	public List<Enrolment> findAllEnrolments() {
		// TODO Auto-generated method stub
		return enrolmentRepository.findAll();
	}

	@Override
	public Enrolment findById(long id) {
		// TODO Auto-generated method stub
		return enrolmentRepository.findById(id);
	}

	@Override
	public List<Enrolment> findByStudentId(long id) {
		// TODO Auto-generated method stub
		return enrolmentRepository.findByStudentId(id);
	}

	@Override
	public Enrolment findByCourseId(long id) {
		// TODO Auto-generated method stub
		return enrolmentRepository.findByCourseId(id);
	}

	@Override
	public Enrolment save(Enrolment enrolment) {
		// TODO Auto-generated method stub
		return enrolmentRepository.save(enrolment);
	}

	@Override
	public void deleteById(long id) {
		// TODO Auto-generated method stub
		enrolmentRepository.deleteById(id);
	}
	
	public Optional<Enrolment> findOptionalById(long id) {
		return enrolmentRepository.findOptionalById(id);
	}
}
