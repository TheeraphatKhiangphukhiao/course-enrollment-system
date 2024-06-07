package com.example.ExampleAPI.student.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.ExampleAPI.student.model.Enrolment;

@Repository
public interface EnrolmentRepository extends JpaRepository<Enrolment, Long>{
	
	Enrolment findById(long id); 
	List<Enrolment> findByStudentId(long id);
	Enrolment findByCourseId(long id);
	Optional<Enrolment> findOptionalById(long id);
}
