package com.example.ExampleAPI.student.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.ExampleAPI.student.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long>{

	Course findById(long id);
	Course findByNameContaining(String name);
	Course findByDepartmentContaining(String name);
	Optional<Course> findOptionalById(long id);
}
