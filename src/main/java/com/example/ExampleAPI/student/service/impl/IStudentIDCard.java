package com.example.ExampleAPI.student.service.impl; 
import java.util.List;
import com.example.ExampleAPI.student.model.StudentIDCard;

public interface IStudentIDCard {
	List<StudentIDCard> findAllStudentIdCards();
	StudentIDCard findById(long id);
	StudentIDCard findByCardNumberContaining(String name);
	StudentIDCard findByStudentId(long id);
	StudentIDCard save(StudentIDCard std);
	void deleteById(long id);
	
}
