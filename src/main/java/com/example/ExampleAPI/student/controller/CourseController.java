package com.example.ExampleAPI.student.controller;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.ExampleAPI.student.business.CourseBusiness;
import com.example.ExampleAPI.student.exception.BaseException;
import com.example.ExampleAPI.student.json.CourseListJson;
import com.example.ExampleAPI.student.model.Course;
import com.example.ExampleAPI.student.payload.CoursePayload;
import com.example.ExampleAPI.student.service.CourseService;

@RestController
@RequestMapping("/api")
public class CourseController {
	
	@Autowired
	CourseService courseService;
	
	@Autowired
	CourseBusiness courseBusiness;
	
	public CourseController(CourseService courseService) {
		this.courseService = courseService;
	}
	@PostMapping(value = "/course")
	public ResponseEntity<Void> saveCourse(@RequestBody CoursePayload coursePayload) throws BaseException {
		courseBusiness.saveCourse(coursePayload);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	@PutMapping(value = "/course/{id}")
	public ResponseEntity<CourseListJson> updateCourse(@PathVariable("id") long id, @RequestBody CoursePayload coursePayload) {
		Optional<Course> course = courseService.findOptionalById(id);
		if(course.isPresent()) {
			courseBusiness.updateCourse(course.get().getId(), coursePayload);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@DeleteMapping(value = "/course/{id}")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable("id") long id) {
		try {
			courseBusiness.deleteCourse(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
