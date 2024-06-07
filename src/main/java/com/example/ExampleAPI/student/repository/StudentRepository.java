package com.example.ExampleAPI.student.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ExampleAPI.student.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
	
	Student findById(long id);
	Student findByEmail(String email);
	Optional<Student> findOptionalById(long id);
	
}

