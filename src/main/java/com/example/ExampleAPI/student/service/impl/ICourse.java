package com.example.ExampleAPI.student.service.impl;
import java.util.List;
import com.example.ExampleAPI.student.model.Course;

public interface ICourse {
	List<Course> findAllCourses(); 
	Course findById(long id);
	Course findByNameContaining(String name);
	Course findByDepartmentContaining(String departmentName);
	Course save(Course course);
	void deleteById(long id);
}
