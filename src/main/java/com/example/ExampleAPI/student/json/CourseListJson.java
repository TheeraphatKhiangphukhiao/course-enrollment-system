package com.example.ExampleAPI.student.json;
import java.util.ArrayList;
import java.util.List;
import com.example.ExampleAPI.student.model.Course;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class CourseListJson {
	private long id;
	private String name;
	private String department;
	
	public static CourseListJson packJson(Course course) {
		CourseListJson clj = new CourseListJson();
		clj.setId(course.getId());
		clj.setName(course.getName());
		clj.setDepartment(course.getDepartment());
		
		return clj;
	}
	public static List<CourseListJson> packJsons(List<Course> courses) {
		List<CourseListJson> clj = new ArrayList<CourseListJson>(); 
		for (Course course : courses) {
			clj.add(packJson(course));
		}
		return clj;
	}
}
