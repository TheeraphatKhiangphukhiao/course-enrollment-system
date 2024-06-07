package com.example.ExampleAPI.student.service.impl;
import java.util.List;
import com.example.ExampleAPI.student.model.Enrolment;

public interface IEnrolment {
	List<Enrolment> findAllEnrolments();
	Enrolment findById(long id);
	List<Enrolment> findByStudentId(long id);
	Enrolment findByCourseId(long id);
	Enrolment save(Enrolment enrolment);
	void deleteById(long id); 
	
}
