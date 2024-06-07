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
import com.example.ExampleAPI.student.business.StudentIDCardBusiness;
import com.example.ExampleAPI.student.exception.BaseException;
import com.example.ExampleAPI.student.json.StudentIDCardListJson;
import com.example.ExampleAPI.student.model.StudentIDCard;
import com.example.ExampleAPI.student.payload.StudentIDCardPayload;
import com.example.ExampleAPI.student.service.StudentIDCardService;

@RestController
@RequestMapping("/api")
public class StudentIDCardController {
	
	@Autowired
	StudentIDCardService stdIdCardService;
	
	@Autowired
	StudentIDCardBusiness stdIdCardBusiness;
	
	public StudentIDCardController(StudentIDCardService stdIdCardService) {
		this.stdIdCardService = stdIdCardService;
	}
	
	@PostMapping(value = "/card")
	public ResponseEntity<Void> saveStudentIDCard(@RequestBody StudentIDCardPayload studentIDCardPayload) throws BaseException {
		stdIdCardBusiness.saveStudentIDCard(studentIDCardPayload);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	@PutMapping(value = "/card/{id}")
	public ResponseEntity<StudentIDCardListJson> updateStudentIDCard(@PathVariable("id") long id, @RequestBody StudentIDCardPayload studentIDCardPayload) {
		Optional<StudentIDCard> studentIDCard = stdIdCardService.findOptionalById(id);
		if (studentIDCard.isPresent()) {
			stdIdCardBusiness.updateStudentIDCard(studentIDCard.get().getId(), studentIDCardPayload); 
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
		}
	}
	@DeleteMapping(value = "/card/{id}")
	public ResponseEntity<HttpStatus> deleteStudentIDCard(@PathVariable("id") long id) {
		try {
			stdIdCardBusiness.deleteStudentIDCard(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
