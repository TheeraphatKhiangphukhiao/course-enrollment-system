package com.example.ExampleAPI.student.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.ExampleAPI.student.model.Course;
import com.example.ExampleAPI.student.repository.CourseRepository;
import com.example.ExampleAPI.student.service.impl.ICourse;

@Service
public class CourseService implements ICourse{
	@Autowired
	CourseRepository courseRepository;

	@Override
	public List<Course> findAllCourses() {
		// TODO Auto-generated method stub
		return courseRepository.findAll();
	}

	@Override
	public Course findById(long id) {
		// TODO Auto-generated method stub
		return courseRepository.findById(id);
	}

	@Override
	public Course findByNameContaining(String name) {
		// TODO Auto-generated method stub
		return courseRepository.findByNameContaining(name);
	}

	@Override
	public Course findByDepartmentContaining(String departmentName) {
		// TODO Auto-generated method stub
		return courseRepository.findByDepartmentContaining(departmentName);
	}

	@Override
	public Course save(Course course) {
		// TODO Auto-generated method stub
		return courseRepository.save(course);
	}

	@Override
	public void deleteById(long id) {
		// TODO Auto-generated method stub
		courseRepository.deleteById(id);
	}
	public Optional<Course> findOptionalById(long id) {
		return courseRepository.findOptionalById(id);
	}
	
	
}
