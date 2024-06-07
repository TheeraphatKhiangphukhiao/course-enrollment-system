package com.example.ExampleAPI.student.business;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.ExampleAPI.student.json.CourseListJson;
import com.example.ExampleAPI.student.model.Course;
import com.example.ExampleAPI.student.payload.CoursePayload;
import com.example.ExampleAPI.student.service.CourseService;
 
@Service
public class CourseBusiness {
	@Autowired
	CourseService courseService;
	
	public CourseListJson getCourseId(long id) {
		return CourseListJson.packJson(courseService.findById(id));
	}
	public void saveCourse(CoursePayload coursePayload) {
		Course course = new Course(
				coursePayload.getName(),
				coursePayload.getDeparment()
				);
		courseService.save(course);
	}
	public void updateCourse(long id, CoursePayload coursePayload) {
		Course course = courseService.findById(id);
		course.setName(coursePayload.getName());
		course.setDepartment(coursePayload.getDeparment());
		
		courseService.save(course);
	}
	public void deleteCourse(long id) {
		courseService.deleteById(id);
	}
}
